package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.Field;
import pw.cdmi.protocol.cap.FrameHeader;
import pw.cdmi.protocol.cap.SimpleFrameHeaderFormat;

public class FeederLinkFrameHeader extends FrameHeader {
    private static SimpleFrameHeaderFormat format = new SimpleFrameHeaderFormat("0000-00-0-0000");
    private static String FRAME_HEADER_UNIQUE = "01001000";

    public FeederLinkFrameHeader() {
        super(format);
        this.setHeader(HeaderField.UNIQUE, FRAME_HEADER_UNIQUE);
    }

    protected void setHeader(HeaderField field, String value) {
        super.setHeader(field.index, field.name(), value);
    }

    public void setTarget(String value){
        this.setHeader(HeaderField.TARGET, value);
    }

    public void setSrc(String value){
        this.setHeader(HeaderField.SRC, value);
    }

    public void setType(String value){
        this.setHeader(HeaderField.TYPE, value);
    }

    public void setCst(String value){
        this.setHeader(HeaderField.CST, value);
    }

    enum HeaderField implements Field {
        UNIQUE(0),
        TARGET(1),
        SRC(2),
        TYPE(3),
        CST(4);

        private int index;
        HeaderField(int index){
            this.index = index;
        }

        @Override
        public int getIndex(){
            return this.index;
        }

    }
}
