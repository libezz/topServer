package topServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topServer.result.BaseResult;
import topServer.service.BaseService;
import topServer.system.TopServerException;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/getTest")
	public BaseResult getTest() {
		BaseResult result = new BaseResult();
		baseService.setResultDes(result);
		return result;
	}
	
	@RequestMapping("/getTSException")
	public void getTSException() throws TopServerException {
		throw new TopServerException("TopServerException");
	}
	
	@RequestMapping("/getException")
	public void getException() {
		int index = 0;
		index = 100 / index;
	}
}
