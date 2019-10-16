package cn.saatana.feign.system;

import cn.saatana.fallback.system.TestFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Component
@FeignClient(contextId = "testFeign",value = "system-server",fallback = TestFeignFallback.class)
public interface TestFeign {
	@RequestMapping("/test/hi")
	String testHi(@RequestParam String name);
}
