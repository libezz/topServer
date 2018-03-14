package topServer.type;

public enum URIGroupType {

	MAIN(0, "index.html", false),
	DEFAULT(1, "default", true),
	HTML(101, "html", false),
	JS(102, "js", true),
	CSS(103, "css", true),
	IMG(201, "img", true),
	TEST(301, "test", false);
	
	private int value;
	private String name;
	private boolean logFilte;
	
	private URIGroupType(int value, String name, boolean logFilte) {
		this.value = value;
		this.name = name;
		this.logFilte = logFilte;
	}
	
	public static URIGroupType getTypeByName(String name) {
		for(URIGroupType type : values()) {
			if(type.getName().equals(name)) {
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
	public boolean isLogFilte() {
		return logFilte;
	}
	public void setLogFilte(boolean logFilte) {
		this.logFilte = logFilte;
	}
}
