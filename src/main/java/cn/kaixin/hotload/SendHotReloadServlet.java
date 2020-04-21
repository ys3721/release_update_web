package cn.kaixin.hotload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Yao Shuai
 * @date: 2020/3/26 15:49
 */
public class SendHotReloadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clazzName = req.getParameter("className");
        String clazzContent = req.getParameter("classContent");
    }

}
