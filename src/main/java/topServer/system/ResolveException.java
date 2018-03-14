package topServer.system;

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
	
	@ExceptionHandler(TopServerMissing.class)
	@ResponseBody
	public BaseResult resolveTopServerMissing(Exception e) {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result, ResultStatusType.MISSING);
		logger.warn("【missing】:{}=>{}", baseService.getIP(), baseService.getURI());
		return result;
	}
	
	@ExceptionHandler(TopServerException.class)
	@ResponseBody
	public BaseResult resolveTopServerException(Exception e) {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result, ResultStatusType.THROW, e.getMessage());
		logger.warn("【{}】:{}=>{}", e.getMessage(), baseService.getIP(), baseService.getURI());
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResult resolveException(Exception e) {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result, ResultStatusType.EXCEPTION);
		logger.warn("【{}】:{}=>{}, {}", e.getClass().getName(), baseService.getIP(), baseService.getURI(), e.getMessage());
		return result;
	}
}
