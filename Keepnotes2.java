package Keepnotes2;

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

public class Keepnotes2 {
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
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        MobileElement remainderclick = driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view");
        remainderclick.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        MobileElement dropdown = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Time - Currently selected - 7:00 PM\"]/android.widget.Spinner");
        dropdown.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        MobileElement afternoon = driver.findElementByXPath("//android.widget.TextView[1][@text ='Evening']");
        afternoon.click();
        driver.findElementById("com.google.android.keep:id/save").click();
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        String confirmdescription = driver.findElementByXPath("//android.widget.TextView[@text='Today, 6:00 PM']").getText();
        Assert.assertEquals(confirmdescription, "Today, 6:00 PM");
        
       // //driver.findElementByClassName("android.widget.Spinner").sendKeys("1:00 PM");
      //  driver.findElementById("com.google.android.keep:id/save").click();
     //   String remindernotification = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[8]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup").getText();
       // Assert.assertEquals(remindernotification, "Tommorrow, 1:00 PM");
        
    }}