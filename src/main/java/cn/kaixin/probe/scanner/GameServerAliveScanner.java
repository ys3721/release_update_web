package cn.kaixin.probe.scanner;

import cn.kaixin.probe.model.ServerStatusInfo;
import cn.kaixin.utils.HttpUtil;
import cn.kaixin.utils.MD5Util;
import cn.kaixin.utils.NamedThreadFactory;
import cn.kaixin.utils.logger.Loggers;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Yao Shuai
 * <p>
 * 定时扫描server status service 中的服务器信息然后 发送报告
 */
public class GameServerAliveScanner {

    private ScheduledExecutorService executorService;

    private Map<Integer, ServerStatusInfo> statusInfoMap;

    private List<String> mobilesNum;

    public GameServerAliveScanner() {
        this.initMobiles();
        executorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("server status scanner"));
    }

    private void initMobiles() {
        //FIXME 这个地方做成读取文件 然后发送吧  作活哇
        this.mobilesNum = new ArrayList<>();
        this.mobilesNum.add("15811302052");
        this.mobilesNum.add("18600918912");
        this.mobilesNum.add("13212777262");
        this.mobilesNum.add("15300166100");
    }

    public void start(Map<Integer, ServerStatusInfo> serverStatusSource) {
        this.statusInfoMap = serverStatusSource;
        executorService.scheduleAtFixedRate(new CheckGameServerAliveTask(), 0, 5, TimeUnit.MINUTES);
    }

    public void stop() {
        executorService.shutdownNow();
    }

    private void sendServerDownMsg(int serverId) throws IOException {
        StringBuilder _sb = new StringBuilder();
        for (String num : this.getMobilesNum()) {
            _sb.append(num).append(",");
        }
        String numbers = _sb.deleteCharAt(_sb.length() - 1).toString();
        String sendMsgCmd = "sh /root/sendsms.sh " + numbers +
                String.format(" 服务器已经停止，请查看，serverid=%s，如果维护中请忽略本条消息！", serverId);
        Runtime.getRuntime().exec(sendMsgCmd);
        Loggers.probeLogger.error("send server down msg, cmd = " + sendMsgCmd);
    }

    private void sendDiskFullWarnMsg(int serverId) throws IOException {
        StringBuilder _sb = new StringBuilder();
        for (String num : this.getMobilesNum()) {
            _sb.append(num).append(",");
        }
        String numbers = _sb.deleteCharAt(_sb.length() - 1).toString();
        String sendMsgCmd = "sh /root/sendsms.sh " + numbers +
                String.format(" 服务器硬盘快满了，请查看，serverid=%s！", serverId);
        Runtime.getRuntime().exec(sendMsgCmd);
        Loggers.probeLogger.error("send server disk full msg, cmd = " + sendMsgCmd);
    }


    public List<String> getMobilesNum() {
        return mobilesNum;
    }

    public void setMobilesNum(List<String> mobilesNum) {
        this.mobilesNum = mobilesNum;
    }

    class CheckGameServerAliveTask implements Runnable {
        @Override
        public void run() {
            try {
                long nowMillis = System.currentTimeMillis();
                List<Integer> _needDel = new ArrayList<>();
                for (Map.Entry<Integer, ServerStatusInfo> _entry : GameServerAliveScanner.this.statusInfoMap.entrySet()) {
                    if ((_entry.getKey()+"").startsWith("9") || _entry.getKey() == 10086) {
                        continue;
                    }
                    ServerStatusInfo _statusInfo = _entry.getValue();
                    long lastTime = _statusInfo.getCreateTime();
                    if (lastTime != 0 && nowMillis - lastTime > TimeUnit.MINUTES.toMillis(15)) {
                        //给你们发短息
                        GameServerAliveScanner.this.sendServerDownMsg(_statusInfo.getServerId());
                        Loggers.probeLogger.error("发送通知短信出错！");
                        _needDel.add(_statusInfo.getServerId());
                    }
                    if (_statusInfo.getDiskUse() > 92) {
                        GameServerAliveScanner.this.sendDiskFullWarnMsg(_statusInfo.getServerId());
                        _needDel.add(_statusInfo.getServerId());
                    }
                }
                for (Integer _needDelId : _needDel) {
                    GameServerAliveScanner.this.statusInfoMap.remove(_needDelId);
                }
            } catch (Exception e) {
                Loggers.probeLogger.error("send sms err!", e);
            }
        }
    }

}
