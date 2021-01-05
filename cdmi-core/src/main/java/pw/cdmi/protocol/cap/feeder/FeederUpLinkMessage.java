package pw.cdmi.protocol.cap.feeder;

/**
 * 馈电上行链路数据包格式
 */
public abstract class FeederUpLinkMessage extends FeederLinkMessage {
    private static String FRAME_HEADER_SRC = "1100000";

    public FeederUpLinkMessage() {
        super();
        this.setSrc(FRAME_HEADER_SRC);
    }

    @Override
    public void setTarget(String value) {
        this.setFrameHeadField(FeederLinkFrameHeader.HeaderField.TARGET, value);
    }

    @Override
    protected void setSrc(String value) {
        this.setFrameHeadField(FeederLinkFrameHeader.HeaderField.SRC, value);
    }

}
