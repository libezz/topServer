package topServer.param;

import org.springframework.data.domain.Sort.Direction;

public class PageParam {

	private int page = 1;
	private int size = 10;
	private Direction sortDir = Direction.DESC;
	private String sortBy = "id";
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Direction getSortDir() {
		return sortDir;
	}
	public void setSortDir(Direction sortDir) {
		this.sortDir = sortDir;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
