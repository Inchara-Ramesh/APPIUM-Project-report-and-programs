package Chromeactivity3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Chromeactivity3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
       // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "bb9d156c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
       
    }

    @Test
    public void validlogin() {
    	driver.get("https://www.training-support.net/selenium");
    	wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().scrollIntoView(text(\"Popups Tooltips and Modals\"))")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Sign In']")));
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@text='Welcome Back, admin']")).getText();
        Assert.assertEquals(getvalue, "Welcome Back, admin");
    	
    }
    @Test
    public void invalidlogin() {
    	driver.get("https://www.training-support.net/selenium");
    	wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().scrollIntoView(text(\"Popups Tooltips and Modals\"))")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Sign In']")));
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("passkord");
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")).getText();
        Assert.assertEquals(getvalue, "Invalid Credentials");
    }}