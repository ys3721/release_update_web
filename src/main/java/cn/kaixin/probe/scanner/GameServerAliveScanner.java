package cn.kaixin.probe.scanner;

import cn.kaixin.probe.model.ServerStatusInfo;
import cn.kaixin.utils.HttpUtil;
import cn.kaixin.utils.MD5Util;
import cn.kaixin.utils.NamedThreadFactory;
import cn.kaixin.utils.logger.Loggers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        this.mobilesNum.add("13212777262");
        this.mobilesNum.add("15300166100");
        this.mobilesNum.add("15811302052");
        this.mobilesNum.add("18600918912");
    }

    public void start(Map<Integer, ServerStatusInfo> serverStatusSource) {
        this.statusInfoMap = serverStatusSource;
        executorService.scheduleAtFixedRate(new CheckGameServerAliveTask(), 0, 10, TimeUnit.SECONDS);
    }

    public void stop() {
        executorService.shutdownNow();
    }

    private void sendServerDownMsg(int serverId) {
        for (String num : this.getMobilesNum()) {
            try {
                this.reportServerDown(num, serverId);
            } catch (Exception e) {
                Loggers.probeLogger.error("发送服务器挂了的消息异常了",e);
                e.printStackTrace();
            }
        }
    }

    private void sendDiskFullWarnMsg(int serverId) {
        for (String num : this.getMobilesNum()) {
            try {
                this.reportDiskFull(num, serverId);
            } catch (Exception e) {
                Loggers.probeLogger.error("发送磁盘报警报错，serverid" + serverId, e);
                e.printStackTrace();
            }
        }
    }

    private void reportServerDown(String mobile, int serverId) throws IOException {
        if ((serverId + "").startsWith("9") || serverId == 10086) {
            return;
        }
        //FIXME 这个地方1908是写死的  要改成simple formate
        String md5key = MD5Util.createMD5String(mobile + "ASDxcv8234sfsj12" + "19-08");
        String content = "服务器挂了服务器id" + serverId;
        System.out.println("服务器挂了 " + serverId);
        String _url = String.format("http://interface.kaixin001.com/interface/sms/send.php?mobile=%s&content=\"%s\"&sig=%s&subnum=566002&monitor=base", mobile, content, md5key);
        HttpUtil.getUrl(_url, 5, false, null);
    }


    public void reportDiskFull(String mobile, int serverId) throws IOException {
        System.out.println("服务器的硬盘快满了，serverid=" + serverId);
        //FIXME 这个地方1908是写死的  要改成simple formate
        String md5key = MD5Util.createMD5String(mobile + "ASDxcv8234sfsj12" + "19-08");
        String content = "服务器的硬盘快满了，serverid=" + serverId;
        String _url = String.format("http://interface.kaixin001.com/interface/sms/send.php?mobile=%s&content=\"%s\"&sig=%s&subnum=566002&monitor=base", mobile, content, md5key);
        HttpUtil.getUrl(_url, 5, false, null);
    }

    public void reportServerDown(int serverId) throws IOException {
        if ((serverId + "").startsWith("9")) {
            return;
        }
        List<String> mobiles = new ArrayList<>();
        mobiles.add("15811302052");
        mobiles.add("13212777262");
        for (String mobile : mobiles) {
            this.reportServerDown(mobile, serverId);
        }
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
            long nowMillis = System.currentTimeMillis();
            for (Map.Entry<Integer, ServerStatusInfo> _entry : GameServerAliveScanner.this.statusInfoMap.entrySet()) {
                ServerStatusInfo _statusInfo = _entry.getValue();
                long lastTime = _statusInfo.getCreateTime();
                if (lastTime != 0 && nowMillis - lastTime > TimeUnit.MINUTES.toMillis(15)) {
                    //给你们发短息
                    GameServerAliveScanner.this.sendServerDownMsg(_statusInfo.getServerId());
                }
                if (_statusInfo.getDiskUse() > 92) {
                    GameServerAliveScanner.this.sendDiskFullWarnMsg(_statusInfo.getServerId());
                }
            }
        }
    }

}
