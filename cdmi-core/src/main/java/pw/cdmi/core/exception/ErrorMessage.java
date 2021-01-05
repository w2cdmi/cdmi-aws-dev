package pw.cdmi.core.exception;

public interface ErrorMessage {
    public long getCode();
    public String getMessage();
    public String getLogContent();

    public void setParams(Object... params);
}
