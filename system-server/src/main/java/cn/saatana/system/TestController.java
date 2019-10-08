package cn.saatana.system;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	@Value("${server.port}")
	private String port;

	@RequestMapping("hi")
	public String index(String name) {
		return "Hello," + name + "\tMy port is " + port;
	}
}
