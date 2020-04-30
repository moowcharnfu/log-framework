package cn.com.tcsl.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class MultipleThreadLogbackLog {
    private static Logger logger = LoggerFactory.getLogger(MultipleThreadLogbackLog.class);

    public static void main(String[] args) {
        try {
            int messageSize = 500000;//500000|1000000|2000000
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
            logger.info("multiple-log:messageSize = {},threadSize = {},costTime = {}ms", messageSize, threadSize, (endTime - startTime));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
