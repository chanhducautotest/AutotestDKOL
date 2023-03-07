package page_objects.FPTCameraPage;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import page_objects.PageBase;

public class ElementsFPTCamera extends PageBase {

    public Query tab_cameraIQ = new Query().defaultLocator(By.id("3082")).usingDriver(driver);
    public Query tab_indoorCamera= new Query().defaultLocator(By.id("2152")).usingDriver(driver);
    public Query tab_outdoorCamera = new Query().defaultLocator(By.id("2162")).usingDriver(driver);
    public Query tab_FPTCloud = new Query().defaultLocator(By.cssSelector(".text-cloud")).usingDriver(driver);
    /**
     * Giảm số lượng camera
     * */
    public Query button_decrease = new Query().defaultLocator(By.cssSelector(".calculator-tool .btn-decrease")).usingDriver(driver);
    /**
     * Tăng số lượng camera
     * */
    public Query button_increase = new Query().defaultLocator(By.cssSelector(".calculator-tool .btn-increase")).usingDriver(driver);
    /**
     * số lượng camera
     * */
    public Query text_quantity = new Query().defaultLocator(By.cssSelector(".quantity")).usingDriver(driver);

    /**
     * button mua ngay ở trên
     * */
    public Query button_bookingWithPrice= new Query().defaultLocator(By.cssSelector(".calculator-box .btn-booking")).usingDriver(driver);
    /**
     * button mua ngay ở dưới
     * */
    public Query button_booking = new Query().defaultLocator(By.cssSelector(".justify-content-center .btn-booking")).usingDriver(driver);

    /**
     * button 1 ngày cloud
     * */
    public Query tab_OneDayCloud = new Query().defaultLocator(By.id("113")).usingDriver(driver);

    /**
     * button 3 ngày cloud
     * */
    public Query tab_ThreeDayCloud = new Query().defaultLocator(By.id("111")).usingDriver(driver);

    /**
     * button 7 ngày cloud
     * */
    public Query tab_servenDayCloud = new Query().defaultLocator(By.id("111")).usingDriver(driver);

    /**
     * button camera trong nhà
     * */
    public Query button_interiorCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/h2[1]")).usingDriver(driver);

}
