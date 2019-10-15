package cn.saatana;

import cn.saatana.feign.SystemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	//	@Resource(type = SystemServer.class)
	@Autowired
	private SystemServer systemServer;
//	private RestTemplate rest;

	@RequestMapping("hi")
//	@HystrixCommand(fallbackMethod = "errorHandler", ignoreExceptions = ArithmeticException.class)
	public String index(String name) {
//		return rest.getForObject("http://system-server/test/hi?name=" + name, String.class);
		return systemServer.testHi(name);
	}

//	public String errorHandler(String name, Throwable e) {
//		return "Services are busy:" + e.getMessage();
//	}
}
