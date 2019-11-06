package PageElements;

public class OnboardingPageElements
{
    public static final String XpOnboradingStep1 = "//div[@class = \"container-onboarding step1\"]";
    public static final String XpOnboradingStep1Month = "//div[@class = \"container-onboarding step1\"]//span[text() = \"ONE MONTH\"]";
    public static final String XpOnboradingStep1MonthPrice = "/parent::div//div/span[2]";// -> span[@class = \"subscription-price-item price fz-14 fw-bold\"] also {0} does not work in java
    public static final String XpOnboardingPackDivSelection = "//span[text() = \"Monthly Pass with One Week Free Trial\"]/parent::div[@class = \"subscription-package open\"]";
    public static final String XpOnboardingPackSelectionMonthFreeWeekSubBtn = "//div[@class = \"detail\"]//div/a[@data-text = \"SUBSCRIBE\"]";
    public static final String XpOnboardingFirstName = "//input[@name = \"FirstName\"]";
    public static final String XpOnboardingLastName = "//input[@name = \"LastName\"]";
    public static final String XpOnboardingEmailOrPhone = "//input[@name = \"EmailOrPhone\"]";
    public static final String XpOnboardingPassword = "//input[@name = \"Password\"]";
    public static final String XpOnboardingRegister = "//input[@data-text = \"CREATE ACCOUNT\"]";
    public static final String XpOnboardingRegisterBtnLoader = "//img[@class = \"loading-form centered-axis-xy loading\"]";
    public static final String XpOnboardingRegisterResultPopUp = "//a[@id = \"close\"]";
    public static final String XpOnboardingRegisterTermsCheckBox = "//div[@class = \"custom-checkbox\"]";
    public static final String XpOnboardingRegisterPayNow = "//input[@data-text = \"PAY NOW\"]";
}
