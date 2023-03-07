package page_objects.Menu;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsMenu extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 3000);

    /**
     *  Locator cũ
     *  */
    public Query headerEl = new Query().defaultLocator(By.xpath("//div[@id='navbarSupportedContent']/ul[1]/li/a")).usingDriver(driver);
    public Query linkTrangChuEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/a")).usingDriver(driver);
    public Query linkInternetEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[2]/a")).usingDriver(driver);
    public Query linkFptCameraEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[3]/a")).usingDriver(driver);
    public Query linkFptPlayBoxEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[4]/a")).usingDriver(driver);
    public Query linkFptCloudEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[5]/a")).usingDriver(driver);
    public Query timKiemEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]")).usingDriver(driver);
    public Query labelTimKiemEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/label")).usingDriver(driver);
    public Query labelBtnTimKiemEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[2]/button")).usingDriver(driver);
    public Query placeholderTimKiemEl = new Query().defaultLocator(By.id("ordercode")).usingDriver(driver);
    public Query inputTimKiemEl = new Query().defaultLocator(By.id("ordercode")).usingDriver(driver);
    public Query txtDonHangKhongHopLeEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/small")).usingDriver(driver);
    public Query labelRoBotEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/div[2]")).usingDriver(driver);
    public Query dropDownQHEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/span"))).usingDriver(driver);
    public Query list_province = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/select/option"))).usingDriver(driver);
    public Query list_district = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/select/option"))).usingDriver(driver);
    public Query list_ward = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[3]/div/select/option"))).usingDriver(driver);
    public Query dropdown_province = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/span/span[1]/span"))).usingDriver(driver);
    public Query dropdown_district = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/span/span[1]/span"))).usingDriver(driver);
    public Query dropdown_ward = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[3]/div/span/span[1]/span"))).usingDriver(driver);
    /***
     * Drop down Phường Xã
     */
    public Query popup_location = new Query().defaultLocator((By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a"))).usingDriver(driver);
    public Query itemInList = new Query().defaultLocator((By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span[@class='select2-dropdown select2-dropdown--below']/span[@class='select2-results']/ul/li"))).usingDriver(driver);
    public Query button_confirm = new Query().defaultLocator((By.xpath("//body/div[@id='mdLocation-manual___BV_modal_outer_']/div[@id='mdLocation-manual']/div[1]/div[1]/footer[1]/div[1]/div[1]"))).usingDriver(driver);
    public Query textDCLDEl= new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_title_\"]/span"))).usingDriver(driver);
    public Query textGCEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/p"))).usingDriver(driver);
    public Query closedLocationProvince = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/span"))).usingDriver(driver);
    public Query btnXEl = new Query().defaultLocator(By.xpath("//*[@id=\"mdLocation-manual___BV_modal_header_\"]/button")).usingDriver(driver);
    public Query txtThongBao = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/small"))).usingDriver(driver);

    /**
     * Popup voucher xuất hiện tại màn hình mua camera
     * */
    public Query button_clearPopupVoucher = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")).usingDriver(driver);
    public Query popup_voucher = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).usingDriver(driver);
}