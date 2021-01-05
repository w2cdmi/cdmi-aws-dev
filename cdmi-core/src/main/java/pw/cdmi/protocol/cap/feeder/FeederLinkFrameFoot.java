package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.Field;
import pw.cdmi.protocol.cap.FrameFoot;
import pw.cdmi.protocol.cap.SimpleFrameFootFormat;

/**
 * 馈电链路数据包中的帧尾是一个16字节的CRC校验字段
 * @Author 伍伟
 */
public class FeederLinkFrameFoot extends FrameFoot {
    /**
     * 馈电链路只有一个CRC字段，长度为16字节
     */
    private static SimpleFrameFootFormat format = new SimpleFrameFootFormat("0000000000000000");

    public FeederLinkFrameFoot() {
        super(format);
    }

    protected void setFoot(FootField field, String value) {
        super.setFoot(field.index, field.name(), value);
    }

    enum FootField implements Field {
        CRC(0);

        private int index;
        FootField(int index){
            this.index = index;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

    }
}
