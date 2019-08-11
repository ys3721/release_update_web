package cn.kaixin.model;

import java.sql.Date;

/**
 *
 * @author Yao Shuai
 *
 * select serverId, roleId, orderId, orderStatus, createTime, callbackTime, gold, fullCallbackData from t_orders where roleId
 */
public class OrderModel {

    private String orderId;

    private int serverId;

    private long roleId;

    private byte orderStatus;

    private Date createTime;

    private Date callbackTime;

    private int gold;

    private String fullCallbackData;

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getFullCallbackData() {
        return fullCallbackData;
    }

    public void setFullCallbackData(String fullCallbackData) {
        this.fullCallbackData = fullCallbackData;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "orderId=" + orderId + "</br> serverId=" + serverId + "</br> roleId=" + roleId + "</br> orderStatus=" + orderStatus + "</br> createTime=" + createTime + "</br> callbackTime=" + callbackTime + "</br> gold=" + gold + "</br> fullCallbackData='" + fullCallbackData + "</br>";
    }
}
