package net.fpt.listeners;

import net.fpt.driver_setting.DriverBase;
import net.fpt.utils.MinIO;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.fpt.utils.ScreenCaptureUtil.getFullScreenShortFile;


public class ScreenShotListener extends TestListenerAdapter {
    static final Logger logger = LoggerFactory.getLogger(ScreenShotListener.class);
    public static String screenshotAbsolutePath;
    public static String elementAbsolutePath;


    private boolean createFile(File screenshort){
        boolean filecreate =false;
        if(screenshort.exists()){
            filecreate = true;
        }else {
            File parentDirectory =new File(screenshort.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdir()){
                try{
                    filecreate = screenshort.createNewFile();
                }catch (IOException errorCreatingScreenshot){
                    logger.error("Unable to capture screenshot..."+ errorCreatingScreenshot.getCause());
                }
            }
        }
        return filecreate;
    }


    private void captureScreen(ITestResult failingTest){
        try {
            WebDriver driver = DriverBase.getDriver();
            String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
            String fileName =  System.currentTimeMillis() + "_" + failingTest.getName() + ".jpg";
            screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
            // file with date path
            String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ "/"+ fileName;
            failingTest.setAttribute("screenshotAbsolutePath"+failingTest.getName(),screenshotAbsolutePath);
            failingTest.setAttribute("screenshotFileName"+failingTest.getName(),fileWithFolder);
            File screenshort= new File(screenshotAbsolutePath);
            if(createFile(screenshort)){
                try {
                    getFullScreenShortFile(driver,screenshort);
                    new MinIO().minFileUploader(fileWithFolder,screenshort);
                }catch (ClassCastException weNeedToAugmentOurDriverObject){
                    getFullScreenShortFile(new Augmenter().augment(driver), screenshort);
                    new MinIO().minFileUploader(fileWithFolder,screenshort);
                }
                logger.debug("Written screenshot to " +  screenshotAbsolutePath);
            } else {
                logger.error("Unable to create " +  screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            logger.error("Unable to capture screenshot..."+ ex.getCause());
        }
    }

    @Override
    public void onTestFailure(ITestResult failingTest){
        captureScreen(failingTest);
    }

    @Override
    public void onTestSuccess(ITestResult successTest){
        //captureScreen(successTest);
    }


}
