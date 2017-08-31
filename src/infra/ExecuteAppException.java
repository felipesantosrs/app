package infra;

public class ExecuteAppException extends Exception {

	private static final long serialVersionUID = -4537456045712235890L;
	
	
	public ExecuteAppException() {

	}

	public ExecuteAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExecuteAppException(String message) {
		super(message);
	}

	public ExecuteAppException(Throwable cause) {
		super(cause);
	}

}
