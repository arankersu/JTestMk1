package Tests;

import ExtentReports.ExtentManager;
import ExtentReports.ExtentTestManager;
import PageObjects.HomePageObject;
import PageObjects.OnboardingPageObject;
import PageObjects.OrderPaymentPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListener;


@Listeners({ TestListener.class })
public class JTestMain
{
    WebDriver wdrFf;
    //PageTest objHomePage;
    //PageTest t1;

    @BeforeTest
    public void setup()
    {
    }
    public WebDriver GetDriver()
    {
        return wdrFf;
    }

    @Test (priority = 1, description="Navigate")
    public void PageNavMain()
    {
        ExtentTestManager.getTest().setDescription("PageNavMain");
        HomePageObject hpo = new HomePageObject();
        wdrFf = hpo.GetDriver();
        hpo.NavigateToMain();
        hpo.NavigateToOnboarding();
    }

    @Test (priority = 2, description = "Onboarding", dependsOnMethods = {"PageNavMain"})
    public void PageLogin()
    {
        ExtentTestManager.getTest().setDescription("PageOnboarding");
        OnboardingPageObject opo;
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
    }
    @Test (priority = 3, description = "OrderPayment", dependsOnMethods = {"PageLogin"})
    public void PageOrderPayment()
    {
        ExtentTestManager.getTest().setDescription("PageOrderPayment");
        OrderPaymentPageObject oppo;
        if((wdrFf == null) ||  !(wdrFf instanceof FirefoxDriver))
        {
            oppo = new OrderPaymentPageObject();
        }
        else
        {
            oppo = new OrderPaymentPageObject(wdrFf);
        }

        //oppo.CheckUrl();
        oppo.CheckOrderPaymentInfo();
        oppo.FillCustomerInfo();
    }
}
