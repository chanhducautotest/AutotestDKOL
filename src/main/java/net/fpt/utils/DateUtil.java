package net.fpt.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.WebElement;

public class DateUtil {

    // Lấy ngày hiện tại
    public static String getCurrentDay() {
        // Tạo Object Calender
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        // Lấy ngày hiện tại như một số
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        // Chuyển số nguyên thành chuỗi
        String todayStr = Integer.toString(todayInt);
        return todayStr;
    }

    // Nhận Ngày hiện tại cộng với ngày
    public static String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }

    // Click chọn ngày đưa ra
    public static void clickGivenDay(List<WebElement> elementList, String day) {
        /**
         * Functional JAVA
         * */
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);
        /**
         * Non-functional JAVA
         * */
        //for (
        //    WebElement cell : elementList) {
        //    String cellText = cell.getText();
        //    if (cellText.contains(day)) {
        //        cell.click();
        //        break;
        //    }
        //}
    }
}
