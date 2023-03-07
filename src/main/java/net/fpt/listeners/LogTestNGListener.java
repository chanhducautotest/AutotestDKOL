package net.fpt.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LogTestNGListener extends TestListenerAdapter {
    public static String logFile = null;
    public static final String LOGFILE_PATH = "logs/";
    static final Logger logger = LoggerFactory.getLogger(LogTestNGListener.class);

    /**
     *
     * onStart - method to log data before any tests start
     *
     * @param testContext
     */
    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }
    /**
     * onFinish - method to log data after all tests are complete
     *
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
        try {
            log("\nTotal Passed = " +
                    getPassedTests().size() +
                    ", Total Failed = " +
                    getFailedTests().size() +
                    ", Total Skipped = " +
                    getSkippedTests().size() +
                    "\n");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        super.onFinish(testContext);
    }

    public void onTestStart(ITestResult tr) {
        log("\n---------------------------------- Test '"
                + tr.getName()
                + "' ----------------------------------\n");
        log(tr.getStartMillis(),
                "START-> "
                        + tr.getName() + "\n");
        log(" Test Parameters : "

                + "\n");
        super.onTestStart(tr);
    }

    /**
     * onTestFailure method
     *
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        long time = tr.getEndMillis() - tr.getStartMillis();
        if ( !tr.getThrowable().equals("") ) {
            log(" "+tr.getThrowable().getMessage() + "\n");
        }
        log(" Result : FAILED\n");
        log(" Execution Time : "+ printExecutionTime(tr)  +"\n");
        log(tr.getEndMillis(),
                "END -> "
                        + tr.getInstanceName()
                        + "." + tr.getName());
        log("\n----------------------------------------------------------------------------\n");
        super.onTestFailure(tr);
    }

    /**
     * onTestSuccess method
     *
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {

        log(" Result : PASSED\n");
        log(" Execution Time : "+ printExecutionTime(tr) +"\n");
        log(tr.getEndMillis(),
                "END -> "
                        + tr.getName());


        log("\n----------------------------------------------------------------------------\n");
        super.onTestSuccess(tr);
    }

    /**
     * log - method to log data to standard out or logfile
     *
     * @param dataLine
     */
    public void log(long date, String dataLine) {
        logger.info(String.valueOf(new Date(date)) +" - "+ dataLine) ;
    }

    /**
     * log - overloaded method to log data to standard out or logfile
     *
     * @param dataLine
     */
    public void log(String dataLine) {
        logger.info(dataLine) ;
    }

    /**
     * printExecutionTime - method convert timeStamp to format time
     *
     * @param tr - ITestResult
     */
    public String printExecutionTime(ITestResult tr){
        long time = tr.getEndMillis() - tr.getStartMillis();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));
        long milliseconds = time - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes) - TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%02d:%02d:%02d:%d", hours, minutes, seconds, milliseconds);
    }

}
