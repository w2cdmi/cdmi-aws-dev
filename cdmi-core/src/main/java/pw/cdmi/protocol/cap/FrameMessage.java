package pw.cdmi.protocol.cap;

public abstract class FrameMessage {
    private int length;
    private FrameHeader header;
    private FrameFoot foot;

    public FrameMessage(int length){
        this.length = length;
    }

    protected void setFrameHeader(FrameHeader header){
        this.header = header;
    }
    protected void setFrameFoot(FrameFoot foot){
        this.foot = foot;
    }

    protected FrameHeader getFrameHeader(){
        return this.header;
    }

    protected FrameFoot getFrameFoot(){
        return this.foot;
    }

    /**
     * 获取数据帧的总长度
     * @return
     */
    public int length(){
        return this.length;
    }

    /**
     * 获取数据帧中的数据包总长度
     * @return
     */
    public abstract int getPacketSize();

    /**
     * 获取数据帧中的数据包中可容纳的业务数据最大长度
     * @return
     */
    public abstract int getContentSize();
}
