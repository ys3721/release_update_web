package cn.kaixin.release;

import cn.kaixin.release.constants.ReleaseServerConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author yaoshuai
 *
 * servlet is a funny thing.
 *
 */
public class ShowUpdatePackage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File _updatePath = new File(ReleaseServerConstants.UPDATE_BASE_DIR);

        String[] _targetUpdateFile = _updatePath.list(new FilenameFilter() {
            private Pattern _pattern = Pattern.compile("\\*.zip");
            @Override
            public boolean accept(File dir, String name) {
                return _pattern.matcher(dir.getName()).matches();
            }
        });

        if (_targetUpdateFile.length != 1) {
            resp.getWriter().println("Error！deploy zip！");
            return;
        }

        req.setAttribute("package", _targetUpdateFile[0]);

        RequestDispatcher _view = req.getRequestDispatcher("");

    }

}
