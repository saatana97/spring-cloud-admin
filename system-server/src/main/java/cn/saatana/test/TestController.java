package cn.saatana.test;

import cn.saatana.annotation.Guest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Guest
public class TestController {
	@RequestMapping("hi")
	public String hi(String name) {
		return "Hello," + name;
	}
}
