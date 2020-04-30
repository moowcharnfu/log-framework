package cn.com.tcsl.log;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Log4j1Log {
    // 正常日志
    private static Logger logger = Logger.getLogger(Log4j1Log.class);
    // 业务日志
    private static Logger bussiness = Logger.getLogger("bussiness");

    public static void main(String[] args) {
        try {
            if (logger.isTraceEnabled()) {
                logger.trace("log4j2......[trace]");
            }
            if (logger.isDebugEnabled()) {
                logger.debug("log4j2......[debug]");
            }
            if (logger.isInfoEnabled()) {
                logger.info("log4j2......[info]");
            }
            if (logger.isEnabledFor(Priority.WARN)) {
                logger.warn("log4j2......[warn]");
            }
            if (logger.isEnabledFor(Priority.ERROR)) {
                logger.error("log4j2......[error]");
            }
            if (logger.isEnabledFor(Priority.FATAL)) {
                logger.fatal("log4j2......[fatal]");
            }
            // 测试过滤
            logger.info("测试过滤：password: 123456");
            logger.info("测试过滤：pwd: 123456");
            logger.info("测试过滤：pass: 123456");
            // 业务日志
            bussiness.info("业务日志打印、、、、、");
            /*
            while (true) {
                logger.debug("自动打印...[debug]");
                bussiness.info("业务自动打印、、、、、");
            }
            */
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 其他操作
        }
    }
}
