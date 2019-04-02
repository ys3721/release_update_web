package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ auther Yao Shuai
 *
 *  重新写写servlet吧。
 *  这个servlet想要查看当前的服务器列表
 *
 */
public class ServerListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        List<File> fileList = new ArrayList<>();
        File serversPath = new File(ReleaseServerConstants.SERVERS_CONFIG_DIR);
        for (File _file : serversPath.listFiles()) {
            if (_file.isFile() && _file.getName().endsWith("config")) {
                fileList.add(_file);
            }
        }
        response.getWriter().println("<html><body>");
        for (File _configFile : fileList) {
            response.getWriter().println(_configFile.getName()+"</br>");
        }
        response.getWriter().println("<a href=\"./add_server.html\">部署新服</a>");
        response.getWriter().println("</body></html>");

    }

}
