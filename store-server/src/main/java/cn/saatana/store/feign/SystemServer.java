package cn.saatana.store.feign;

import cn.saatana.store.fallback.SystemServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "system-server", fallback = SystemServerFallback.class)
public interface SystemServer {
	@RequestMapping("/test/hi")
	String testHi(@RequestParam String name);
}
