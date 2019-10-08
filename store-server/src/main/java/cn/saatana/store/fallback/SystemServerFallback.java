package cn.saatana.store.fallback;

import cn.saatana.store.feign.SystemServer;
import org.springframework.stereotype.Component;

@Component
public class SystemServerFallback implements SystemServer {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}
}
