package topServer.type;

public enum LogFilteType {

	IMG(0, "/img/"),
	JS(1, "/js/"),
	CSS(2, "/css/");
	
	private int value;
	private String filte;
	
	private LogFilteType(int value, String filte) {
		this.value = value;
		this.filte = filte;
	}
	
	public LogFilteType getType(int value) {
		for(LogFilteType type : values()) {
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
	public String getFilte() {
		return filte;
	}
	public void setFilte(String filte) {
		this.filte = filte;
	}
}
