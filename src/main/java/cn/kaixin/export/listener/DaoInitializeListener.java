package cn.kaixin.export.listener;

import cn.kaixin.export.dao.ExportDaoService;
import cn.kaixin.export.dao.SessionFactoryManager;
import cn.kaixin.probe.constants.ProbeConstants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Yao Shuai
 *
 */
public class DaoInitializeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ExportDaoService exportDaoService = new ExportDaoService();
        servletContextEvent.getServletContext().setAttribute(ProbeConstants.SERVER_DAO_INIT_NAME, exportDaoService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
