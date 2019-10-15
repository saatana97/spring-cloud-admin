package cn.saatana.feign;

import cn.saatana.fallback.SystemServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "system-server", fallback = SystemServerFallback.class)
public interface SystemServer {
	@RequestMapping("/test/hi")
	String testHi(@RequestParam String name);
}
