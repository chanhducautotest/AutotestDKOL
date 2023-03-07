package page_objects.LandingPageInternet;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.util.Strings;
import page_objects.Menu.ActionsMenu;
import page_objects.Register.ActionsRegister;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static constants.Common.*;
import static constants.CommonFPTPlay.priceRegularExpression;
import static constants.CommonInternet.*;
import static constants.CommonInternet.urlHome;
import static constants.CommonRegister.urlAboutFPTRule;
import static net.fpt.driver_setting.DriverBase.getDriver;
import static net.fpt.utils.BrowserUtils.loadPage;
import static net.fpt.utils.BrowserUtils.waitForURL;
import static net.fpt.utils.WebElementActionUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionLandingPageInternet extends ElementsLadingPageInternet {
    static final Logger logger = LoggerFactory.getLogger(ActionLandingPageInternet.class);

    /**
     * Click vào tab Internet trên Menu
     **/
    public void clickURLInternet() {
        clickEl(wait,link_internet);
        //wait.until(ExpectedConditions.titleIs("Đăng ký Online FPT Play xem phim và truyền hình trực tuyến"));
    }

    /**
     * Click quay lại trang trước đó
     **/
    public Boolean isButtonFPTRule() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(label_rules02.by()));
        clickEl(wait,label_rules02);
        Thread.sleep(5000);
        return true;
    }

    /**
     * Đóng trang
     **/
    public void closePage() {
        driver.quit();
    }

    /**
     * Get đường dẫn URL trang điều khoản
     **/
    public static Boolean getURL(String str) {
        str = driver.getCurrentUrl();
        return true;
    }

    /**
     * Get đường dẫn URL
     **/
    public static Boolean getCurrentURL(String str) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.matches(str);
    }

    /* Hàm getText  */
    public String getTextElement(Query q) {
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        return myElement.getText();
    }

    /**
     * Hàm click vào trang
     */
    public void clickElement(Query q) {
        logger.info("clickElement");
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }

    /**
     * Click vào gói data đầu tiên
     */
    public ActionLandingPageInternet clickFirstCombo() {
        logger.info("clickFirstCombo");
        clickElement(label_firstComboData);
        return new ActionLandingPageInternet();
    }

    /**
     * Click vào một gói Internet bất kỳ
     */
    public ActionLandingPageInternet clickAnyInternet() {
        logger.info("clickAnyInternet");
        Random ran = new Random();
        wait.until(ExpectedConditions.elementToBeClickable(list_topPromotion.by()));
        List<WebElement> listElement = list_topPromotion.findWebElements();
        WebElement element = listElement.get(ran.nextInt(listElement.size()));
        while (!element.isDisplayed()){
            element = listElement.get(ran.nextInt(listElement.size()));
        }
        element.click();
        return new ActionLandingPageInternet();
    }

    /**
     * Hàm click vào gói combo đầu tiên get tên
     */
    public ActionLandingPageInternet clickNameFirstCombo(String comboName) {
        logger.info("clickFirstCombo");
        wait.until(ExpectedConditions.elementToBeClickable(label_firstComboData.by()));
        List<WebElement> listElement = label_firstComboData.findWebElements();
        for (WebElement e : listElement) {
            if (e.getText().trim().contains(comboName)) {
                e.click();
                break;
            }
        }
        return new ActionLandingPageInternet();
    }

    /**
     * Kiểm tra màn hình ưu đãi
     **/
    public List checkDisplayInternetPage() {
        Query[] header = {list_topPromotion, list_topPromotionComboInternet, list_topPromotionInternetOnly, list_topInternetOnly, list_topNews};
        return listTitleRegistrationInfo(wait, header);
    }

    /**
     * Kiểm tra khu vực hiển thị dịch vụ Internet
     **/
    public Boolean priceFormCheck(String str) {
        return matchFound(getPrice, str);
    }

    public List checkFormPrice() {
        Query[] element = {label_nameInternet};
        assertThat(priceFormCheck(getTextElement(label_promotionPrice))).as("Kiểm tra form giá sale off").isTrue();
//        assertThat(priceFormCheck(getTextElement(label_priceRoot))).as("Kiểm tra form giá gốc").isTrue();
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra khu vực được ưu đã nhiều nhất sau khi thay đổi location
     **/
    public void verifyTopPromotionAfterChangeLocation(List location) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(list_topPromotion.by()));
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     * Kiểm tra thông tin hình dịch vụ gói Internet Only
     **/
    public Boolean verifyImageInternetOnly() {
        List<WebElement> elementImg = new ArrayList<>(listImagesInternetTVInternetOnly.findWebElements());
        Boolean imageLoaded1 = null;
        for (WebElement i : elementImg) {
            imageLoaded1 = isLoadingImage(i);
        }
        return imageLoaded1;

    }

    public List verifyContentInternetOnly() {
        List<WebElement> elementGroupContent = new ArrayList<>(listGroupContentInternetTVInternetOnly.findWebElements());
        for (WebElement i : elementGroupContent) {
            List<WebElement> c = i.findElements(By.xpath("./child::*"));
            List items = null;
            for (WebElement f : c) {
                items = getTextListItems(c);
            }
            return items;
        }
        return elementGroupContent;
    }

    /**
     * Kiểm tra xử lý của hàm Hyperlink
     **/
    public String verifyLinkTopNews() {
        WebElement element = list_sectionTopNews.findWebElement();
        List<WebElement> listLinkNews = element.findElements(By.tagName("a"));
        String linkUrl = null;
        for (WebElement i : listLinkNews) {
            linkUrl = i.getAttribute("href");
        }
        return linkUrl;
    }

    /**
     * Kiểm tra hiển thị nội dung tin tức nổi bật
     **/
    public Boolean verifyContentTopNews() {
        WebElement element = list_sectionTopNews.findWebElement();
        List<WebElement> imgLinkNews = element.findElements(By.tagName("img"));
        Boolean imageLoaded1 = null;
        for (WebElement i : imgLinkNews) {
            imageLoaded1 = isLoadingImage(i);
        }
        return imageLoaded1;
    }

}
