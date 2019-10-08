package cn.saatana.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SystemServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemServerApplication.class, args);
	}
}
