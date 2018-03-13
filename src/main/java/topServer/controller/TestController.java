package topServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/to{test}")
	public String getTest(@PathVariable String test, HttpServletRequest request) {
		String text = request.getParameter("text");
		if(StringUtils.isNotBlank(text)) {
			return text;
		}
		return test;
	}
}
