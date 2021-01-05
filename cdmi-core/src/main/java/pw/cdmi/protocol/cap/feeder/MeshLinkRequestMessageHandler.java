package pw.cdmi.protocol.cap.feeder;

import pw.cdmi.protocol.cap.MessageHandler;
import pw.cdmi.protocol.cap.SimplePacketHeaderFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 对运行在馈电上行链路中的注链路组网数据的控制处理
 *
 * @param <T> 代表要上注的链路组网数据类型,这里T应该对应明确的类型
 */
public class MeshLinkRequestMessageHandler<T> implements MessageHandler<T> {
    private final static SimplePacketHeaderFormat format = new SimplePacketHeaderFormat("000000-00000-0000");
    private MeshLinkRequestMessage message = new MeshLinkRequestMessage();
    private MeshLinkRequestPacketHeader header = new MeshLinkRequestPacketHeader(format);

    private T object;

    public MeshLinkRequestMessageHandler(T object) {
        this.object = object;
        //TODO 提取信息保存到帧头/包头中
        //将数据封装进数据帧
        List<MeshLinkRequestMessage> list = wrap(object);
        //逐次发送链路组网数据帧
        for (MeshLinkRequestMessage message : list) {

        }
    }

    /**
     * 将要上注的链路组网数据分解为若干了上注数据帧
     *
     * @param objct
     * @return
     */
    private List<MeshLinkRequestMessage> wrap(T objct) {
        //获取可填充的业务数据包大小
        int max_size = message.getContentSize();
        //计算要传输的业务数据字节数
        byte[] content = new byte[2024];
        int i = 0;
        if (content.length % max_size != 0) {
            i = (int) (content.length / max_size) + 1;
        } else {
            i = content.length / max_size;
        }
        //将业务数据包拆分
        List<MeshLinkRequestMessage> list = new ArrayList<MeshLinkRequestMessage>();
        for (int j = 0; j < i; j++) {
            //根据上注数据编码后的大小，将上注数据拆分为多个数据帧
            byte[] slice = new byte[max_size]; //FIXME 最后的一个数组可能不是max_size这么大
            System.arraycopy(content, j, slice, 0, max_size);
            MeshLinkRequestMessage message = new MeshLinkRequestMessage();
            //设置Packet包头
            header.setTotal(i);
            header.setSequence(j);
            //设置数据帧中的Packet包数据块
            message.setBody(slice);
            //TODO 计算帧尾CRC,确保数据一致性
            list.add(message);
        }
        return list;
    }
}
