package cn.kaixin.hotload;

import org.apache.mina.core.buffer.IoBuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author: Yao Shuai
 * @date: 2020/3/25 21:07
 */
public class HotReloadSender {

    /**
     *O
     * 		uuid = readLong();
     * 		fragmentCount = readInt();
     * 		fragmentOrder = readInt();
     * 		className = readString();
     * 		data = new byte[readInt()];
     * 		buf.get(data);
     * 		return true;
     * @param ip
     * @param port
     * @param className
     * @param codes
     */
    public void send(String ip, int port, String className, byte[] codes) {
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 1000);
            IoBuffer ioBuffer = IoBuffer.allocate(1024);
            ioBuffer.setAutoExpand(true);
            ioBuffer.putShort((short) 0);
            ioBuffer.putShort((short) 12982);
            ioBuffer.putLong(System.currentTimeMillis());
            ioBuffer.putInt(1);
            ioBuffer.putInt(0);
            byte[] nameByte = className.getBytes("UTF-8");
            ioBuffer.putShort((short) nameByte.length);
            ioBuffer.put(nameByte);
            ioBuffer.putInt(codes.length);
            ioBuffer.put(codes);
            ioBuffer.putShort(0, (short) (ioBuffer.limit() -2));
            ioBuffer.flip();
            socket.getOutputStream().write(ioBuffer.array());
            socket.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
