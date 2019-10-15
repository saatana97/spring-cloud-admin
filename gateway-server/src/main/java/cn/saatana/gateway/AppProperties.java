package cn.saatana.gateway;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	/**
	 * 是否开启授权TOKEN验证
	 */
	private boolean enableSafer = true;
	/**
	 * 是否记录请求的详细信息
	 */
	private boolean logRequestInfo = true;
	/**
	 * 是否记录操作日志
	 */
	private boolean logOparetion = true;
	/**
	 * 是否允许本地跨域请求
	 */
	private boolean allowLocalCrossDomain = false;
}
