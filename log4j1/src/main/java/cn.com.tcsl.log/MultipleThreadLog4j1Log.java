package cn.com.tcsl.log;

import org.apache.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class MultipleThreadLog4j1Log {
    private static Logger logger = Logger.getLogger(MultipleThreadLog4j1Log.class);

    public static void main(String[] args) {
        try {
            int messageSize = 2000000;//500000|1000000|2000000
            int threadSize = 50;
            final int everySize = messageSize / threadSize;

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
            logger.error(e.getMessage(), e);
        }
    }
}
