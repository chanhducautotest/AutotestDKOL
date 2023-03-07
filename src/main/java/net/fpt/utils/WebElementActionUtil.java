package net.fpt.utils;

import com.lazerycode.selenium.util.Query;
import net.fpt.driver_setting.DriverBase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebElementActionUtil extends DriverBase {
    static final Logger logger = LoggerFactory.getLogger(WebElementActionUtil.class);

    /**
     * Mô tả: Truyền vào element để láy một list element, click vào element có text trùng với text truyền đã truyền vào
     * @param element
     * @param choose
     */
    public static void chooseList(Query element, String choose){
        try {
            List<WebElement> elementList = element.findWebElements();
            logger.debug("Number of elements:" + elementList.size());
            for (int i = 0; i < elementList.size(); i++) {
                if (elementList.get(i).getText().equals(choose)) {
                    logger.debug("Found Item: "+ choose);
                    elementList.get(i).click();
                    break;
                }
            }

        }catch(Exception e) {
            logger.error("chooseList "+ element.toString());
        }

    }

    /**
     * Mô tả: Kiểm tra có hiện element trong viewpoint hay không
     * link: stackoverflow.com/questions/45243992/verification-of-element-in-viewport-in-selenium
     * @param element
     * @return
     */
    public static Boolean isVisibleInViewport(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

    /**
     * Author: HaoBH
     * Function: get list của các items giống nhau chứa trong cùng 1 layout chung
     *@param query - item trong cùng của layout.
     *             Example: 1 thẻ <ul> chứa nhiều thẻ <li> bên trong thì query là 1 tập hợp các <li>
     *@return List items kiểu String
     * */
    public static List getTextListItems (Query query) {
        ArrayList result = new ArrayList<>();
        List<WebElement> elementList= new ArrayList<>(query.findWebElements());
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
        }
        return result;
    }

    /**
     * Author: MinhLH5
     * Function: get list của các items giống nhau chứa trong cùng 1 layout chung
     *@param listElement - item trong cùng của layout.
     *             Example: 1 thẻ <ul> chứa nhiều thẻ <li> bên trong thì query là 1 tập hợp các <li>
     *@return List items kiểu String
     * */
    public static List getTextListItems (List<WebElement> listElement) {
        ArrayList result = new ArrayList<>();
        for (WebElement i: listElement) {
            result.add(i.getText().trim());
        }
        return result;
    }

    /**
     * Author: minhlh5
     * Function: lấy danh sách element có chứa đường link
     *@param query - item trong cùng của layout.
     *@return List web element
     * */
    public static List<WebElement> getListElementHasLinkInList (Query query) {
        ArrayList result = new ArrayList<>();
        List<WebElement> elementList= new ArrayList<>(query.findWebElements());
        for (int i = 0; i < elementList.size(); i++) {
            try {// fix loop exit because exception null
                String attribute = elementList.get(i).getAttribute("href");
                if (attribute.trim().length() > 0 && attribute.indexOf("#")<0) {
                    logger.debug(">>>>>>>>>>>>>>>>>>>.{} >> {}", attribute, attribute.length());
                    result.add(elementList.get(i));
                }
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * Author: MinhLH5
     * Mô tả: Kiểm tra img có được load
     * @param element
     * @return Boolean
     */
    public static Boolean isLoadingImage(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();
        return (Boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
    }

    /**
     * Author: MinhLH5
     * Mô tả: Chờ element chuyển đổi style được định nghĩa
     * @return Boolean
     */
    public static ExpectedCondition<Boolean> waitForLoadingCSSStype(WebElement element, String stypeLoading) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                //System.out.println(element.getAttribute("style"));
                return element.getAttribute("style").equals(stypeLoading);
            }
        };
    }

    /**
     * Author: MinhLH5
     * Mô tả: Chờ element xuất hiện và bắt đầu click
     * @return action
     * @param q // test
     * @param wait //test
     */
    public static void waitAndClickToElement(Query q, WebDriverWait wait){
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }


    /**Author: HaoBH
     * Function: check whether the element is displayed
     * @param element
     * @return true/false
     * */
    public static boolean checkElementDisplayed(WebDriverWait wait, Query element){
        logger.debug("checkElementDisplayed");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element.by()));
            if (element.findWebElement().isDisplayed())
                return true;
        }
        catch (NoSuchElementException e){
            logger.debug("NoSuchElementException");
        }
        catch (TimeoutException e){
            logger.debug("TimeoutException");
        }
        return false;
    }

    /**
     * Hàm lấy giá trị văn bản của 1 Element
     * author: HungNDT2
     * Input: - locator của element xét
     * Output: - giá vị của element dạng string
     */
    public static String getTextElement(WebDriverWait wait, Query q) {
        WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
        return myElement.getText();
    }

    /**
     * Hàm click vào 1 Element
     * author: HungNDT2
     * Input: - Locator của element cần click
     */
    public static void clickEl(WebDriverWait wait, Query q) {
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }

    /**
     * click - method to execute a JavaScript click event
     *
     * @param element
     */

    public static void clickJS(WebElement element) {
        WebDriver driver = null;
        try {
            driver = getDriver();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
        } catch (MalformedURLException e) {
            logger.debug("MalformedURLException");
        }
    }



    /**
     * Hàm xóa thông tin trong các trường nhập
     * author: HungNDT2
     * Input: - locator của element cần xóa text
     */
    public static void clearInput(WebDriverWait wait, Query q) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(q.findWebElement()));
        element.clear();
    }


    /**
     * Nhập giá trị vào trường input
     * Function: Nhập các giá trị dạng string mong muốn vào một trường input
     * author: HungNDT2
     * Input: - locator của trường input cần nhập giá trị
     * - Chuỗi giá trị nhập
     * Output: trả về giá trị chính nó
     */
    public static void  enterText(WebDriverWait wait,Query q, String test) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
        q.findWebElement().sendKeys(test);
    }

    /**Author: MinhLH5
     * Function: Highlight Element
     * @param element
     * @return true/false
     * */
    public static void highlightElement(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();
        for (int i = 0; i <5; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 2px solid red;");
        }
    }

    /** Hàm kiểm tra element tồn tại
     * author: HungNDT2
     * Input: Query - q: locator của phần tử
     * Output: trả về giá trị true hoặc false
     * */
    public static Boolean isElementVisible(WebDriverWait wait, Query q) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
            q.findWebElement();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
        } catch (TimeoutException e) {
        }
        return false;
    }

    /** Hàm tạo list nội dung của các element từ mảng các locator
     * author: HungNDT2
     * Input: label (mảng chứa query) cung cấp cho hàm 1 mảng gồm các locator của các element cần add nội dung vào list
     * Output: trả về danh sách nội dung của các phần tử trong mảng
     * */
    public static List listTitleRegistrationInfo(WebDriverWait wait, Query[] label) {
        List<String> listLabel = new ArrayList<>();
        for (int i = 0; i <= (label.length - 1); i++) {
            listLabel.add(getTextElement(wait,label[i]));
        }
        return listLabel;
    }

    /** Hàm kiểm tra giá trị văn bản (text)
     * author: HungNDT2
     * Description: Hàm matchFound gồm 2 gái trị input đầu vào "giá trị làm mẫu" (patternValue - đây là chuỗi regular expression) và "giá trị cần kiềm tra" (value - normal text)
     * Ex: Khi muốn duyệt 1 chuỗi "102.356đ/tháng" đúng form "<giá tiền>đ/tháng", chúng ta sẽ dùng regex dạng /\d+.\d+đ/\tháng/ => matchFound("\d+.\d+đ/\tháng","102.356đ/tháng") => trả ra true nếu khớp và ngược lại
     * Input: String - patternValue: chuỗi regular expression dùng làm mẫu
     *        String - value: chuỗi văn bản dạng normal text để được kiểm tra
     * Output: Trả về giá trị true hoặc false
     * */
    public static Boolean matchFound(String patternValue, String value) {
        Pattern pattern = Pattern.compile(patternValue);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    /** Hàm chờ cố định khi
     * author: minhlh5
     * @param milliseconds
     * */
    public static void sleepTo(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm lấy một chuỗi ký tự từ một chuỗi
     * author: HungNDT2
     * Input: String - patternRegex: là chuỗi regular expression mẫu dùng để so sánh
     *        String - str: là chuỗi ban đầu
     * Output: trả ra chuỗi cần lấy
     * */
    public static String getStringFromOtherString(String patternRegex, String str) {
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            return null;
        }
    }

    /** Hàm so sánh url của trang hiện tại với một url mong muốn
     * author: HungNDT2
     * Input: String - str: url mẫu dạng str của regex để so sánh dạng String
     * Output: Trả ra url của trang hiện tại dạng String
     * */
    public static Boolean checkCurrentURL(String str) throws MalformedURLException {
        String currentURL = getDriver().getCurrentUrl();
        return currentURL.matches(str);
    }


}
