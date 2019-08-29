package cn.kaixin.release.listener.model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author yaoshuai
 *
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        String bread = sc.getInitParameter("bread");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
