package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yao Shuai
 *
 */
public class RunDeployServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String server_prefix1 = req.getParameter("serverId1").trim().toLowerCase();
        String server_prefix2 = req.getParameter("serverId2").trim().toLowerCase();
        String server_prefix3 = req.getParameter("serverId3").trim().toLowerCase();
        String server_prefix4 = req.getParameter("serverId4").trim().toLowerCase();

        if (server_prefix1.isEmpty()) {
            return;
        }
        List<String> servers = new ArrayList<>();
        servers.add(server_prefix1);
        if (!server_prefix2.isEmpty()) {
            servers.add(server_prefix2);
        }
        if (!server_prefix3.isEmpty()) {
            servers.add(server_prefix3);
        }
        if (!server_prefix4.isEmpty()) {
            servers.add(server_prefix4);
        }
        String servers_str = "";
        for (String server:  servers) {
            servers_str += server + " ";
        }
        String command = String.format("python add_some_server.py %s", servers_str);
        Process process = Runtime.getRuntime().exec(command, null, new File(ReleaseServerConstants.WORK_BASE_DIR));
        //try {
            //process.waitFor();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        PrintWriter printWriter = new PrintWriter(process.getOutputStream());
        printWriter.write("y\n");
        printWriter.flush();

        String _password = req.getServletContext().getInitParameter("ck");
        printWriter.write(_password+"\n");
        printWriter.flush();

        printWriter.write("y\n");
        printWriter.flush();

        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().println("<html><body>");
        BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String out;
        while ((out = b.readLine()) != null) {
            resp.getWriter().write(out+"</br>");
            resp.flushBuffer();
        }
        resp.getWriter().write("gm后台已经重启，稍后去gm后台看看游戏服是否启动！"+"</br>");
        resp.getWriter().println("</body></html>");
    }
}
