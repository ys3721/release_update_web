package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (int) (o1.lastModified() - o2.lastModified());
            }
        });
        List<String> names = new ArrayList<>();
        for (File _configFile : fileList) {
            names.add(_configFile.getName());
        }
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String _index = o1.substring(1, o1.indexOf("."));
                String _index2 = o2.substring(1, o2.indexOf("."));
                int _indexInt = 0;
                int _index2Int = 0;
                try {
                    _indexInt = Integer.parseInt(_index);
                } catch (NumberFormatException e) {
                    return -1;
                }
                try {
                    _index2Int = Integer.parseInt(_index2);
                } catch (NumberFormatException e) {
                    return 1;
                }

                return  _indexInt - _index2Int;
            }
        });
        response.getWriter().println("<html><body>");
        for (String _fileName : names) {
            response.getWriter().println(_fileName+"</br>");
        }
        response.getWriter().println("<a href=\"./add_server.html\">来，添加服务器配置</a>");
        response.getWriter().println("</body></html>");

    }

}
