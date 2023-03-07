package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.ArrayList;
import java.util.List;

import static constants.CommonInternet.urlHome;

public final class CommonFPTPlay {
    public static final String DATA_TEST_FILE_PATH_COMMON_FPT_PLAY = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/FPTPlayData.json";

    //Phần đọc dữ liệu từ file json
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static String priceRegularExpression=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_FPT_PLAY,"REGULAR_EXPRESSION_FORM_PRICE");
    public static String urlFPTPlay =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON_FPT_PLAY, "/URL_FPT_PLAY");
    public static String paymentMethod =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_FPT_PLAY,"PAYMENT_METHOD");
    public static String atmPaymentMethod =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_FPT_PLAY,"ATM_PAYMENT_METHOD");

    public static final String DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/RegisterData.json";

    public static List listPrivateInfo =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"LIST_TEXT_PRIVATE_INFO");

    public static String fullname =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_NAME");
    public static String phone =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_PHONE");
    public static String birthday =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_BIRTHDAY");
    public static String id =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_ID");
    public static String mail =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_EMAIL");
    public static String street =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_STREET");
    public static String address =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_ADDRESS");
    public static String gender =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"INPUT_REGISTER_GENDER");

    public static String textErrorFormat =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"ERROR_INPUT");
    public static List listErrorFormat =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"LIST_ERROR_WRONG_FORMAT");
    public static List listErrorNotice =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"LIST_ERROR_MESSAGE");

    public static String getNamePackage =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"GET_NAME_PACKAGE");
    public static String getNameTitle =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"GET_NAME_TITLE");
    public static String getGoodsCode =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_REGISTER_DATA,"REGEX_GOODS_CODE");

}
