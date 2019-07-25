package cn.kaixin.probe;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Yao Shuai
 */
public class ProbeAction extends Action {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("''yyyy-MM-dd HH:mm:ss''");

    public ProbeAction() {
        super();
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SimpleActionForm probeForm = (SimpleActionForm) form;
        int serverId = probeForm.getServerId();
        int memory = probeForm.getMemory();
        int onlineCount = probeForm.getOnlineCount();
        int diskUse = probeForm.getDiskUse();
        String sql = String.format("insert into t_server_status (server_id, online_count, memory, disk_use, createTime) values( %s, %s, %s, %s, %s)", serverId+"", onlineCount+"", memory+"", diskUse+"",
                simpleDateFormat.format(new Timestamp(System.currentTimeMillis())));
        //先写道一起了   看看咋能抽象出dao
        Connection connection = this.getMysqlConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } finally {
            connection.close();
        }
        //插入数据库
        return mapping.findForward("success");
    }

    public Connection getMysqlConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/wg_lj_probe?useUnicode=true&characterEncoding=utf-8&useServerPrepStmts=true";
            conn = (Connection) DriverManager.getConnection(url, "root", "123456");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return conn;
    }
}
