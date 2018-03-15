package topServer.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import topServer.service.DefaultService;
import topServer.type.URIGroupType;
import topServer.utils.URIUtils;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DefaultService defaultService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = defaultService.getURI(request);
		URIGroupType group = URIUtils.groupURI(uri);
		if(group == null) {
			logger.warn("【farword】:{}<={}", defaultService.getIP(), uri);
			request.getRequestDispatcher("/default").forward(request, response);
			return false;
		}
		if(!group.isLogFilte()) {
			logger.warn("【request】:{}=>{}", defaultService.getIP(request), uri);
		}
		return true;
	}
}
