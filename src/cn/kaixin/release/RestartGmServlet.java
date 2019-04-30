package cn.kaixin.release;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class RestartGmServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Process process = Runtime.getRuntime().exec("shutdown.sh", null, new File("/data0/apache-tomcat-7.0.39/bin/"));
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String cmd = "ps -elf |grep /data0/apache-tomcat-7.0.39/temp | grep -v grep | awk '{print $4}' |xargs kill";
        Runtime.getRuntime().exec(cmd);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().println("<html><body>");
        Process process1 = Runtime.getRuntime().exec("startup.sh", null, new File("/data0/apache-tomcat-7.0.39/bin/"));
        BufferedReader b = new BufferedReader(new InputStreamReader(process1.getInputStream()));
        String out;
        while ((out = b.readLine()) != null) {
            resp.getWriter().write(out+"</br>");
            resp.flushBuffer();
        }
        resp.getWriter().write("gm后台已经重启，稍后去gm后台是否启动！"+"</br>");
    }

}
