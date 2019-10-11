package cn.saatana.wechat.button.controller;

import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.common.CurdController;
import cn.saatana.system.common.Res;
import cn.saatana.system.utils.HttpUtils;
import cn.saatana.wechat.Wechat;
import cn.saatana.wechat.button.entity.Button;
import cn.saatana.wechat.button.repository.ButtonRepository;
import cn.saatana.wechat.button.service.ButtonService;
import cn.saatana.wechat.token.entity.AccessToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/button")
@LogOparetion("微信公众号菜单按钮管理")
public class ButtonController extends CurdController<ButtonService, ButtonRepository, Button> {
	@RequestMapping("push")
	public Res<Integer> push() throws UnsupportedEncodingException {
		Res<Integer> res = null;
		List<Button> list = service.findList(new Button()).parallelStream().filter(item -> {
			return StringUtils.isEmpty(item.getPid());
		}).limit(3).collect(Collectors.toList());
		for (Button button : list) {
			button.setUrl(String.format(
					"https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo#wechat_redirect",
					appProp.getAppid(), URLEncoder.encode(button.getUrl(), "utf-8")));
			log.info(button.getButtonKey() + "\t" + button.getUrl());
			if (button.getChildren().size() > 5) {
				button.getChildren().subList(0, 5);
			}
		}
		Map<String, List<Button>> map = new HashMap<>();
		map.put("button", list);
		AccessToken token = HttpUtils.post(
				"https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + Wechat.getAccessToken(), null, null,
				AccessToken.class);
		if (token.success()) {
			token = HttpUtils.post(
					"https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + Wechat.getAccessToken(), null, map,
					AccessToken.class);
			if (token.success()) {
				res = Res.ok(0);
			} else {
				res = Res.error("添加菜单失败：" + token.getErrmsg(), token.getErrcode());
			}
		} else {
			res = Res.error("删除菜单失败：" + token.getErrmsg(), token.getErrcode());
		}
		return res;
	}
}
