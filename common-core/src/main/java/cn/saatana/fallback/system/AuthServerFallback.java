package cn.saatana.fallback.system;

import cn.saatana.feign.system.AuthServer;
import org.springframework.stereotype.Component;

@Component
public class AuthServerFallback implements AuthServer {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}
}
