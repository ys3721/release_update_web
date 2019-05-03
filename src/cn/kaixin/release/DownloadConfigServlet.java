package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * 下载配置文件
 *
 */
public class DownloadConfigServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _configFileName = req.getParameter("file_name");
        resp.setContentType("application/jar");
        resp.addHeader("Content-Disposition", "attachment;filename="+_configFileName);
        FileInputStream _fis = new FileInputStream(new File(ReleaseServerConstants.SERVERS_CONFIG_DIR + _configFileName));

        OutputStream _outputStream = resp.getOutputStream();
        int read = 0;
        while ((read = _fis.read()) != -1) {
            _outputStream.write(read);
        }
        _outputStream.flush();
        _outputStream.close();

    }
}
