package PageObjects;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static PageElements.OrderPaymentPageElements.*;

public class OrderPaymentPageObject
{
    WebDriver drv;
    WebDriverWait drvW;
    private ExtentTest extTest = null;

    public OrderPaymentPageObject()
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = new FirefoxDriver();
        drvW = new WebDriverWait(drv, 15);
    }

    public OrderPaymentPageObject(WebDriver d)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, 15);
    }

    public OrderPaymentPageObject(WebDriver d, int w)
    {
        System.setProperty("webdriver.gecko.driver", "WebDrivers\\geckodriver.exe");
        drv = d;
        drvW = new WebDriverWait(drv, w);
    }

    public OrderPaymentPageObject(WebDriver d, WebDriverWait w)
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
        Assert.assertTrue(drv.getCurrentUrl().equals(OrderPaymentUrl));
    }

    public void CheckOrderPaymentInfo()
    {
        String Price = "1.00", OrderNumber = "";
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOrderPaymentCCNo)));
        OrderNumber = drv.findElement(By.xpath(XpOrderPaymentOrderNumber)).getText().trim();
        Assert.assertTrue(drv.findElement(By.xpath(XpOrderPaymentTotalCharge)).getText().trim().substring(0, 4).equals(Price));
    }

    public void FillCustomerInfo()
    {
        String CCName = "Addon Test", CCNo = "0000 1234 1234 1234", CCCvv = "000";
        drvW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpOrderPaymentCCNo)));
        drv.findElement(By.xpath(XpOrderPaymentCCName)).sendKeys(CCName);
        drv.findElement(By.xpath(XpOrderPaymentCCNo)).sendKeys(CCNo);
        drv.findElement(By.xpath(XpOrderPaymentCCExpiryMonth)).click();
        drv.findElement(By.xpath(XpOrderPaymentCCExpiryYear)).click();
        drv.findElement(By.xpath(XpOrderPaymentCCCvv)).sendKeys(CCCvv);
        drv.findElement(By.xpath(XpOrderPaymentComplete)).click();
        Assert.assertTrue(drv.switchTo().alert().getText().equals(AlertOrderPaymentWrongCCNoText));
    }
}
