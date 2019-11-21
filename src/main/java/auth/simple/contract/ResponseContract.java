package auth.simple.contract;

public class ResponseContract<T> {
	private String code;
	private String message;
	private T response;
	
	public ResponseContract(String code, String message, T response) {
		this.code = code;
		this.message = message;
		this.response = response;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
}
