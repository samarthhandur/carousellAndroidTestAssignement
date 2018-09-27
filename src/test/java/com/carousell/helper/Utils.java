package com.carousell.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Utils extends AppiumAndroidBase{
	@SuppressWarnings("rawtypes")
	public Utils(AppiumDriver driver) {
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
	public void scrollAndClickElement(String element){
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+element+"\").instance(0))").click();
	 }
	
	public void scrollTillElement(MobileElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" , element);
	}
	public void enterText(MobileElement el, String txt){
		el.sendKeys(txt);
	}
	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			
			value = prop.getProperty(property);
			
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
