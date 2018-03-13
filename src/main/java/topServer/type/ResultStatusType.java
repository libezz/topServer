package topServer.type;

public enum ResultStatusType {

	SUCCEED(0, "请求成功"),
	THROW(1, "参数异常"),
	EXCEPTION(2, "系统繁忙");
	
	private int value;
	private String name;
	
	private ResultStatusType(int value, String name) {
		this.value = value;
		this.name= name;
	}
	
	public static ResultStatusType getType(int value) {
		for(ResultStatusType type : values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
