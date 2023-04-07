package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;

public class CommonPayment {

    /**
     * Đường dẫn đọc dữ liệu từ file json
     */
    public static final String DATA_TEST_FILE_PATH_CHECKOUT = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/CheckoutData.json";

    /**
     * Đọc dữ liệu ở file json
     */
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static List getListCheckoutElements =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_CHECKOUT,"LIST_ELEMENTS_CHECKOUT_PAGE");
}
