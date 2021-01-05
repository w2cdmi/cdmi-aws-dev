package pw.cdmi.core.http.rs;

import pw.cdmi.core.exception.HttpClientException;
import pw.cdmi.core.exception.HttpServiceException;
import pw.cdmi.core.http.MediaFormat;

public abstract class AbstractContentParser<T> {
	
	
	public T parseRequest(byte[] in, MediaFormat format) throws HttpClientException{
		if (MediaFormat.XML.equals(format)) {
			return this.parseXML(in);
		} else {
			return this.parseJSON(in);
		}
	}
	
	public byte[] toBytes4Response(T t, MediaFormat format) throws HttpServiceException{
		if (MediaFormat.XML.equals(format)) {
			return this.toXML(t);
		} else {
			return this.toJSON(t);
		}
	}
	
	protected abstract T parseXML(byte[] in) throws HttpClientException;
	
	protected abstract T parseJSON(byte[] in) throws HttpClientException;
	
	protected abstract byte[] toXML(T t) throws HttpServiceException;
	
	protected abstract byte[] toJSON(T t) throws HttpServiceException;
	
}
