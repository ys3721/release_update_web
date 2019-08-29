package cn.kaixin.probe;

import cn.kaixin.model.OrderModel;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/*
 * 这个是用来查订单的
 *
 *
 * +---------------------+--------------+------+-----+---------+----------------+
| Field               | Type         | Null | Key | Default | Extra          |
+---------------------+--------------+------+-----+---------+----------------+
| id                  | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| callbackTime        | datetime     | YES  | MUL | NULL    |                |
| characterData       | text         | YES  |     | NULL    |                |
| chargeKindID        | int(11)      | YES  |     | NULL    |                |
| chargePlatformMoney | int(11)      | YES  |     | NULL    |                |
| createTime          | datetime     | YES  |     | NULL    |                |
| environment         | varchar(255) | YES  |     | NULL    |                |
| fullCallbackData    | text         | YES  |     | NULL    |                |
| gameID              | int(11)      | YES  |     | NULL    |                |
| gold                | int(11)      | YES  |     | NULL    |                |
| orderId             | varchar(255) | YES  | MUL | NULL    |                |
| orderStatus         | int(11)      | YES  | MUL | NULL    |                |
| otherInfo           | text         | YES  |     | NULL    |                |
| passportId          | bigint(20)   | YES  | MUL | NULL    |                |
| platformId          | int(11)      | YES  |     | NULL    |                |
| platformMoney       | int(11)      | YES  |     | NULL    |                |
| platformUid         | varchar(255) | YES  |     | NULL    |                |
| realMoney           | int(11)      | YES  |     | 0       |                |
| roleId              | bigint(20)   | YES  | MUL | NULL    |                |
| serverId            | int(11)      | YES  |     | NULL    |                |
+---------------------+--------------+------+-----+---------+----------------+
20 rows in set (0.01 sec)
 *
 */
public class QueryOrderById extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        QueryOrderIdForm orderIdForm = (QueryOrderIdForm) form;
        long roleId = Long.parseLong(orderIdForm.getRoleId());
        String sql = String.format("select serverId, roleId, orderStatus, createTime, callbackTime, gold, fullCallbackData, orderId from t_orders where roleId = %s", roleId);
        //先写道一起了   看看咋能抽象出dao
        Connection connection = this.getMysqlConnection();
        List<OrderModel> orderModelList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OrderModel orderModel = new OrderModel();
                orderModel.setServerId(resultSet.getInt(1));
                orderModel.setRoleId(resultSet.getLong(2));
                orderModel.setOrderStatus((byte) resultSet.getInt(3));
                orderModel.setCreateTime(resultSet.getDate(4));
                orderModel.setCallbackTime(resultSet.getDate(5));
                orderModel.setGold(resultSet.getInt(6));
                orderModel.setFullCallbackData(resultSet.getString(7));
                orderModel.setOrderId(resultSet.getString(8));
                orderModelList.add(orderModel);
            }
        } finally {
            connection.close();
        }
        request.setAttribute("orderModelList", orderModelList);
        //插入数据库
        return mapping.findForward("orderList");
    }

    public Connection getMysqlConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/game_center?useUnicode=true&characterEncoding=utf-8&useServerPrepStmts=true";
            conn = (Connection) DriverManager.getConnection(url, "root", "123456");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return conn;
    }
}
