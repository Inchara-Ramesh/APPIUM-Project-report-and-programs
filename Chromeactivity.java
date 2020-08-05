package Chromeactivity1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class Chromeactivity {
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
    public void activity1() {
    	driver.get("https://www.training-support.net/selenium");
    	wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().scrollIntoView(text(\"To-Do List Elements get added at run time\"))")).click();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	 driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Add tasks to list");
    	 driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Get number of tasks");
    	 driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Clear the list");
    	 //driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
    	 
    	 driver.findElement(MobileBy.xpath("//android.view.View[1]")).click();
    	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	 driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]")).click();
    	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	 driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]")).click();
    	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	 driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]")).click();
    	 
    	//String gettext = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]"))).getText();
     	//driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	 
    	  }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}