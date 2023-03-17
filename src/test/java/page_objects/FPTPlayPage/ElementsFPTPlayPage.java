package page_objects.FPTPlayPage;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsFPTPlayPage extends PageBase {

    public Query headermenu_FPTPlay = new Query().defaultLocator(By.xpath("//header/nav[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/h2[1]")).usingDriver(driver);
    public Query button_buyPackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[2]/a[1]")).usingDriver(driver);
    public Query button_vipPackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/h2[1]")).usingDriver(driver);
    public Query button_maxPackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/h2[1]")).usingDriver(driver);
    public Query button_BuyNow = new Query().defaultLocator(By.xpath("//body/div[1]/div[2]/main[1]/div[2]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[2]/a[1]")).usingDriver(driver);
    public Query button_PackageVIP = new Query().defaultLocator(By.xpath("//h2[@id='202']")).usingDriver(driver);
    public Query button_PackageMAX = new Query().defaultLocator(By.xpath("//h2[@id='201']")).usingDriver(driver);
    public Query button_PackageIZI = new Query().defaultLocator(By.xpath("//h2[@id='2004']")).usingDriver(driver);


    public Query label_priceSaleOffPackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")).usingDriver(driver);
    public Query label_priceOriginalPackage = new Query().defaultLocator(By.xpath("/html/body/div/div[2]/main/div[2]/div[1]/section[2]/div[2]/div[2]/div/div/div[1]/div/div/span[1]/span")).usingDriver(driver);
    public Query button_confirmNextChooseService = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[5]/div[1]/div[1]/div[1]/button[1]")).usingDriver(driver);

    /**
     * Locator của các option trong màn hình chọn dịch vụ của FPT Play
     * */
    public Query label_usedTime = new Query().defaultLocator(By.xpath("//span[@class='d-block text-16 text-bold mb-2']")).usingDriver(driver);
    public Query button_optionUsedTime1 = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/label[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_optionUsedTime2 = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/label[1]/div[2]/input[1]")).usingDriver(driver);

    /**
     * Locator popup màn hình Thông tin thanh toán
     * */
    public Query list_paymentMethods = new Query().defaultLocator(By.xpath("//p[@class='text-16 text-bold mb-1']")).usingDriver(driver);
    public Query button_paymentMethods = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]")).usingDriver(driver);
    public Query button_confirmPaymentMethods = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).usingDriver(driver);
    public Query label_namePaymentMethods = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/span[1]")).usingDriver(driver);
    public Query button_aboutFPTRule = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[5]/p[2]/a[1]/span[1]")).usingDriver(driver);
    public Query button_changeAddressSetup = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).usingDriver(driver);

}
