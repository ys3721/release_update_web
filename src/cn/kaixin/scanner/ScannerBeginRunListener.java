package cn.kaixin.scanner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Yao Shuai
 */
public class ScannerBeginRunListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        GameServerAliveScanner serverAliveScanner = new GameServerAliveScanner();
        serverAliveScanner.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
