package cn.saatana.system.auth.controller;

import cn.saatana.annotation.Guest;
import cn.saatana.annotation.LogOparetion;
import cn.saatana.common.CurdController;
import cn.saatana.common.Res;
import cn.saatana.core.Safer;
import cn.saatana.entity.AuthorizationInformation;
import cn.saatana.entity.Authorize;
import cn.saatana.system.auth.repository.AuthorizeRepository;
import cn.saatana.system.auth.service.AuthorizeService;
import cn.saatana.utils.MD5Utils;
import cn.saatana.wechat.Wechat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
@LogOparetion("登陆授权")
public class AuthorizeController extends CurdController<AuthorizeService, AuthorizeRepository, Authorize> {

	@Guest
	@PostMapping("login")
	@LogOparetion("登陆")
	public Res<AuthorizationInformation> login(@RequestBody Authorize user) {
		Res<AuthorizationInformation> res = Res.error(null);
		if (StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getCode())) {
			String openId = Wechat.getOpenIdByCode(user.getCode());
			if (StringUtils.isEmpty(openId)) {
				log.info("获取openId失败，默认加载admin用户");
				openId = "oRwbN5vw8GHu7HaN-Rj8inHKeGPw";
			}
			Authorize auth = service.getByOpenId(openId);
			if (auth == null) {
				auth = new Authorize(openId);
				service.create(auth);
			} else if (!auth.isNormal()) {
				service.restore(auth);
			}
			res = Res.ok(Safer.login(auth));
		} else {
			Authorize entity = service.getByUsername(user.getUsername());
			if (user.getPassword() != null) {
				if (user.getPassword().length() < 32) {
					user.setPassword(MD5Utils.encode(user.getPassword()));
				}
				if (entity != null && entity.getPassword().equals(user.getPassword())) {
					AuthorizationInformation userInfo = Safer.login(entity);
					entity.setLoginDate(new Date());
					service.update(entity, false);
					res = Res.ok("登陆成功", userInfo);
				} else {
					res = Res.error("用户名或密码不匹配", null);
				}
			}
		}
		return res;
	}

	@RequestMapping("logout")
	@LogOparetion("注销")
	public Res<String> logout() {
		Safer.logout();
		return Res.ok("你已经注销登录");
	}

	@RequestMapping("permission/{permission}")
	@LogOparetion("权限判断")
	public Res<Boolean> hasPermission(@PathVariable String permission) {
		return Res.ok(Safer.isSuperAdmin() || Safer.hasPromission(permission));
	}
}
