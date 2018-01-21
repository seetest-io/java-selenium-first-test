package TestNG;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ChromeTest {
    private static final String ACCESSKEY = "eyJ4cC51Ijo0LCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd09UVXlNVFkwT1RFeE1nIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MzE4ODU4NDQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.KvI_SP4BjWcZ1WUHOJP9bAiwdv-UQfcTn59GM9rIvyk";

    String CLOUDURL = "http://mastercloud/wd/hub/";
    String testName= "Selenium Test on Chrome";
    RemoteWebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        //Set Browser Type
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

        //Set Grid capabilities
        dc.setCapability("accessKey", ACCESSKEY);
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", testName);

        driver = new RemoteWebDriver(new URL(CLOUDURL), dc);
    }


    @Test
    public void testSeleniumOnChrome() {
        driver.get("https://seetest.io");

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Manual']")));
        WebElement manualNavLink = driver.findElement(By.xpath("//*[text()='Manual']"));
        manualNavLink.click();

        WebElement automationNavLink = driver.findElement(By.xpath("//*[text()='Automation']"));
        automationNavLink.click();

        WebElement webinarFooterLink = driver.findElement(By.xpath("//*[text()='Webinars']"));

        webinarFooterLink.click();

        String webinarH2TitleText = driver.findElement(By.xpath("//h2[1]")).getText();

        System.out.println("The title of the first h2 is: " + webinarH2TitleText);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
