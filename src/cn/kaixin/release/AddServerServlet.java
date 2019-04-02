package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AddServerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String serverId = req.getParameter("serverId");
        String domain = req.getParameter("domain");
        String lanIp = req.getParameter("lanIp");
        String wanIp = req.getParameter("wanIp");
        String serverName = req.getParameter("prefix");

        String content = String.format("%s 1 %s %s %s %s true", serverId, domain, lanIp, wanIp, serverName);

        File file = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR+serverName+".config");
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));

        writer.write(content);
        writer.flush();
        writer.close();

        resp.getWriter().println("OK:" + content);
        resp.getWriter().flush();
    }
}
