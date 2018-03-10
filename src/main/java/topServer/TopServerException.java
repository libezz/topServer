package topServer;

public class TopServerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TopServerException() {
		super();
	}
	
	public TopServerException(String des) {
		super(des);
	}
	
	@Override
	public String toString() {
		return super.getLocalizedMessage();
	}
}
