package cn.saatana.config;

import cn.saatana.annotation.LogOparetion;
import cn.saatana.core.Safer;
import cn.saatana.entity.OparetionLog;
import cn.saatana.feign.system.LogFeign;
import cn.saatana.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Configuration
public class OparetionLogInterceptHandler extends HandlerInterceptorAdapter {
	private final Logger log = Logger.getLogger("GlobalInterceptHandler");
	@Autowired
	private LogFeign logFeign;
	@Autowired
	private AppProperties appProp;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = true;
		if (appProp.isLogOparetion() && handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Class<?> controller = method.getBeanType();
			LogOparetion canno = controller.getAnnotation(LogOparetion.class);
			LogOparetion manno = method.getMethodAnnotation(LogOparetion.class);
			OparetionLog oparetionLog = new OparetionLog();
			oparetionLog.setController(controller.getName());
			oparetionLog.setMethod(method.getMethod().getName());
			if (canno != null) {
				if (canno.ignore()) {
					return result;
				}
				oparetionLog.setControllerName(canno.value());
			}
			if (manno != null) {
				if (manno.ignore()) {
					return result;
				}
				oparetionLog.setMethodName(manno.value());
			}
			oparetionLog.setIp(IPUtils.getIP(request));
			logFeign.create(oparetionLog);
			log.fine("记录操作日志：" + oparetionLog.toString());
		}
		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
		Safer.restore();
		super.postHandle(request, response, handler, modelAndView);
	}

}
