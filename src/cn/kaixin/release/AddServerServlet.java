package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Yao Shuai
 *
 */
public class AddServerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String serverId = req.getParameter("serverId").toLowerCase();
        String domain = req.getParameter("domain").toLowerCase();
        String lanIp = req.getParameter("lanIp").toLowerCase();
        String wanIp = req.getParameter("wanIp").toLowerCase();
        String serverName = req.getParameter("prefix").toLowerCase();

        String content = String.format("%s 1 %s %s %s %s true\n", serverId, domain, lanIp, wanIp, serverName);

        File file = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR + serverName+".config");
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));

        writer.write(content);
        writer.flush();
        writer.close();

        resp.getWriter().println("OK:" + content);
        resp.getWriter().flush();
    }
}
