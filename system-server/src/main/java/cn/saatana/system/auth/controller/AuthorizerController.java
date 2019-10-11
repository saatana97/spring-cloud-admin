package cn.saatana.system.auth.controller;

import cn.saatana.system.Safer;
import cn.saatana.system.annotation.Guest;
import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.auth.entity.AuthorizationInformation;
import cn.saatana.system.auth.entity.Authorizer;
import cn.saatana.system.auth.repository.AuthorizerRepository;
import cn.saatana.system.auth.service.AuthorizerService;
import cn.saatana.system.common.CurdController;
import cn.saatana.system.common.Res;
import cn.saatana.system.utils.MD5Utils;
import cn.saatana.wechat.Wechat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
@LogOparetion("登陆授权")
public class AuthorizerController extends CurdController<AuthorizerService, AuthorizerRepository, Authorizer> {

	@Guest
	@PostMapping("login")
	@LogOparetion("登陆")
	public Res<AuthorizationInformation> login(@RequestBody Authorizer user) {
		Res<AuthorizationInformation> res = Res.error(null);
		if (StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getCode())) {
			String openId = Wechat.getOpenIdByCode(user.getCode());
			if (StringUtils.isEmpty(openId)) {
				log.info("获取openId失败，默认加载admin用户");
				openId = "oRwbN5vw8GHu7HaN-Rj8inHKeGPw";
			}
			Authorizer auth = service.getByOpenId(openId);
			if (auth == null) {
				auth = new Authorizer(openId);
				service.create(auth);
			} else if (!auth.isNormal()) {
				service.restore(auth);
			}
			res = Res.ok(Safer.login(auth));
		} else {
			Authorizer entity = service.getByUsername(user.getUsername());
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
