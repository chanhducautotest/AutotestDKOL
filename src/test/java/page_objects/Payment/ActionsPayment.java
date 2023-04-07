package page_objects.Payment;

import constants.CommonPayment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.Register.ActionsRegister;

import java.util.*;

import static constants.Common.*;
import static net.fpt.utils.WebElementActionUtil.*;
import static net.fpt.utils.WebElementActionUtil.sleepTo;

public class ActionsPayment extends ElementsPayment {
    static final Logger logger = LoggerFactory.getLogger(ActionsRegister.class);
    public boolean areElementsDisplayed(List<WebElement> elementsList) {
        for (WebElement element : elementsList) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyElementsDisplayOnCheckOutPage(){
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listElementsCheckoutPage.by()));
        return areElementsDisplayed(elementsList);
    }
    public boolean compareElementListsOnInfoSectionRegisterPage() {
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listElementsCheckoutPage.by()));
        List listExpected = CommonPayment.getListCheckoutElements;
        if (elementsList.size() != listExpected.size()) {
            return false;
        }
        for (int i = 0; i < elementsList.size(); i++) {
            if (!elementsList.get(i).getText().equals(listExpected.get(i).toString())) {
                return false;
            }
        }
        return true;
    }
    public ActionsPayment waitForPaymentPageLoaded() {
        wait.until(ExpectedConditions.urlContains(urlPayment));
        return this;
    }
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
    }
    public boolean goToPage(String expectedUrl){
        waitForPageLoaded();
        sleepTo(6000);
        String currentURL = driver.getCurrentUrl();
        return currentURL.matches(expectedUrl);
    }
    public boolean verifyGoToRegisterPage(){
        return goToPage(urlRegister);
    }
    public boolean verifyGoToFoxpayPage(){
        return goToPage(urlFoxpay);
    }
    public void chooseBackToRegisterPage(){
        clickEl(wait,linkBacktoRegisterPage);
    }
    public void chooseBackToServicePage(){
        clickEl(wait,linkBacktoServicePage);
    }
    public void choosePaymentBox(){
        clickEl(wait,paymentBox);
    }
    public boolean verifyDisplayedPaymentPopup(){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(paymentPopup.by()));
    }
    public boolean verifyPaymentMethodsDisplayOnPopupPayment(){
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listPaymentMethods.by()));
        return areElementsDisplayed(elementsList);
    }
    List<WebElement> btnInPaymentPopup = new ArrayList<WebElement>(){
    };
    public boolean verifyDisplayedBtnsInPopupPayment(){
        btnInPaymentPopup.add(btnClosePaymentPopup.findWebElement());
        btnInPaymentPopup.add(btnConfirmPaymentPopup.findWebElement());
        return areElementsDisplayed(btnInPaymentPopup);
    }
    public void chooseBtnPayment(){
        clickEl(wait,btnPayment);
    }
    public void sendInfoToInputNapasCard(){
        WebElement cardNum = wait.until(ExpectedConditions.visibilityOfElementLocated(txtNapasCardNum.by()));
        cardNum.sendKeys(napasCardNum);
        WebElement cardName = wait.until(ExpectedConditions.visibilityOfElementLocated(txtNapasCardName.by()));
        cardName.sendKeys(napasCardName);
        WebElement cardDate = wait.until(ExpectedConditions.visibilityOfElementLocated(txtNapasCardIssueDate.by()));
        cardDate.sendKeys(napasCardIssueDate);
    }
    public void chooseBtnContinueFoxpay(){
        clickEl(wait,btnContinueOnFoxpay);
    }
    public void inputValidNapasCardOtp(){
        WebElement cardOtp = wait.until(ExpectedConditions.visibilityOfElementLocated(txtNapasCardOtp.by()));
        cardOtp.sendKeys(napasCardOtp);
    }
    public void chooseBtnContinueOtp(){
        clickEl(wait,btnContinueOnFoxpayOtp);
    }
    public boolean verifyGoToFinishPage(){
        waitForPageLoaded();
        sleepTo(6000);
        return goToPage(urlFinishRegister);
    }
}
