package page_objects.LandingPageInternet;

import com.lazerycode.selenium.util.Query;
import constants.CommonInternet;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.*;

import static constants.CommonInternet.*;
import static constants.Common.*;
import static net.fpt.utils.WebElementActionUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionLandingPageInternet extends ElementsLandingPageInternet {
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
    public void sendTextToInputNameTxt(String param){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputNameTxt.by()));
        inputNameTxt.findWebElement().sendKeys(param);
        inputNameTxt.findWebElement().sendKeys(Keys.ENTER);
    }
    public void sendTextToInputPhoneTxt(String param){
        WebElement inputPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneTxt.by()));
        inputPhone.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputPhone, ""));
        inputPhoneTxt.findWebElement().sendKeys(param);
    }
    public void sendTextToInputEmailTxt(String param){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmailTxt.by()));
        inputEmailTxt.findWebElement().sendKeys(param);
        inputEmailTxt.findWebElement().sendKeys(Keys.ENTER);
    }
    public void sendSpecialTextToInputPhoneTxt(String param){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneTxt.by()));
        inputPhoneTxt.findWebElement().sendKeys(param);
    }
    public void sendLessThan10NumberToInputPhoneTxt(String param){
        WebElement inputPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneTxt.by()));
        inputPhone.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputPhone, ""));
        inputPhoneTxt.findWebElement().sendKeys(param);
    }
    public void sendPNumberDiverse0ToInputPhoneTxt(String param){
        WebElement inputPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneTxt.by()));
        inputPhone.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputPhone, ""));
        inputPhoneTxt.findWebElement().sendKeys(param);
        sleepTo(2000);
    }
    public boolean verifyInputSpecialTextPhoneField(){
        String specialTextPhoneField = inputPhoneTxt.findWebElement().getText();
        return specialTextPhoneField.equalsIgnoreCase("");
    }
    public boolean verify100TextToInputNameTxt(String param) {
        inputNameTxt.findWebElement().sendKeys(Keys.ENTER);
        String name100charactersVerifyText = inputNameTxt.findWebElement().getAttribute("value");
        return name100charactersVerifyText.equalsIgnoreCase(param);
    }
    public void sendTextToInputCitySearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchBox.by()));
        inputSearchBox.findWebElement().sendKeys(inputProvinceMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultSearchBox.by())).click();
    }
    public void sendTextToInputDistrictSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchBox.by()));
        inputSearchBox.findWebElement().sendKeys(inputDistrictMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultSearchBox.by())).click();
    }
    public void sendTextToInputWardSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchBox.by()));
        inputSearchBox.findWebElement().sendKeys(inputWardMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultSearchBox.by())).click();
    }
    public void sendTextToInputStreetSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchBox.by()));
        inputSearchBox.findWebElement().sendKeys(inputStreetMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultSearchBox.by())).click();
    }
    public void sendTextToOthersFieldsExceptNameField(){
        inputPhoneTxt.findWebElement().sendKeys(CommonInternet.inputPhoneTxt);
        inputBirthdayTxt.findWebElement().sendKeys(CommonInternet.inputBirthdayTxt);
        inputCMNDTxt.findWebElement().sendKeys(CommonInternet.inputCMNDTxt);
        inputEmailTxt.findWebElement().sendKeys(CommonInternet.inputEmailTxt);
        sleepTo(2000);
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", addressField.findWebElement());
        sleepTo(1000);
        clickEl(wait,dropdownCityArrow);
        sendTextToInputCitySearchBox();
        clickEl(wait,dropdownDistrictArrow);
        sendTextToInputDistrictSearchBox();
        clickEl(wait,dropdownWardArrow);
        sendTextToInputWardSearchBox();
        clickEl(wait,dropdownStreetArrow);
        sendTextToInputStreetSearchBox();
        houseNumberInputTxt.findWebElement().sendKeys(inputHouseNumberMenu);
    }
    public void sendTextToOthersFieldsExceptEmailField(){
        inputNameTxt.findWebElement().sendKeys(inputFullNameTxt);
        inputPhoneTxt.findWebElement().sendKeys(CommonInternet.inputPhoneTxt);
        inputBirthdayTxt.findWebElement().sendKeys(CommonInternet.inputBirthdayTxt);
        inputCMNDTxt.findWebElement().sendKeys(CommonInternet.inputCMNDTxt);
        sleepTo(2000);
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", addressField.findWebElement());
        sleepTo(1000);
        clickEl(wait,dropdownCityArrow);
        sendTextToInputCitySearchBox();
        clickEl(wait,dropdownDistrictArrow);
        sendTextToInputDistrictSearchBox();
        clickEl(wait,dropdownWardArrow);
        sendTextToInputWardSearchBox();
        clickEl(wait,dropdownStreetArrow);
        sendTextToInputStreetSearchBox();
        houseNumberInputTxt.findWebElement().sendKeys(inputHouseNumberMenu);
    }
    public void sendTextToOthersFieldsExceptPhoneField(){
        inputNameTxt.findWebElement().sendKeys(inputFullNameTxt);
        inputBirthdayTxt.findWebElement().sendKeys(CommonInternet.inputBirthdayTxt);
        inputCMNDTxt.findWebElement().sendKeys(CommonInternet.inputCMNDTxt);
        inputEmailTxt.findWebElement().sendKeys(CommonInternet.inputEmailTxt);
        sleepTo(2000);
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", addressField.findWebElement());
        sleepTo(1000);
        clickEl(wait,dropdownCityArrow);
        sendTextToInputCitySearchBox();
        sleepTo(500);
        clickEl(wait,dropdownDistrictArrow);
        sendTextToInputDistrictSearchBox();
        sleepTo(500);
        clickEl(wait,dropdownWardArrow);
        sendTextToInputWardSearchBox();
        sleepTo(500);
        clickEl(wait,dropdownStreetArrow);
        sendTextToInputStreetSearchBox();
        houseNumberInputTxt.findWebElement().sendKeys(inputHouseNumberMenu);
    }
    public boolean verifyEmailMessageDisplayed(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailVerifyMessage.by()));
        String nameVerifyMessageText = emailVerifyMessage.findWebElement().getText();
        return nameVerifyMessageText.equals(expectedMessage);
    }
    public boolean verifyBlankPhoneMessageDisplayed(String message) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneBlankVerifyMessage.by()));
        String phoneBlankVerifyMessageText = phoneBlankVerifyMessage.findWebElement().getText();
        return phoneBlankVerifyMessageText.equals(message);
    }
    public boolean verifyLessThan10PNumberMessageDisplayed(String message) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFormatVerifyMessage.by()));
        String phoneBlankVerifyMessageText = phoneFormatVerifyMessage.findWebElement().getText();
        return phoneBlankVerifyMessageText.equals(message);
    }
    public boolean verifyPrefixDiverse0PNumberMessageDisplayed(String message) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFormatVerifyMessage.by()));
        String phoneBlankVerifyMessageText = phoneFormatVerifyMessage.findWebElement().getText();
        return phoneBlankVerifyMessageText.equals(message);
    }
    public void chooseContinueBtn(){
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", continueBtn.findWebElement());
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn.by())).click();
    }
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
    }
    public boolean verifyGoToServicePage(){
        waitForPageLoaded();
        sleepTo(6000);
        String expectedUrl= urlService;
        String currentURL = driver.getCurrentUrl();
        return currentURL.matches(expectedUrl);
    }
    public boolean chooseLogoFPTAndCheckGoToHomePage(){
        String expectedUrl = url;
        clickEl(wait,fptLogo);
        waitForPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.matches(expectedUrl);
    }
    public boolean verifyDefaultGender(String param) {
        waitForPageLoaded();
        String genderValueDefault = genderField.findWebElement().getText();
        return genderValueDefault.equalsIgnoreCase(param);
    }
    public void sendTextToInputSearchGender(String param){
        clickEl(wait,dropdownGenderArrow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchBox.by()));
        inputSearchBox.findWebElement().sendKeys(param);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultSearchBox.by())).click();
    }
    public boolean verifySelectedGender(String param) {
        String genderValueDefault = genderField.findWebElement().getText();
        return genderValueDefault.equalsIgnoreCase(param);
    }
    public void chooseClearBtn(){
        clickEl(wait,btnClear);
    }
    public boolean verifyInputtedNameValue() {
        String genderValueDefault = inputNameTxt.findWebElement().getAttribute("value");
        return genderValueDefault.equalsIgnoreCase("");
    }
    public boolean verifyDefaultEmailPlaceHolder(String param){
        String expectedValue = inputEmailTxt.findWebElement().getAttribute("placeholder");
        return expectedValue.equalsIgnoreCase(param);
    }
    public boolean areElementsDisplayed(List<WebElement> elementsList) {
        for (WebElement element : elementsList) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyElementsOnNavbarRegisterPage(){
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(navbarElementsList.by()));
        return areElementsDisplayed(elementsList);
    }
}
