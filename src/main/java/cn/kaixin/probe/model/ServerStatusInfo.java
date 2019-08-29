package cn.kaixin.probe.model;

/**
 * @author Yao Shuai
 *
 */
public class ServerStatusInfo {

    /** Name */
    private int serverId;

    /** online count */
    private int onlineCount;

    /** used memeony */
    private int memory;

    /** 硬盘使用量 */
    private int diskUse;

    private long createTime;

    public ServerStatusInfo(int serverId, int onlineCount, int memory, int diskUse, long createTime) {
        this.serverId = serverId;
        this.onlineCount = onlineCount;
        this.memory = memory;
        this.diskUse = diskUse;
        this.createTime = createTime;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDiskUse() {
        return diskUse;
    }

    public void setDiskUse(int diskUse) {
        this.diskUse = diskUse;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
