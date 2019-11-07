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
        hpo.NavigateToMain();
        hpo.NavigateToOnboarding();
    }
    @When("^Customer and payment information are filled.$")
    public void customer_and_payment_information_are_filled() throws Throwable
    {
        if((wdrFf == null) ||  !(wdrFf instanceof FirefoxDriver))
        {
            opo = new OnboardingPageObject();
        }
        else
        {
            opo = new OnboardingPageObject(wdrFf);
        }
        opo.CheckUrl();
        opo.SelectMonthly();
        opo.FillCustomerInfo();
        opo.CustomerRegister();

        if((wdrFf == null) ||  !(wdrFf instanceof FirefoxDriver))
        {
            oppo = new OrderPaymentPageObject();
        }
        else
        {
            oppo = new OrderPaymentPageObject(wdrFf);
        }
        oppo.CheckOrderPaymentInfo();
        oppo.FillCustomerInfo();
    }
    @Then("^Ends with alert.$")
    public void ends_with_alert() throws Throwable
    {
        Assert.assertTrue(wdrFf.switchTo().alert().getText().equals(AlertOrderPaymentWrongCCNoText));
    }
}
