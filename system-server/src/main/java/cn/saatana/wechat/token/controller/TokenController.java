package cn.saatana.wechat.token.controller;

import cn.saatana.system.annotation.Guest;
import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.auth.entity.Authorizer;
import cn.saatana.system.auth.service.AuthorizerService;
import cn.saatana.system.config.AppProperties;
import cn.saatana.system.utils.SHAUtils;
import cn.saatana.system.utils.XmlUtils;
import cn.saatana.wechat.model.message.BaseMessage;
import cn.saatana.wechat.model.message.TextMessage;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@Guest
@RestController
@RequestMapping("/wechat")
@LogOparetion(value = "微型服务器token检验", ignore = true)
public class TokenController {
	private static final Logger log = Logger.getLogger(TokenController.class.getName());
	@Autowired
	private AppProperties app;
	@Autowired
	private AuthorizerService authService;

	@RequestMapping("token")
	public String index(String signature, String timestamp, String nonce, String echostr, String openid,
	                    HttpServletRequest request) throws NoSuchAlgorithmException, IOException, DocumentException {
		String res = "";
		if (echostr != null) {
			String[] arr = {app.getToken(), timestamp, nonce};
			Arrays.sort(arr);
			if (SHAUtils.encode(arr[0] + arr[1] + arr[2]).equals(signature)) {
				res = echostr;
			}
		} else {
			Map<String, String> map = XmlUtils.xmlToMap(request);
			String msgType = map.get("MsgType");
			TextMessage textMessage = new TextMessage(map);
			Authorizer auth = authService.getByOpenId(openid);
			switch (msgType) {
				case BaseMessage.TYPE_TEXT:
					log.info("收到用户消息：" + textMessage.getContent());
					textMessage.reverseUser();
					textMessage.setContent(textMessage.getContent().replace("向文可", "陈瑶"));
					res = textMessage.toString();
					break;
				case BaseMessage.TYPE_EVENT:
					String event = map.get("Event");
					switch (event) {
						case BaseMessage.EVENT_SUBSCIBE:
							textMessage.setContent("来了老弟");
							textMessage.reverseUser();
							res = textMessage.toString();
							log.info("用户关注：" + map.get("FromUserName"));

							if (auth == null) {
								auth = new Authorizer(openid);
								authService.create(auth);
							} else {
								authService.restore(auth);
							}
							break;
						case BaseMessage.EVENT_UNSUBSCIBE:
							textMessage.setContent("拜拜了您嘞");
							textMessage.reverseUser();
							res = textMessage.toString();
							log.info("取消关注：" + map.get("FromUserName"));

							if (auth != null) {
								authService.remove(auth);
							}
							break;
						case BaseMessage.EVENT_VIEW:
							// Safer.login(auth);
							break;
					}
					break;
			}
		}
		log.info("系统自动回复：" + res);
		return res;
	}
}
