package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.ArrayList;
import java.util.List;

public final class Common {
    public static final String DATA_TEST_FILE_PATH_COMMON = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/Data.json";

    //Phần đọc dữ liệu từ file json
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    /* Common */
    public static String url = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST");
    public static String urlSkyRegister = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_INTERNET_SKY_REGISTER");
    public static String urlRegister = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_INTERNET_REGISTER");
    public static String urlFoxpay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_FOX_PAY");
    public static String urlService = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_INTERNET_SERVICE");
    public static String urlPayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_INTERNET_PAYMENT");
    public static String urlFinishRegister = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST_FINISH_REGISTER");
    public static String urlGTBB = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_TEST_MA_GIOI_THIEU_BAN_BE");
    public static String maGTBBVoucher =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/MA_GTBB");

    //-----------------------------------------------------------------------------------------
    /* Home */
    public static final String DATA_TEST_FILE_PATH_HOME = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/HomeData.json";
    public static String DCLD = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"DCLD");
    public static String ghiChu = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"GHICHU");
    public static String textbtnXN = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"TEXT_BTNXACNHAN");
    public static List getListTT = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "PROVINCE");
    public static List getList1QH = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "QUAN_HUYEN_TPHCM");
    public static String textTBQH =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME, "TEXT_THONG_BAO_CHON_QH");

    public static String expectedTextTC1_21 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"NOI_DUNG_THONG_BAO_MA_GTBB_PART1")
                    + maGTBBVoucher
                    + jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"NOI_DUNG_THONG_BAO_MA_GTBB_PART2");
    public static String urlInternet =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_INTERNET");
    public static String urlHomePage =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_HOME_PAGE");
    public static String urlFPTCamera =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_FPT_CAMERA");
    public static String urlFPTPlayBox =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_FPTPLAYBOX");
    public static List<String> listTextTimKiem =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "LIST_TEXT_POPUP_TIMKIEM");
    public static String txtDonHangNotFound =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME, "DON_HANG_NOT_FOUND");
    public static String urlDetailDonHang =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_CHI_TIET_DH");
    public static List getListKH =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "LIST_TEXT_CHUA_LA_KHFPT");
    public static String getURL_DKOL =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_DKOL");
    public static String getURL_KM =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_KM");
    public static String getURL_TDGD=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_TDGD");
    public static String getURL_TT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_TT");
    public static String getURL_HiFPT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_HIFPT");
    public static String getURL_YT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_YT");
    public static String getURL_IG=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_IG");
    public static String getURL_FB=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FB");
    public static String getURL_ZL=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_ZL");
    public static ArrayList listFromJSONTC1_98 =
            new ArrayList(jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "listVeFPTTelecom"));
    public static ArrayList listFromJSONTC1_104 =
            new ArrayList(jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME
                    , "listKhachHangFPTTelecom"));
    public static String getURL_FPTPlay=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTPLAY");
    public static String getURL_FPTCamera=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTCamera");
    public static String getTEXTCOPY = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"TEXT_COPY");

    public static String urlHome = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_TEST");
    /* Payment */
    public static String napasCardNum = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"ATM_CARD_NUMBER");
    public static String napasCardName = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"ATM_CARD_NAME");
    public static String napasCardIssueDate = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"ATM_CARD_EXP_DATE");
    public static String napasCardOtp = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"ATM_CARD_OTP");
}
