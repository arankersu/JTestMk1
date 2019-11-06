package CucumberStepDef;

import PageElements.OnboardingPageElements;
import PageObjects.HomePageObject;
import PageObjects.OnboardingPageObject;
import PageObjects.OrderPaymentPageObject;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static PageElements.OnboardingPageElements.*;
import static PageElements.OrderPaymentPageElements.*;
import static PageElements.TestElements.*;

public class JCSteps
{
    HomePageObject hpo;
    OnboardingPageObject opo;
    OrderPaymentPageObject oppo;
    WebDriver wdrFf;
    WebDriverWait wdrvW;

    /*@Before
    public void genereate()
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        WebDriver wdrFf = new FirefoxDriver();
        WebDriverWait wdrvW = new WebDriverWait(wdrFf, 15);
    }*/

    @Given("^Open the Firefox and start page objects.$")
    public void open_the_Firefox_and_start_page_objects() throws Throwable
    {
        hpo = new HomePageObject();
        wdrFf = hpo.GetDriver();
        if((wdrFf == null) ||  !(wdrFf instanceof FirefoxDriver))
        {
            opo = new OnboardingPageObject();
        }
        else
        {
            opo = new OnboardingPageObject(wdrFf);
        }
        wdrvW = opo.GetDriverWait();
    }
    @When("^Customer and payment information are filled.$")
    public void customer_and_payment_information_are_filled() throws Throwable
    {
        hpo.NavigateToMain();
        hpo.NavigateToOnboarding();
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboradingStep1)));
        WebElement Monthly = wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month));
        String Price = Monthly.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month + OnboardingPageElements.XpOnboradingStep1MonthPrice)).getText();

        Assert.assertTrue(Price.substring(0,1).equals(TestCurrency));
        String javasucks = Price.substring(1,3);
        Assert.assertTrue(Price.substring(1,3).equals(TestPrice));

        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month)).click();

        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingPackDivSelection)));
        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingPackDivSelection + OnboardingPageElements.XpOnboardingPackSelectionMonthFreeWeekSubBtn)).click();
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingFirstName)));

        Random r = new Random();
        String Abc = "abcdefghijklmnopqrstuvwzyx", Email = "";
        for (int i = 0; i < 8; i++)
        {
            if(i==3){Email = Email+"@";}
            else if(i==7){Email=Email+".com";}
            else
            {Email=Email+Abc.charAt(r.nextInt(Abc.length()));}
        }

        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingFirstName)).sendKeys(TestFirstName);
        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingLastName)).sendKeys(TestLastName);
        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingEmailOrPhone)).sendKeys(Email);
        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingPassword)).sendKeys(TestPassword);
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingRegister)));
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingRegister)));
        wdrFf.findElement(By.xpath(OnboardingPageElements.XpOnboardingRegister)).click();
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpOnboardingRegisterBtnLoader)));
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOnboardingRegisterResultPopUp)));
        wdrFf.findElement(By.xpath(XpOnboardingRegisterResultPopUp)).click();
        wdrvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        wdrFf.findElement(By.xpath(XpOnboardingRegisterTermsCheckBox)).click();
        wdrFf.findElement(By.xpath(XpOnboardingRegisterPayNow)).click();

        if((wdrFf == null) ||  !(wdrFf instanceof FirefoxDriver))
        {
            oppo = new OrderPaymentPageObject();
        }
        else
        {
            oppo = new OrderPaymentPageObject(wdrFf);
        }

        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOrderPaymentCCNo)));
        String CheckPrice = "1.00", OrderNumber = "";
        OrderNumber = wdrFf.findElement(By.xpath(XpOrderPaymentOrderNumber)).getText().trim();
        Assert.assertTrue(wdrFf.findElement(By.xpath(XpOrderPaymentTotalCharge)).getText().trim().substring(0, 4).equals(CheckPrice));
        String CCName = "Addon Test", CCNo = "0000 1234 1234 1234", CCCvv = "000";
        wdrvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOrderPaymentCCNo)));
        wdrFf.findElement(By.xpath(XpOrderPaymentCCName)).sendKeys(CCName);
        wdrFf.findElement(By.xpath(XpOrderPaymentCCNo)).sendKeys(CCNo);
        wdrFf.findElement(By.xpath(XpOrderPaymentCCExpiryMonth)).click();
        wdrFf.findElement(By.xpath(XpOrderPaymentCCExpiryYear)).click();
        wdrFf.findElement(By.xpath(XpOrderPaymentCCCvv)).sendKeys(CCCvv);
        wdrFf.findElement(By.xpath(XpOrderPaymentComplete)).click();
    }
    @Then("^Ends with alert.$")
    public void ends_with_alert() throws Throwable
    {
        Assert.assertTrue(wdrFf.switchTo().alert().getText().equals(AlertOrderPaymentWrongCCNoText));
    }
}
