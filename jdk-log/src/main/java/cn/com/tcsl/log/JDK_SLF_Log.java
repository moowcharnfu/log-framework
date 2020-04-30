package cn.com.tcsl.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDK_SLF_Log {
    private static Logger logger = LoggerFactory.getLogger(JDK_SLF_Log.class);

    public static void main(String[] args) {
        // jdkLog没有trace和debug方法, 采用slf4j之后trace和debug直接不适用，印证缺点拓展性比较差
        if (logger.isTraceEnabled()) {
            logger.trace("JDK_SLF_Log...[{}]", "trace");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("JDK_SLF_Log...[{}]", "debug");
        }
        if (logger.isInfoEnabled()) {
            logger.info("JDK_SLF_Log...[{}]", "info");
        }
        if (logger.isWarnEnabled()) {
            logger.warn("JDK_SLF_Log...[{}]", "warn");
        }
        if (logger.isErrorEnabled()) {
            logger.error("JDK_SLF_Log...[{}]", "error");
        }
    }
}
