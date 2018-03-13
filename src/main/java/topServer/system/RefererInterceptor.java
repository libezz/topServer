package topServer.system;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import topServer.service.BaseService;

@Component
public class RefererInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BaseService baseService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = baseService.getURI();
		if("/index.html".equals(uri) || "/".equals(uri)) {
			logRequest();
			return true;
		}
		String referer = request.getHeader("referer");
		if(StringUtils.isBlank(referer)) {
			response.sendRedirect("/");
			return false;
		}
		String refHost = new URL(referer).getHost();
		String reqHost = new URL(request.getRequestURL().toString()).getHost();
		if(reqHost.equals(refHost)) {
			logRequest();
			return true;
		} else {
			response.sendRedirect("/");
			return false;
		}
	}
	
	public void logRequest() {
		logger.warn("remoteIp:{}, URI:{}", baseService.getIp(), baseService.getURI());
	}
}
