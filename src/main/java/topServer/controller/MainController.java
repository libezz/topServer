package topServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topServer.result.BaseResult;
import topServer.service.MainService;
import topServer.type.ResultStatusType;

@RestController
public class MainController {
	
	@Autowired
	private MainService mainService;

	@RequestMapping("/test")
	public BaseResult getTest() {
		BaseResult result = new BaseResult();
		mainService.setResultDes(result, ResultStatusType.MISSING);
		return result;
	}
}
