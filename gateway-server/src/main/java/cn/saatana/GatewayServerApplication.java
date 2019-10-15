package cn.saatana.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Autowired
	private TokenFilter tokenFilter;
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/system/**").filters(f -> f.stripPrefix(1)).uri("lb://SYSTEM-SERVER").filters(tokenFilter))
				.route(r -> r.path("/store/**").filters(f -> f.stripPrefix(1)).uri("lb://STORE-SERVER").filters(tokenFilter))
				.build();
	}
}
