package cn.kaixin.probe.scanner;

import cn.kaixin.probe.model.ServerStatusInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yao Shuai
 *
 */
public class ServerStatusService {

    private Map<Integer, ServerStatusInfo> serverStatusInfoMap;

    private GameServerAliveScanner statusScanner;

    public ServerStatusService() {
        this.serverStatusInfoMap = new ConcurrentHashMap<>();
        this.statusScanner = new GameServerAliveScanner();
        this.statusScanner.start(serverStatusInfoMap);
    }

    /**
     * 记录每个服务器的状态到内存中
     *
     */
    public void recordServerStatus(int serverId, int onlineCount, int memory, int diskUse, long timeMillis) {
        ServerStatusInfo statusInfo = new ServerStatusInfo(serverId, onlineCount, memory, diskUse, timeMillis);
        this.getServerStatusInfoMap().put(statusInfo.getServerId(), statusInfo);
    }

    public Map<Integer, ServerStatusInfo> getServerStatusInfoMap() {
        return serverStatusInfoMap;
    }


    public void stop() {
        statusScanner.stop();
    }
}
