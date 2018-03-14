package topServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import topServer.system.TopServerMissing;

public class BaseController {

	@RequestMapping("/**")
	public void getMissing() throws TopServerMissing {
		throw new TopServerMissing();
	}
}
