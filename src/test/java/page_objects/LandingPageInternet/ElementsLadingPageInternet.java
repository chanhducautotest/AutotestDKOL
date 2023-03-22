package page_objects.LandingPageInternet;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsLadingPageInternet extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 15, 1000);

    public Query link_internet = new Query().defaultLocator(By.cssSelector("a[href='/internet']")).usingDriver(driver);

    /** Dịch vụ Internet truyền hình được ưu đãi nhiều nhất**/
    public Query list_topPromotion = new Query().defaultLocator(By.xpath("//div[@class='item item-hot p-4 d-flex flex-column']//h3")).usingDriver(driver);

    /** Dịch vụ Internet Truyền hình**/
    public Query list_topPromotionComboInternet = new Query().defaultLocator(By.xpath("(//div[@role='tabpanel'])[1]")).usingDriver(driver);

    /** Combo Internet truyền hình**/
    public Query list_topPromotionInternetOnly = new Query().defaultLocator(By.xpath("//div[@class='mb-0 item-desc']//h3")).usingDriver(driver);

    /** Internet Only**/
    public Query list_topInternetOnly = new Query().defaultLocator(By.xpath("(//div[@role='tabpanel'])[2]")).usingDriver(driver);

    /** Tin tức nổi bật **/
    public Query list_topNews = new Query().defaultLocator(By.xpath("//div[@class='item']")).usingDriver(driver);

    /** Hiển thị khu vực Dịch vụ Internet - Truyền hình được ưu đãi nhiều nhất**/
    public Query label_nameInternet = new Query().defaultLocator(By.xpath("//span[@class='mt-4 mb-3']")).usingDriver(driver);
    public Query label_promotion = new Query().defaultLocator(By.xpath("//div[@class='ticker']")).usingDriver(driver);
    public Query label_promotionPrice = new Query().defaultLocator(By.xpath("//span[@class='mt-auto']")).usingDriver(driver);
    public Query label_priceRoot = new Query().defaultLocator(By.xpath("//del[@class='clo-gray pointer']")).usingDriver(driver);

    /** Locator của Internet truyền hình Internet Only hình ảnh nội dung **/
    public Query listImagesInternetTVInternetOnly = new Query().defaultLocator(By.xpath("//div[@id='box1gb']//div[@class='image-box']/img")).usingDriver(driver);
    public Query listGroupContentInternetTVInternetOnly = new Query().defaultLocator(By.xpath("//ul[@class='list-service']")).usingDriver(driver);

    /** Locator của trang tin tức nổi bật **/
    public Query list_sectionTopNews = new Query().defaultLocator(By.xpath("//section[@class='sec-features mb-3']")).usingDriver(driver);

    /** Locator của trang tin tức nổi bật **/
    public Query label_firstComboData = new Query().defaultLocator(By.xpath("(//h3[@class='internet-seo name text-bold text-16 mt-2 pointer '])[1]")).usingDriver(driver);

    public Query label_rules02 = new Query().defaultLocator(By.xpath("(//p[@class='text-12 mb-0']//span)[2]")).usingDriver(driver);

    public Query inputNameTxt = new Query().defaultLocator(By.xpath("//input[@id='name']")).usingDriver(driver);
    public Query inputPhoneTxt = new Query().defaultLocator(By.xpath("//input[@id='phone']")).usingDriver(driver);
    public Query inputBirthdayTxt = new Query().defaultLocator(By.xpath("//input[@id='birthday']")).usingDriver(driver);
    public Query inputCMNDTxt = new Query().defaultLocator(By.xpath("//input[@id='cmnd']")).usingDriver(driver);
    public Query inputEmailTxt = new Query().defaultLocator(By.xpath("//input[@id='email']")).usingDriver(driver);
    public Query genderField = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[1]")).usingDriver(driver);
    public Query addressField = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']//div[@class='col-12']")).usingDriver(driver);
    public Query dropdownGenderArrow = new Query().defaultLocator(By.xpath("(//b[@role='presentation'])[1]")).usingDriver(driver);
    public Query dropdownCityArrow = new Query().defaultLocator(By.xpath("(//b[@role='presentation'])[2]")).usingDriver(driver);
    public Query dropdownDistrictArrow = new Query().defaultLocator(By.xpath("(//b[@role='presentation'])[3]")).usingDriver(driver);
    public Query dropdownWardArrow = new Query().defaultLocator(By.xpath("(//b[@role='presentation'])[4]")).usingDriver(driver);
    public Query dropdownStreetArrow = new Query().defaultLocator(By.xpath("(//b[@role='presentation'])[5]")).usingDriver(driver);
    public Query houseNumberInputTxt = new Query().defaultLocator(By.xpath("//input[@id='address']")).usingDriver(driver);
    public Query inputSearchBox = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query firstResultSearchBox = new Query().defaultLocator(By.xpath("(//ul[@id='select2--results'])[1]")).usingDriver(driver);
    public Query continueBtn = new Query().defaultLocator(By.xpath("//button[contains(text(),'Tiếp tục')]")).usingDriver(driver);
    public Query fptLogo = new Query().defaultLocator(By.xpath("//img[@class='kd-fptplay-img']")).usingDriver(driver);
    public Query btnClear = new Query().defaultLocator(By.xpath("//i[@class='btn-clear']")).usingDriver(driver);

}