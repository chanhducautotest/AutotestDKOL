package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;

import static constants.CommonInternet.urlHome;

public class CommonCamera {
    public static final String DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/CameraData.json";

    //Phần đọc dữ liệu từ file json
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static String urlCamera= urlHome +
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"PATH_CAMERA");

    public static String registerCameraUrl= urlHome +
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"REGISTER_CAMERA_URL");
    public static String inputWrongFormat =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"INPUT_WRONG_FORMAT");
    public static String wrongFormatPhone =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"WRONG_FORMAT_PHONE");
    public static String wrongFormatId =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"WRONG_FORMAT_ID");
    public static String wrongFormatMail =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"WRONG_FORMAT_MAIL");
    public static String regexPackageNameFromURL =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"REGEX_PACKAGE_CAMERA_NAME");
    public static String regexPackageNameFromTitle =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"REGEX_PACKAGE_TITLE_CAMERA");
    public static List listPaymentMethod =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"LIST_PAYMENT_METHODS");
    public static String inputVoucherCamera =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"VOUCHER_TEXT");

    public static List listPrivateInfoCamera =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"LIST_TEXT_PRIVATE_INFO_CAMERA");

    public static String inputAddressCamera =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"INPUT_REGISTER_ADDRESS_CAMERA");
    public static String inputWardCamera =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"INPUT_REGISTER_CAMERA_WARD");
    public static String inputDistrictCamera =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"INPUT_REGISTER_CAMERA_DISTRICT");
    public static String inputStreetCamera =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"INPUT_REGISTER_STREET_CAMERA");

    public static List listErrorNoticeCamera =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"LIST_ERROR_MESSAGE_CAMERA");

    public static List listErrorFormatCamera =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_CAMERA_PLAY,"LIST_ERROR_FORMAT_CAMERA");

}
