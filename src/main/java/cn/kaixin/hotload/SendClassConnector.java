package cn.kaixin.hotload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Yao Shuai
 * @date: 2020/4/3 16:07
 */
public class SendClassConnector {

    public static void main(String[] args) throws IOException {
        FileChannel channel = new FileInputStream(new File("h:\\sanguoQunYing\\server\\trunk\\main\\out\\ChatService.class")).getChannel();
        if (channel.size() > Short.MAX_VALUE) {
            System.err.println(channel.size() +"太大了");
        }
        ByteBuffer content = ByteBuffer.allocate((int) channel.size());
        channel.read(content);
        HotReloadSender sender = new HotReloadSender();
        sender.send("203.195.163.208", 8308, "cn.kx.lj.gameserver.chat.ChatService", content.array());
    }
}
