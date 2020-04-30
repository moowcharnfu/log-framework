package cn.com.tcsl.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackLog {
    // 正常日志
    private static Logger logger = LoggerFactory.getLogger(LogBackLog.class);
    // 业务日志
    private static Logger bussiness = LoggerFactory.getLogger("bussiness");

    public static void main(String[] args) {
        try {
            if (logger.isTraceEnabled()) {
                logger.trace("logback...[{}]", "trace");
            }
            if (logger.isDebugEnabled()) {
                logger.debug("logback...[{}]", "debug");
            }
            if (logger.isInfoEnabled()) {
                logger.info("logback...[{}]", "info");
            }
            if (logger.isWarnEnabled()) {
                logger.warn("logback...[{}]", "warn");
            }
            if (logger.isErrorEnabled()) {
                logger.error("logback...[{}]", "error");
            }
            // 测试过滤
            logger.info("测试过滤：password:{}", "123456");
            logger.info("测试过滤：pwd:{}", "123456");
            logger.info("测试过滤：pass:{}", "123456");
            // 业务日志
            bussiness.info("业务日志打印、、、、、");
            /*
            // 测试日志备份
            while (true) {
                logger.debug("自动打印...[{}]", "debug");
                bussiness.info("业务自动打印、、、、、");
            }
            */
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 其他操作
        }
    }
}
