package cn.saatana;

import cn.saatana.feign.system.AuthFeign;
import cn.saatana.feign.system.TestFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableHystrix
@EnableFeignClients(clients = {TestFeign.class, AuthFeign.class})
//@EnableCircuitBreaker
public class StoreServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreServerApplication.class, args);
	}
}
