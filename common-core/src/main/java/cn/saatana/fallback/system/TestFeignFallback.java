package cn.saatana.fallback.system;

import cn.saatana.feign.system.TestFeign;
import org.springframework.stereotype.Component;

@Component
public class TestFeignFallback implements TestFeign {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}
}
