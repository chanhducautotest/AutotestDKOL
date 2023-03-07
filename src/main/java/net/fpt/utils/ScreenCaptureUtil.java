package net.fpt.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public final class ScreenCaptureUtil {
    static final Logger logger = LoggerFactory.getLogger(ScreenCaptureUtil.class);

    /**
     * method to capture the entire screen of the Browser
     * or Mobile App
     *
     * @param driver- WebDriver
     * @param screenshot - The path and filename to save it to
     */
    public static void getScreenShortFile(WebDriver driver, File screenshot){
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
        }
    }

    /**
     * method to capture the screen of the Browser
     * or Mobile App
     *
     * @param element - WebElement
     * @param screenshot - The path and filename to save it to
     */
    public static void getElementShortFile(WebElement element , File screenshot){
        logger.debug("getElementShortFile");
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(element.getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
        }
    }

    /**
     * method to capture the full screen of the Browser
     *
     * @param driver-
     * @param screenshot - The path and filename to save it to
     */
    public static void getFullScreenShortFile(WebDriver driver,File screenshot){
        logger.debug("getFullScreenShortFile");
        try {
            Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(fpScreenshot.getImage(),"jpg",screenshot);
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
        }
    }

    /**
     * method to take snapshot of WebElement
     * for The Web or Mobile Element to capture
     * @param element - The Web or Mobile Element to capture
     * @return File
     * @throws Exception
     */
    public static File imageSnapshot(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        File screen = null;
        // capture the WebElement snapshot
        screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver())
                .getScreenshotAs(OutputType.FILE);
        // create Buffered Image instance from captured screenshot
        BufferedImage img = ImageIO.read(screen);
        // get the width/height of the WebElement for the rectangle
        Rectangle rect = element.getRect();
        // get the location of WebElement in a point (x,y)
        Point p = element.getLocation();
        // create image for element using location and size
        BufferedImage dest =
                img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // BMP,bmp,jpg,JPG,jpeg,wbmp,png,PNG,JPEG,WBMP,GIF,gif
        ImageIO.write(dest,"png",screen);
        return screen;
    }

    /**
     * Phương thức lưu lại hình ảnh của element và lưu vào trong log của testNG và hiện lên trên report
     * @author MinhLH5
     * @param element - Element cần lưu
     * @param description - thông tin element hoặc ""
     */

    public static void attachScreenShotToTestNGReport(WebElement element, String description)  {
        logger.debug("attachScreenShotToTestNGReport");
        String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
        String fileName = "element_" + System.currentTimeMillis()+ ".jpg";
        String screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
        String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File img= new File(screenshotAbsolutePath);
        try {
            getElementShortFile(element,img);
            BufferedImage bimg = ImageIO.read(img);
            int width          = bimg.getWidth();
            int height         = bimg.getHeight();
            if(Boolean.getBoolean("enableUploadFile")){
                new MinIO().minFileUploader(fileWithFolder+ "/" + img.getName(),img);
                Reporter.log(" <a href='"+"https://hi-static.fpt.vn/sys/selenium-core/stag/"+ fileWithFolder+ "/" +img.getName() +"'> <img src='"+ "https://hi-static.fpt.vn/sys/selenium-core/stag/"+ fileWithFolder+ "/" + img.getName() +"' height='"+height+"' width='"+width+"'/> </a> </br> " +
                        "<p>"+description+"</p>");
            }else {
                byte[] fileContent = new byte[0];
                fileContent = FileUtils.readFileToByteArray(new File(img.getAbsolutePath()));
                Reporter.log(" <a href='#'> <img src='data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(fileContent) +"' height='"+height+"' width='"+width+"'/> </a> </br> " +
                        "<p>"+description+"</p>");
            }
        } catch (Exception e) {
            logger.error(e.getCause().getMessage());
        }
    }

    /**
     * Phương thức lưu lại hình ảnh của element và lưu vào trong log của testNG và hiện lên trên report
     * @author MinhLH5
     * @param description - thông tin element hoặc ""
     */

    public static void attachScreenShotToTestNGReport(WebDriver driver, String description)  {
        logger.debug("attachScreenShotToTestNGReport");
        String screenshotDirectory= System.getProperty("screenshotDirectory","target"+ File.separator + "screenshots");
        String fileName = "element_" + System.currentTimeMillis()+ ".jpg";
        String screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
        String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File img= new File(screenshotAbsolutePath);
        try {
            getFullScreenShortFile(driver,img);
            BufferedImage bimg = ImageIO.read(img);
            int width          = bimg.getWidth();
            int height         = bimg.getHeight();
            if(Boolean.getBoolean("enableUploadFile")){
                new MinIO().minFileUploader(fileWithFolder+ "/" + img.getName(),img);
                Reporter.log(" <a href='"+"https://hi-static.fpt.vn/sys/selenium-core/stag/"+ fileWithFolder+ "/" + img.getName() +"'> <img src='"+ "https://hi-static.fpt.vn/sys/selenium-core/stag/"+ fileWithFolder+ "/" + img.getName() +"' height='"+ height * 0.05+"' width='"+ width * 0.05+"'/> </a> </br> " +
                        "<p>"+description+"</p>");
            }else {
                byte[] fileContent = new byte[0];
                fileContent = FileUtils.readFileToByteArray(new File(img.getAbsolutePath()));
                Reporter.log(" <a href='#'> <img src='data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(fileContent) +"' height='"+ height * 0.05+"' width='"+ width * 0.05+"'/> </a> </br> " +
                        "<p>"+description+"</p>");
            }
        } catch (Exception e) {
            logger.error(e.getCause().getMessage());
        }
    }

    /**
     * Phương thức lưu log của testNG và hiện lên trên report
     * @author MinhLH5
     * @param description - thông tin cần thêm vào report
     */

    public static void addStepToTestNGReport(String description)  {
        logger.debug("addStepToTestNGReport");
        Reporter.log("<p>"+description+"</p>");
    }
}
