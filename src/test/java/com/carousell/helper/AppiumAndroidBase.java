package com.carousell.helper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */

public abstract class AppiumAndroidBase {
	  /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    protected static AndroidDriver<AndroidElement> driver;

    /**
     * This method runs before class loads.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to appium server.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
    	
    	 /**
         * Set up the absolute app set up path.
         */
    	File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app/");
        File app = new File(appDir, Utils.readProperty("app.name"));
        
    	 /**
         * Dynamically create URL by passing arguments from the config file.
         */
        String completeURL = "http://" + Utils.readProperty("run.ip") + ":" + Utils.readProperty("run.port") + "/wd/hub";
       
        /**
         * Initialize Desired Capabilities class which a key value pair collection
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        /**
         * Assigning appropriate desired capability values to the Capability keys
         */
        capabilities.setCapability(MobileCapabilityType.UDID, Utils.readProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Utils.readProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Utils.readProperty("app.appPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, Utils.readProperty("app.waitActivity"));
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        /**
         * Initialize appium service URL
         */
        URL appiumServiceUrl = new URL(completeURL);
        driver = new AndroidDriver<AndroidElement>(appiumServiceUrl, capabilities);
        
      //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    /**
     * Always remember to quit
     */
    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
