package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.FrameMessage;

/**
 * 馈电链路基础数据包格式
 * 该数据帧数据格式为：
 * 帧头包含了4个字段，每个字段所占字节空间如下：
 * PRE字段4个字节
 * FRAID字段1个字节
 * SOW字段1个字节
 * TYPE字段为2个字节
 * PERSION字段为8个字节
 */
public abstract class FeederLinkMessage extends FrameMessage {

    private final static int FRAME_LENGTH = 168; //消息体的大小
    private FeederLinkFrameHeader header = new FeederLinkFrameHeader();
    private FeederLinkFrameFoot foot = new FeederLinkFrameFoot();

    public FeederLinkMessage() {
        super(FRAME_LENGTH);
        this.setFrameHeader(header);
        this.setFrameFoot(foot);
    }

    protected void setFrameHeadField(FeederLinkFrameHeader.HeaderField field, String value){
        header.setHeader(field,value);
    }

    protected void setFrameFootField(FeederLinkFrameFoot.FootField field, String value){
        foot.setFoot(field,value);
    }

    protected abstract void setTarget(String value);

    protected abstract void setSrc(String value);

    @Override
    public int getPacketSize(){
        return this.length() - header.length() - foot.length();
    }
}
