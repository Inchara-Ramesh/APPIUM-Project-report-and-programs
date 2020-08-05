package Keepnotes1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
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

public class Keepnotes1 {
   AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "bb9d156c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
       
    }

    @Test
    public  void addingactivity() {
    	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	//MobileElement getstarted = driver.findElementById("com.google.android.apps.keep:id/welcome_get_started");
       // getstarted.click();
        wait = new WebDriverWait(driver, 5);
        WebElement newnote = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@resource-id=\"com.google.android.keep:id/new_note_button\"]")));
         //driver.findElementsByAccessibilityId("com.google.android.keep:id/new_note_button")
       newnote.click();
        //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("New text note")));
    	
       // driver.findElementById("New text note").click();
        // newtext.click();
       driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("addtitle");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Description");
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        
        String confirmtitle = driver.findElementByXPath("//android.widget.TextView[1][@text='addtitle']").getText();
        Assert.assertEquals(confirmtitle, "addtitle");
        
        String confirmdescription = driver.findElementByXPath("//android.widget.TextView[2][@text='Description']").getText();
        Assert.assertEquals(confirmdescription, "Description");
    }}