package cn.saatana.fallback;

import cn.saatana.feign.SystemServer;
import org.springframework.stereotype.Component;

@Component
public class SystemServerFallback implements SystemServer {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}
}
