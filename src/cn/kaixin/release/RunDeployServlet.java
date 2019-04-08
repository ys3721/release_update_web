package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yao Shuai
 *
 */
public class RunDeployServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String server_prefix1 = req.getParameter("serverId1");
        String server_prefix2 = req.getParameter("serverId2");
        String server_prefix3 = req.getParameter("serverId3");
        String server_prefix4 = req.getParameter("serverId4");

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
        printWriter.write("y\n");
        printWriter.flush();
        printWriter.write("P7QQQo5o1yx9\n");
        printWriter.flush();
        BufferedReader b = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String out;
        while ((out = b.readLine()) != null) {
            resp.getWriter().write(out);
        }
        BufferedReader e = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String eo;
        while ((eo = b.readLine()) != null) {
            resp.getWriter().write(eo);
        }
    }
}
