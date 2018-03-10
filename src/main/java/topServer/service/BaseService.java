package topServer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import topServer.param.PageParam;
import topServer.result.BaseResult;
import topServer.type.ResultStatusType;
import topServer.utils.IpUtils;

public class BaseService {

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public String getIp() {
		return IpUtils.getIp(getRequest());
	}
	
	public Pageable checkPage(PageParam param) {
		
		Sort sort = new Sort(param.getSortDir(), param.getSortBy());
		return PageRequest.of(param.getPage(), param.getSize(), sort);
	}
	
	public boolean setResultDes(BaseResult result, ResultStatusType type, String des) {
		result.setDes(des);
		result.setStatus(type.getValue());
		return true;
	}
	
	public boolean setResultDes(BaseResult result, ResultStatusType type) {
		return setResultDes(result, type, type.getName());
	}
	
	public boolean setResultDes(BaseResult result) {
		return setResultDes(result, ResultStatusType.SUCCEED);
	}
}
