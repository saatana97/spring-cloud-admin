package cn.saatana.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/system/**").filters(f -> f.stripPrefix(1)).uri("lb://SYSTEM-SERVER"))
				.route(r -> r.path("/store/**").filters(f -> f.stripPrefix(1)).uri("lb://STORE-SERVER"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
}
