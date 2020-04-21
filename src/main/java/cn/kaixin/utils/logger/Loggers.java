package cn.kaixin.utils.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Loggers {

    public static final Logger probeLogger = LogManager.getLogger("release.probe");

    public static final Logger hotLoadLogger = LogManager.getLogger("release.hotreload");
}
