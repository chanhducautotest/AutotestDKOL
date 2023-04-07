package page_objects.Payment;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsPayment extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 5000);
    public Query listElementsCheckoutPage = new Query().defaultLocator(By.xpath("//p[not(contains(@class,'text-12 mb-0 d-none'))]")).usingDriver(driver);
    public Query linkBacktoRegisterPage = new Query().defaultLocator(By.xpath("//a[@href='/internet/register'][contains(text(),'Thay đổi')]")).usingDriver(driver);
    public Query linkBacktoServicePage = new Query().defaultLocator(By.xpath("//a[@href='/internet/service'][contains(text(),'Thay đổi')]")).usingDriver(driver);
    public Query paymentBox = new Query().defaultLocator(By.xpath("//a[@class='big-btn d-flex flex-row align-items-center justify-content-between mb-2']")).usingDriver(driver);
    public Query paymentPopup = new Query().defaultLocator(By.xpath("//div[@id='__BVID__685___BV_modal_content_']")).usingDriver(driver);
    public Query listPaymentMethods = new Query().defaultLocator(By.xpath("//ul[@class='list-type-payment']")).usingDriver(driver);
    public Query btnClosePaymentPopup = new Query().defaultLocator(By.xpath("//button[@aria-label='Close']")).usingDriver(driver);
    public Query btnConfirmPaymentPopup = new Query().defaultLocator(By.xpath("//button[@class='w-100 btn btn-custom orange']")).usingDriver(driver);
    public Query btnPayment = new Query().defaultLocator(By.xpath("//button[@class='w-100 btn btn-custom orange']")).usingDriver(driver);
    public Query txtNapasCardNum = new Query().defaultLocator(By.xpath("//input[@id='napasCardNo']")).usingDriver(driver);
    public Query txtNapasCardName = new Query().defaultLocator(By.xpath("//input[@id='napasNameOnCard']")).usingDriver(driver);
    public Query txtNapasCardIssueDate = new Query().defaultLocator(By.xpath("//input[@id='napasIssueDate']")).usingDriver(driver);
    public Query txtNapasCardOtp = new Query().defaultLocator(By.xpath("//input[@id='napasIssueDate']")).usingDriver(driver);
    public Query btnContinueOnFoxpay = new Query().defaultLocator(By.xpath("//button[@id='napasProcessBtn1']")).usingDriver(driver);
    public Query btnContinueOnFoxpayOtp = new Query().defaultLocator(By.xpath("//button[@id='napasProcessBtn2']")).usingDriver(driver);
}
