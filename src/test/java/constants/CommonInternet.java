package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;

public final class CommonInternet {

    /**
     * Đường dẫn đọc dữ liệu từ file json
     */
    public static final String DATA_TEST_FILE_PATH_INTERNET = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/InternetData.json";

    /**
     * Đọc dữ liệu ở file json
     */
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static String getURLRegister =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_INTERNET_REGISTER");
    public static String getGetURLService =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_INTERNET_SERVICE");

    public static String getURLINTERNET =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_TEST_INTERNET");

    public static String urlHome =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_TEST_HOME");

    public static String getURLService =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_TEST_SERVICE");

    public static String getURLPayment =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_TEST_PAYMENT");

    public static String getURLFPTRole =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_INTERNET,"/URL_FPT_ABOUT_ROLE");

    public static String getPrice=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"REGULAR_EXPRESSION_FORM_PRICE");

    public static String inputProvinceMenu =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_PROVINCE");
    public static String inputDistrictMenu =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_DISTRICT");
    public static String inputWardMenu =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_WARD");
    public static String inputStreetMenu =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_STREET");
    public static String inputHouseNumberMenu =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_HOUSE_NUMBER");

    public static String inputFullNameTxt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_FULL_NAME");
    public static String inputPhoneTxt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_PHONE");
    public static String inputBirthdayTxt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_BIRTHDAY");
    public static String inputCMNDTxt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_CMND");
    public static String inputEmailTxt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_EMAIL");
    public static String inputGenderFemale = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_GENDER_FEMALE");
    public static String inputGenderMale = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_GENDER_MALE");
    public static String inputBlock = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_BLOCK");
    public static String inputFloor = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_FLOOR");
    public static String inputRoom = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_ROOM");
    public static String inputAppartmentName10Characters = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_INTERNET,"INPUT_APPARTMENT_NAME_10_CHARACTERS");
}
