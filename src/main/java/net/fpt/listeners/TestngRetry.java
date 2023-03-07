package net.fpt.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngRetry implements IRetryAnalyzer {
    static final Logger logger = LoggerFactory.getLogger(TestngRetry.class);
    public static final Integer maxRetryCount = Integer.getInteger("maxRetryCount");
    private int retryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            String message =
                    "Retry for ["
                            + result.getName()
                            + "] on class ["
                            + result.getTestClass().getName()
                            + "] Retry "
                            + retryCount
                            + " times";
            logger.info(message);
            Reporter.setCurrentTestResult(result);
            Reporter.log(message+"\n");
            retryCount++;
            return true;
        }
        return false;
    }

    public static int getMaxRetryCount() {
        return maxRetryCount;
    }

    public int getRetryCount() {
        return retryCount;
    }

}
