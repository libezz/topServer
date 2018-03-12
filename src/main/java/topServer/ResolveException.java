package topServer;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import topServer.result.BaseResult;
import topServer.service.BaseService;
import topServer.type.ResultStatusType;

@ControllerAdvice
public class ResolveException {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BaseService baseService;
	
	@ExceptionHandler(TopServerException.class)
	@ResponseBody
	public BaseResult resolveTopServerException(Exception e) {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result, ResultStatusType.THROW, e.getMessage());
		HttpServletRequest request = baseService.getRequest();
		logger.warn("=======>{}<=======", ResultStatusType.THROW.getName());
		logger.warn("remoteIp:{}, URI:{}, exception:{}", baseService.getIp(), request.getRequestURI(), e.getMessage());
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResult resolveException(Exception e) {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result, ResultStatusType.EXCEPTION);
		HttpServletRequest request = baseService.getRequest();
		logger.warn("=======>{}<=======", e.getClass().getName());
		logger.warn("remoteIp:{}, URI:{}, exception:{}", baseService.getIp(), request.getRequestURI(), e.getMessage());
		return result;
	}
}
