package topServer.system;

public class TopServerMissing extends Exception {

	private static final long serialVersionUID = 1L;

	public TopServerMissing() {
		super();
	}
	
	public TopServerMissing(String des) {
		super(des);
	}
}
