package pw.cdmi.protocol.cap;

import java.util.HashMap;
import java.util.Map;

public class PacketHeader {
    private SimplePacketHeaderFormat format;
    private Map<String, String> headers = new HashMap<String, String>();
    private String[] fieldItems;

    public PacketHeader(SimplePacketHeaderFormat format){
        this.format = format;
        this.fieldItems = new String[format.length()];
    }

    public void setHeader(int index, String field, String value) {
        if(index < 0 || index > fieldItems.length){
            throw new FrameFormatException("数据帧头字段的位置索引超过了数据帧头定义的字段数量");
        }
        this.fieldItems[index] = field;
        this.headers.put(field, value);
    }
}
