package pw.cdmi.core.exception;

public class HttpClientException extends RuntimeException {
	private static final long serialVersionUID = 1117719315295737835L;

	public HttpClientException(ErrorMessage error){
        super(error.getMessage());
    }

    public HttpClientException(ErrorMessage error, Object... params){
        super(error.getMessage());
        error.setParams(params);
    }
}
