package PageObjects;

import PageElements.HomePageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static PageElements.HomePageElements.*;
import static PageElements.TestElements.*;

public class HomePageObject
{
    WebDriver drv;
    WebDriverWait drvW;
    private ExtentTest extTest = null;

    public HomePageObject()
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = new FirefoxDriver();
        drvW = new WebDriverWait(drv, 15);
    }

    public HomePageObject(WebDriver d)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, 15);
    }

    public HomePageObject(WebDriver d, int w)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, w);
    }

    public HomePageObject(WebDriver d, WebDriverWait w)
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

    public void NavigateToMain()
    {
        drv.navigate().to(TestPageUrl);
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageElements.XpHomeSubscribeBtn)));
    }

    public void NavigateToOnboarding()
    {
        drv.findElement(By.xpath(HomePageElements.XpHomeSubscribeBtn)).click();
        drvW.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XpGenLoader)));
        Assert.assertTrue(drv.getCurrentUrl().equals(TestPageUrl + TestPageSubPath));
    }
}
