package topServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topServer.result.BaseResult;
import topServer.service.DefaultService;
import topServer.type.ResultStatusType;

@RestController
@RequestMapping("/default")
public class DefaultController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DefaultService defaultService;
	
	@RequestMapping("/unrole")
	public BaseResult getUnrole() {
		BaseResult result = new BaseResult();
		defaultService.setResultDes(result, ResultStatusType.UNROLE);
		logger.warn("【unrole】:{}=>{}", defaultService.getIP(), defaultService.getURI());
		return result;
	}
}
