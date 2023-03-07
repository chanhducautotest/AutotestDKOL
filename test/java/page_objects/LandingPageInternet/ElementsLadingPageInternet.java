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

}