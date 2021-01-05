package pw.cdmi.core.exception;

public class HttpServiceException extends RuntimeException {
    public HttpServiceException(ErrorMessage error){
        super(error.getMessage());
    }

    public HttpServiceException(ErrorMessage error, String... params){
        super(error.getMessage());
        error.setParams(params);
    }
}
