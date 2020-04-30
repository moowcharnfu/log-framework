package cn.com.tcsl.log;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultipleThreadJDKLog {
    private static Logger logger = Logger.getLogger("MultipleThreadJDKLog");

    public static void main(String[] args) {
        try {
            int messageSize = 2000000;
            int threadSize = 50;
            final int everySize = messageSize / threadSize;

            // 设置日志级别和使用文件输出
            JDKLog.setFileLevel(logger, Level.INFO, "/opt/logs/log-framework/jdk/multipleThread.log");
            final CountDownLatch cdl = new CountDownLatch(threadSize);
            long startTime = System.currentTimeMillis();
            for (int ts = 0; ts < threadSize; ts++) {
                new Thread(new Runnable() {
                    public void run() {
                        for (int es = 0; es < everySize; es++) {
                            logger.info("======info压力测试");
                        }
                        cdl.countDown();
                    }
                }).start();
            }

            cdl.await();
            long endTime = System.currentTimeMillis();
            logger.info("multiple-log:messageSize = " + messageSize + ",threadSize = " + threadSize + ",costTime = " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
