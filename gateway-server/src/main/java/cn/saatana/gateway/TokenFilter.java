package cn.saatana.gateway;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class TokenFilter implements GatewayFilter, Ordered {
	private final Logger log = Logger.getLogger("TokenFilter");
	@Autowired
	private AppProperties appProp;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		ServerHttpResponse response = exchange.getResponse();
		// 允许本地请求跨域访问
		if (appProp.isAllowLocalCrossDomain() && request.getRemoteAddress().equals("0:0:0:0:0:0:0:1")) {
			response.getHeaders().add("Access-Control-Allow-Origin", "*");
		}
		// 设置响应类型及编码
		response.setStatusCode(HttpStatus.OK);
		response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		// 获取TOKEN
		String token = request.getQueryParams().getFirst("token");
		if (StringUtils.isEmpty(token)) {
			HttpCookie cookie = request.getCookies().getFirst("token");
			if (cookie != null) {
				token = cookie.getValue();
			}
		}
		log.info(request.getPath().toString() + "\t" + token);
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return -200;
	}
}
