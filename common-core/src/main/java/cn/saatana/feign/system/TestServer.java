package cn.saatana.feign.system;

import cn.saatana.fallback.system.TestServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "system-server",name = "TestFeign",fallback = TestServerFallback.class)
public interface TestServer {
	@RequestMapping("/test/hi")
	String testHi(@RequestParam String name);
}
