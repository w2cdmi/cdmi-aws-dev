package pw.cdmi.utils;

public class UnsupportedByteLengthException  extends IllegalArgumentException {
    public UnsupportedByteLengthException(String desc){
        super(desc);
    }
}
