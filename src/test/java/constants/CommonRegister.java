package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;

public final class CommonRegister {

    /**
     * Đường dẫn đọc dữ liệu từ file json
     */
    public static final String DATA_TEST_FILE_PATH_REGISTER = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/RegisterData.json";

    /**
     * Đọc dữ liệu ở file json
     */
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static List getListSetUpInfo =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TITLE_SETUP_INFO");
    public static List ListPlaceholderAppartment =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_PLACEHOLDER_APPARTMENT");

    public static List listInfoPayment =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TITLE_INFO_PAYMENT");

    public static List listDetailOrder =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TEXT_DETAIL_ORDER");

    public static List listPopupPayment =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TEXT_METHOD_PAYMENT");
    public static List listPrivateInfo =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TEXT_PRIVATE_INFO");

    public static String statusPayment =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"REGEX_STATUS_PAYMENT");

    public static String inputName =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_NAME");
    public static String inputPhone =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_PHONE");
    public static String inputBirthday =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_BIRTHDAY");
    public static String inputIdNumber =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_ID");
    public static String inputEmail =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_EMAIL");

    public static String inputStreet1 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_STREET_1");
    public static String inputAddress =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_ADDRESS");
    public static String inputGender =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_GENDER");
    public static String inputWard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_WARD");
    public static String inputDistrict =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_DISTRICT");
    public static String inputCity =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_REGISTER_CITY");

    public static String inputPhoneNumber =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_PHONE_NUMBER");

    public static String inputMale =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_LABEL_MALE");
    public static String inputFemale =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_LABEL_FEMALE");
    public static String inputDropdownWard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DROPDOWN_MENU_WARD");

    public static String inputTime01 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DROPDOWN_TIME01");
    public static String inputTime02 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DROPDOWN_TIME02");
    public static String inputTime03 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DROPDOWN_TIME03");
    public static String inputTime04 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DROPDOWN_TIME04");

    public static String inputNumberCard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_NUMBER_CARD");
    public static String inputFullNameCard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_FULLNAME_CARD");
    public static String inputDateCard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_DATE_CARD");
    public static String inputOTPCard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_OTP_CARD");
    public static String inputWrongOTP =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_WRONG_OTP");
    public static String inputWrongOTPWithSpace =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_WRONG_OTP_WITH_SPACE");
    public static String textWrongOTPAlarm =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"TEXT_WRONG_OTP_ALARM");
    public static String textFailPaymentAlarm =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"TEXT_FAIL_PAYMENT_ALARM");

    public static String inputSearchDropdownProvince =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DROPDOWN_PROVINCE");
    public static String inputSearchDropdownDistrict =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DROPDOWN_DISTRICT");
    public static String inputSearchDropdownWard =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DROPDOWN_WARD");
    public static String inputSearchDropdownStreet =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DROPDOWN_STREET");

    public static String urlQRMomo =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/URL_QR_MOMO");
    public static String urlQRVNPay =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/URL_QR_VNPAY");

    public static String msgPopupNotification =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"CHECK_MESSAGE_POPUP");

    public static List listInformationPopupVoucher =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TEXT_POPUP_VOUCHER");
    public static List listInformationPopupVoucherClose =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_REGISTER,"LIST_TEXT_POPUP_VOUCHER_CLOSE");

    // URL của 4 bước đăng ký
    public static String urlRegistrationInfo =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER, "/LINK_URL_REGISTRATION_INFO");
    public static String urlChooseService =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER, "/LINK_URL_CHOOSE_SERVICE");
    public static String urlBillingInfo =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER, "/LINK_URL_BILLING_INFO");
    public static String urlCompleteRegistration =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER, "/LINK_URL_COMPLETE_REGISTRATION");
    public static String urlPaymentATM =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/URL_PAYMENT_ATM");
    public static String urlAboutFPTRule =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER, "/LINK_URL_ABOUT_FPT_RULE");

    public static String codeFriendsVoucher =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/CODE_FRIENDS");

    public static String codeFriendsVoucherError =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/CODE_FRIENDS_ERROR");

    public static String messageVoucherError =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/MESSAGE_APPLY_VOUCHER_ERROR");

    public static String urlFinish =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_REGISTER,"/URL_FINISH");

    public static String inputSearchProvince01 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_PROVINCE_01");
    public static String inputSearchProvince02 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_PROVINCE_02");
    public static String inputSearchDistrict01 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DISTRICT_01");
    public static String inputSearchDistrict02 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_DISTRICT_02");
    public static String inputSearchWard01 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_WARD_01");
    public static String inputSearchWard02 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_WARD_02");
    public static String inputSearchStreet01 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_STREET_01");
    public static String inputSearchStreet02 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_REGISTER,"INPUT_SEARCH_STREET_02");



}
