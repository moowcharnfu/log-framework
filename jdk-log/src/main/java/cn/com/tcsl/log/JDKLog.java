package cn.com.tcsl.log;

import java.io.File;
import java.util.logging.*;

public class JDKLog {
    private static Logger logger = Logger.getLogger("JDKLog");

    public static void main(String[] args) {
        // jdkLog日志级别, 默认info
        if (logger.isLoggable(Level.SEVERE)) {
            logger.severe("hello，jdkLog【7】");
        }
        if (logger.isLoggable(Level.WARNING)) {
            logger.warning("hello，jdkLog【6】");
        }
        if (logger.isLoggable(Level.INFO)) {
            logger.info("hello，jdkLog【5】");
        }
        if (logger.isLoggable(Level.CONFIG)) {
            logger.config("hello，jdkLog【4】");
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("hello，jdkLog【3】");
        }
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("hello，jdkLog【2】");
        }
        if (logger.isLoggable(Level.FINEST)) {
            logger.finest("hello，jdkLog【1】");
        }
        // 调整到级别, 输出全部级别日志
        setConsoleLevel(logger, Level.ALL);
        if (logger.isLoggable(Level.FINEST)) {
            logger.finest("当前日志级别为：" + logger.getLevel().getName());
        }
        if (logger.isLoggable(Level.SEVERE)) {
            logger.severe("again，jdkLog【7】");
        }
        if (logger.isLoggable(Level.WARNING)) {
            logger.warning("again，jdkLog【6】");
        }
        if (logger.isLoggable(Level.INFO)) {
            logger.info("again，jdkLog【5】");
        }
        setConsoleLevel(logger, Level.CONFIG);
        if (logger.isLoggable(Level.CONFIG)) {
            logger.config("again，jdkLog【4】");
        }
        setConsoleLevel(logger, Level.FINE);
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("again，jdkLog【3】");
        }
        setConsoleLevel(logger, Level.FINER);
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("again，jdkLog【2】");
        }
        setConsoleLevel(logger, Level.FINEST);
        setFileLevel(logger, Level.FINEST, "/opt/logs/log-framework/jdk/test.log");
        if (logger.isLoggable(Level.FINEST)) {
            logger.finest("again，jdkLog【1】");
        }
    }

    /**
     * 动态设置console日志级别, 需要同时变更handler和level
     *
     * @param logger
     * @param level
     */
    private static void setConsoleLevel(Logger logger, Level level) {
        // 1.设置handler
        // new一个控制台处理器
        Handler console = new ConsoleHandler();
        // 给处理器设置级别
        console.setLevel(level);
        // 给logger设置处理器
        logger.addHandler(console);
        // 2.设置level
        logger.setLevel(level);
    }

    /**
     * 动态设置file日志级别, 需要同时变更handler和level
     *
     * @param logger
     * @param level
     * @param filePath
     */
    public static void setFileLevel(Logger logger, Level level, String filePath) {
        try {
            // 1.设置handler
            File f = new File(filePath);
            if (!f.exists()) {
                String folderPath = filePath.substring(0, filePath.lastIndexOf("/"));
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                f.createNewFile();
            }
            // new一个文件处理器, 一直追加内容
            FileHandler file = new FileHandler(filePath, true);
            // 增加处理器格式
            file.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return "\r\n" + record.getLoggerName() + "-" + record.getLevel() + "-" + record.getMessage();
                }
            });
            // 给logger设置处理器
            logger.addHandler(file);
            // 2.设置level
            logger.setLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
