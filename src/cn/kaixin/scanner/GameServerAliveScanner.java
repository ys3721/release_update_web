package cn.kaixin.scanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class GameServerAliveScanner {

    private ScheduledExecutorService executorService;

    public GameServerAliveScanner() {
        executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                SecurityManager s = System.getSecurityManager();
                ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
                String namePrefix = "scanner game server alive pool thread";
                Thread t = new Thread(group, r, namePrefix, 0);
                if (t.isDaemon())
                    t.setDaemon(false);
                if (t.getPriority() != Thread.NORM_PRIORITY)
                    t.setPriority(Thread.NORM_PRIORITY);
                return t;
            }
        });
    }

    public void start() {
        //FIXME 这个地方主要是如果抛出异常 周期执行就停止了 这个要研究研究。
        //问题2 如何让这个代码上来就启动的问题
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Connection _connection = null;
                try {
                    long nowTime = System.currentTimeMillis();
                    String sql = "select server_id, disk_use, createTime from (select * from t_server_status order by createTime desc) as a group by server_id";
                    _connection = GameServerAliveScanner.this.getMysqlConnection();
                    PreparedStatement _ps =_connection.prepareStatement(sql);
                    ResultSet _resultSet = _ps.executeQuery();
                    while(_resultSet.next()) {
                        int serverId = _resultSet.getInt(1);
                        int diskUse = _resultSet.getInt(2);
                        Date _datetime = _resultSet.getDate(3);
                        if (diskUse > 90) {
                            GameServerAliveScanner.this.reportDiskFull(serverId);
                        }
                        if (nowTime - _datetime.getTime() > TimeUnit.MINUTES.toMillis(15)) {
                            GameServerAliveScanner.this.reportServerDown(serverId);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(_connection != null) {
                        try {
                            _connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },0,1, TimeUnit.SECONDS);
    }

    public void stop() {

    }

    public void reportDiskFull(int serverId) throws IOException {
        System.out.println("服务器的硬盘快满了，serverid=" + serverId);
        String mobile = "15811302052";
        //FIXME 这个地方1908是写死的  要改成simple formate
        String md5key = MD5Util.createMD5String(mobile+"ASDxcv8234sfsj12"+"19-08");
        String content = "服务器的硬盘快满了，serverid="+serverId;
        String _url = String.format("http://interface.kaixin001.com/interface/sms/send.php?mobile=15811302052&content=\"%s\"&sig=%s&subnum=566002&monitor=base", content, md5key);
        HttpUtil.getUrl(_url, 5, false, null);
    }

    public static void  reportServerDown(int serverId) throws IOException {
        if ((serverId+"").startsWith("9")) {
            return;
        }
        String mobile = "15811302052";
        //FIXME 这个地方1908是写死的  要改成simple formate
        String md5key = MD5Util.createMD5String(mobile+"ASDxcv8234sfsj12"+"19-08");
        String content = "服务器挂了 服务器id"+serverId;
        System.out.println("服务器挂了 " + serverId);
        String _url = String.format("http://interface.kaixin001.com/interface/sms/send.php?mobile=15811302052&content=\"%s\"&sig=%s&subnum=566002&monitor=base", content, md5key);
        HttpUtil.getUrl(_url, 5, false, null);
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
