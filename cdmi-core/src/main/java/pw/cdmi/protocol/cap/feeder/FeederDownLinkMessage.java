package pw.cdmi.protocol.cap.feeder;

/**
 * 馈电下行链路数据包格式
 */
public abstract class FeederDownLinkMessage extends FeederLinkMessage {
    private final static String FRAME_HEADER_TARGET = "1100000";

    public FeederDownLinkMessage(){
        super();
        this.setSrc(FRAME_HEADER_TARGET);
    }

    @Override
    protected void setTarget(String value) {
        this.setFrameHeadField(FeederLinkFrameHeader.HeaderField.TARGET, value);
    }

    @Override
    public void setSrc(String value) {
        this.setFrameHeadField(FeederLinkFrameHeader.HeaderField.SRC, value);
    }

}
