package cn.saatana.fallback.system;

import cn.saatana.feign.system.AuthServer;
import cn.saatana.feign.system.TestServer;
import org.springframework.stereotype.Component;

@Component
public class TestServerFallback implements TestServer {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}
}
