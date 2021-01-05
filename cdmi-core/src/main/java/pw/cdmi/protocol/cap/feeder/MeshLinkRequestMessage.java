package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.Field;
import pw.cdmi.protocol.cap.PacketHeader;
import pw.cdmi.protocol.cap.SimplePacketHeaderFormat;
import pw.cdmi.utils.ByteUtils;

import java.util.Date;

/**
 * 馈电上行链路执行上注链路组网数据的传输数据帧格式
 */
public class MeshLinkRequestMessage extends FeederUpLinkMessage{
    /** 馈电链路上行握手数据包中与基础类相比需补充的固定字段值**/
    private static String FRAME_HEADER_TYPE = "010101000";
    private static String PACKET_HEADER_TYPE = "010101000";
    private static String PACKET_HEADER_SECURITY = "0x67FD";
    private static SimplePacketHeaderFormat format = new SimplePacketHeaderFormat("00-0000-0");

    private MeshLinkPactetHeader header = new MeshLinkPactetHeader(format);

    public MeshLinkRequestMessage(){
        super();
        FeederLinkFrameHeader frame = (FeederLinkFrameHeader)super.getFrameHeader();
        frame.setHeader(FeederLinkFrameHeader.HeaderField.TYPE, FRAME_HEADER_TYPE);
        header.setHeader(PactetHeaderField.TYPE, PACKET_HEADER_TYPE);
        header.setHeader(PactetHeaderField.SECRIT, PACKET_HEADER_SECURITY);
    }

    public void setTaskDate(Date date){
        //任务时间转化为16进制字符串
        String hexCode = ByteUtils.toHexString(date, 3, false);
        //将16进制字符串设置给
        header.setHeader(PactetHeaderField.TASKTIME, hexCode);
    }

    /**
     * 设置传输数据帧中的业务数据
     * @param content
     */
    public void setBody(byte[] content){
        //将T对象进行编码
    }

    /**
     * 获取上注链路组网数据帧中可容纳的业务数据字节数
     * @return
     */
    @Override
    public int getContentSize() {
        return getPacketSize() - format.length();
    }

    class MeshLinkPactetHeader extends PacketHeader {
        public MeshLinkPactetHeader(SimplePacketHeaderFormat format){
            super(format);
        }

        public void setHeader(PactetHeaderField field, String value){
            super.setHeader(field.index, field.name(), value);
        }
    }

    enum PactetHeaderField implements Field {
        SECRIT(0),
        TASKTIME(1),
        TYPE(2);

        private int index;

        private PactetHeaderField(int index){
            this.index = index;
        }

        @Override
        public int getIndex(){
            return this.index;
        }
    }
}
