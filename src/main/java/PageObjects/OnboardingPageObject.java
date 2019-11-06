package PageObjects;

import PageElements.OnboardingPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.Random;

import static PageElements.OnboardingPageElements.*;
import static PageElements.TestElements.*;

public class OnboardingPageObject
{
    WebDriver drv;
    WebDriverWait drvW;
    private ExtentTest extTest = null;

    public OnboardingPageObject()
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = new FirefoxDriver();
        drvW = new WebDriverWait(drv, 15);
    }

    public OnboardingPageObject(WebDriver d)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, 15);
    }

    public OnboardingPageObject(WebDriver d, int w)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, w);
    }

    public OnboardingPageObject(WebDriver d, WebDriverWait w)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = w;
    }

    public ExtentTest getExtTest() {
        return extTest;
    }

    public void setExtTest(ExtentTest extTest)
    {
        this.extTest = extTest;
    }

    public WebDriver GetDriver()
    {
        return drv;
    }
    public WebDriverWait GetDriverWait()
    {
        return drvW;
    }

    public void CheckUrl()
    {
        Assert.assertTrue(drv.getCurrentUrl().equals(TestPageUrl + TestPageSubPath));
    }

    public void SelectMonthly()
    {
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboradingStep1)));
        WebElement Monthly = drv.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month));
        String Price = Monthly.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month + OnboardingPageElements.XpOnboradingStep1MonthPrice)).getText();

        Assert.assertTrue(Price.substring(0,1).equals(TestCurrency));
        String javasucks = Price.substring(1,3);
        Assert.assertTrue(Price.substring(1,3).equals(TestPrice));

        drv.findElement(By.xpath(OnboardingPageElements.XpOnboradingStep1Month)).click();

        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingPackDivSelection)));
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingPackDivSelection + OnboardingPageElements.XpOnboardingPackSelectionMonthFreeWeekSubBtn)).click();
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
    }

    public void FillCustomerInfo()
    {
        Random r = new Random();
        String Abc = "abcdefghijklmnopqrstuvwzyx", Email = "";
        for (int i = 0; i < 8; i++)
        {
            if(i==3){Email = Email+"@";}
            else if(i==7){Email=Email+".com";}
            else
            {Email=Email+Abc.charAt(r.nextInt(Abc.length()));}
        }
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingFirstName)));
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingFirstName)).sendKeys(TestFirstName);
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingLastName)).sendKeys(TestLastName);
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingEmailOrPhone)).sendKeys(Email);
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingPassword)).sendKeys(TestPassword);
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingRegister)));
    }

    public void CustomerRegister()
    {
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OnboardingPageElements.XpOnboardingRegister)));
        drv.findElement(By.xpath(OnboardingPageElements.XpOnboardingRegister)).click();
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpOnboardingRegisterBtnLoader)));
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOnboardingRegisterResultPopUp)));
        drv.findElement(By.xpath(XpOnboardingRegisterResultPopUp)).click();
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        drv.findElement(By.xpath(XpOnboardingRegisterTermsCheckBox)).click();
        drv.findElement(By.xpath(XpOnboardingRegisterPayNow)).click();
    }
}
