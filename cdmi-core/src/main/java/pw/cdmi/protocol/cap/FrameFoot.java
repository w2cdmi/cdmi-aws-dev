package pw.cdmi.protocol.cap;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据帧帧尾基类
 * @Author 伍伟
 * @Date 2020-09-21
 */
public abstract class FrameFoot {
    private SimpleFrameFootFormat format;
    private Map<String, String> headers = new HashMap<String, String>();
    private String[] fieldItems;

    public FrameFoot(SimpleFrameFootFormat format){
        this.format = format;
        this.fieldItems = new String[format.length()];
    }

    public void setFoot(int index, String field, String value) {
        if(index < 0 || index > fieldItems.length){
            throw new FrameFormatException("数据帧尾字段的位置索引超过了数据帧尾定义的字段数量");
        }
        this.fieldItems[index] = field;
        this.headers.put(field, value);
    }

    public int length(){
        return format.length();
    }
}
