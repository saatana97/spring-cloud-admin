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
/**
 *  TODO
 *  启动时报错循环依赖，问题出在common-core两个拦截器上，删掉可解决问题
 *  指定要使用的FeignClient也可以解决问题，不能全包扫描，指定basePackage也没用
 */
@EnableFeignClients(clients = {TestFeign.class, AuthFeign.class})
//@EnableCircuitBreaker
public class StoreServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreServerApplication.class, args);
	}
}
