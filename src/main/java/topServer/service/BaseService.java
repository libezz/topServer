package topServer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import topServer.param.PageParam;
import topServer.result.BaseResult;
import topServer.system.TopServerException;
import topServer.type.ResultStatusType;
import topServer.type.SortByType;
import topServer.type.SortDirType;
import topServer.utils.IPUtils;

public class BaseService {

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public String getURI(HttpServletRequest request) {
		return request.getRequestURI();
	}
	
	public String getURI() {
		return getURI(getRequest());
	}
	
	public HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	
	public HttpSession getSession() {
		return getSession(getRequest());
	}
	
	public String getIP(HttpServletRequest request) {
		return IPUtils.getIP(request);
	}
	
	public String getIP() {
		return getIP(getRequest());
	}
	
	public Pageable checkPage(PageParam param) throws TopServerException {
		int page = param.getPage();
		int size = param.getSize();
		if(page < 0 || size <= 0) {
			throw new TopServerException("分页参数异常");
		}
		SortDirType sortDir = SortDirType.getType(param.getSortDir());
		SortByType sortBy = SortByType.getType(param.getSortBy());
		if(sortDir == null || sortBy == null) {
			throw new TopServerException("排序参数异常");
		}
		return  PageRequest.of(page, size, sortDir.getSortDir(), sortBy.getSortBy());
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
