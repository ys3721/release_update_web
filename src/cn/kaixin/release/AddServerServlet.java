package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.regex.Pattern;

/**
 *
 * @author Yao Shuai
 *
 */
public class AddServerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String serverId = req.getParameter("serverId").toLowerCase();
        String domain = req.getParameter("domain").toLowerCase().trim().replace("wss://","");
        String lanIp = req.getParameter("lanIp").toLowerCase();
        String wanIp = req.getParameter("wanIp").toLowerCase();
        String serverName = req.getParameter("prefix").toLowerCase();

        String content = String.format("%s 1 %s %s %s %s true\n", serverId, domain, lanIp, wanIp, serverName);

        String[] configFileStrs = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern pattern = Pattern.compile("\\w*.config");
                return pattern.matcher(name).matches();
            }
        });

        for (String configFileName : configFileStrs) {
            File file = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR+configFileName);
            if(file.isFile()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String configLine = bufferedReader.readLine();
                String[] configSplit = configLine.split("\\s+");
                if (configSplit.length < 6) {
                    continue;
                }
                if(configSplit[3].trim().equals(lanIp) || configSplit[4].trim().equals(wanIp)) {
                    resp.setHeader("Content-Type","text/html;charset=UTF-8");
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println(String.format("<p>ERROR!:IP已经存在不能覆盖！！%s %s %s", configFileName, lanIp,wanIp));
                    resp.getWriter().println("</body></html>");
                    return;
                }
                if (configSplit[0].equals(serverId)) {
                    resp.setHeader("Content-Type","text/html;charset=UTF-8");
                    resp.getWriter().println("<html><body>");
                    resp.getWriter().println(String.format("<p>ERROR!:SERVER_ID已经存在不能覆盖！！%s %s", configFileName, serverId));
                    resp.getWriter().println("</body></html>");
                    return;
                }

            }
        }

        File file = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR + serverName+".config");
        if (file.exists()) {
            resp.setHeader("Content-Type","text/html;charset=UTF-8");
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("<p>ERROR!:同名配置文件已经存在不能覆盖！！");
            resp.getWriter().println("</body></html>");
        }
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));

        writer.write(content);
        writer.flush();
        writer.close();

        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<p>OK:" + content+"");
        resp.getWriter().println("<p><a href=\"./add_server.html\">继续添加服务器配置</a></p>");
        resp.getWriter().println("<p><a href=\"./index.html\">不加了，回主页</a></p>");
        resp.getWriter().println("</body></html>");

        resp.getWriter().flush();
    }
}
