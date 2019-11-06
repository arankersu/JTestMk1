package PageElements;

public class OrderPaymentPageElements
{
    public static final String OrderPaymentUrl = "https://secure.ogone.com/ncol/prod//orderstandard_utf8.asp";
    public static final String XpOrderPaymentOrderNumber = "//td/small[contains(text(), 'Order reference :')]/ancestor::tr/td[2]";
    public static final String XpOrderPaymentTotalCharge = "//td/small[contains(text(), 'Total charge :')]/ancestor::tr/td[2]";//Find the tag -> tags parent /tr -> to the charge /td
    public static final String XpOrderPaymentCCName = "//input[@id = \"Ecom_Payment_Card_Name\"]";
    public static final String XpOrderPaymentCCNo = "//input[@id = \"Ecom_Payment_Card_Number\"]";
    public static final String XpOrderPaymentCCExpiryMonth = "//select[@id = \"Ecom_Payment_Card_ExpDate_Month\"]/option[@value = \"02\"]";
    public static final String XpOrderPaymentCCExpiryYear = "//select[@id = \"Ecom_Payment_Card_ExpDate_Year\"]/option[@value = \"2023\"]";
    public static final String XpOrderPaymentCCCvv = "//input[@id = \"Ecom_Payment_Card_Verification\"]";
    public static final String XpOrderPaymentComplete = "//input[@name = \"payment\"]";
    public static final String AlertOrderPaymentWrongCCNoText = "This field is not valid.: 'Card number'";
}
