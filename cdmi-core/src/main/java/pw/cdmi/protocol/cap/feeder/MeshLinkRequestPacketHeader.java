package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.Field;
import pw.cdmi.protocol.cap.PacketHeader;
import pw.cdmi.protocol.cap.SimplePacketHeaderFormat;

/**
 * 对运行在馈电上行链路中的注链路组网的数据帧内容包头的封装
 */
public class MeshLinkRequestPacketHeader extends PacketHeader {
    public MeshLinkRequestPacketHeader(SimplePacketHeaderFormat format) {
        super(format);
    }

    protected void setHeader(HeaderField field, String value) {
        super.setHeader(field.index, field.name(), value);
    }

    public void setTaskId(String value){
        this.setHeader(HeaderField.TASKID, value);
    }

    public void setTotal(int value){
        this.setHeader(HeaderField.TOTAL, String.valueOf(value));
    }

    public void setSequence(int value){
        this.setHeader(HeaderField.SEQUENCE, String.valueOf(value));
    }

    enum HeaderField implements Field {
        TASKID(0),
        TOTAL(1),
        SEQUENCE(2);

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
