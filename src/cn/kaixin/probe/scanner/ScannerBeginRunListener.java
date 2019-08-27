package cn.kaixin.probe.scanner;

import cn.kaixin.probe.constants.ProbeConstants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Yao Shuai
 */
public class ScannerBeginRunListener implements ServletContextListener {

    private GameServerAliveScanner scanner;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //status service
        ServerStatusService serverStatusService = new ServerStatusService();
        servletContextEvent.getServletContext().setAttribute(ProbeConstants.SERVER_STATUS_SERVICE_NAME, serverStatusService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        scanner.stop();
    }
}
