package com.carousell.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carousell.helper.AppiumAndroidBase;
import com.carousell.helper.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * A page for a Logging in to Carousell app
 */
public class LoginPageObject extends AppiumAndroidBase{
	/**
     *  Constructor to assign driver of type AppiumDriver
     */
	public LoginPageObject(AppiumDriver driver) {
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	
	/**
     * Explicit wait of 10 secs
     */
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	/**
     * Creating util Object of class Utils
     */
	Utils util = new Utils(driver);
	
	
	/**
     * Login button from the landing page
     */
	private static final String LOGIN_MAIN_SCREEN = "com.thecarousell.Carousell:id/login_button";
	
	/**
     * Single sign on (SSO) pop up
     */
	private static final String SINGLE_SIGNON = "com.google.android.gms:id/credential_picker_layout";
	
	/**
     * None of the above button from SSO pop up
     */
	private static final String NONE_OF_THE_ABOVE = "com.google.android.gms:id/cancel";
	
	/**
     * Username text field
     */
	private static final String USERNAME_FIELD = "com.thecarousell.Carousell:id/layout_username";
	
	/**
     * Password text field
     */
	private static final String PASSWORD_FIELD = "com.thecarousell.Carousell:id/layout_password";
	
	/**
     * Login submit button
     */
	private static final String LOGIN_SUBMIT = "com.thecarousell.Carousell:id/login_button";
	
	/**
     * Carousell searcg bar locator
     */
	private static final String CAROUSELL_SEARCH_BAR = "com.thecarousell.Carousell:id/header_page_search_text_field";
	
	/**
     * Generic widget frame locator
     */
	private static final String WIDGET_FRAME = "android.widget.FrameLayout";
	
	/**
     * Edit text locator
     */
	private static final String EDIT_TEXT = "android.widget.EditText";
	
	
	/**
     * PageFactory element assignments  
     */
	@AndroidFindBy(id = LOGIN_MAIN_SCREEN)
	private MobileElement login;
	
	@AndroidFindBy(id = SINGLE_SIGNON)
	private MobileElement sso;
	
	@AndroidFindBy(id = NONE_OF_THE_ABOVE)
	private MobileElement noneOfTheAbove;

	@AndroidFindBy(id = USERNAME_FIELD)
	private MobileElement username_field;

	@AndroidFindBy(id = PASSWORD_FIELD)
	private MobileElement password_field;

	@AndroidFindBy(id = LOGIN_SUBMIT)
	private MobileElement loginBttn;
	
	@AndroidFindBy(id = CAROUSELL_SEARCH_BAR)
	private MobileElement carousellActBar;

	/**
     * Method to click login from the Landing page 
     */
	public void clickLoginFromMainScreen() {
		login.click();
	}

	/**
     * Method to enter login credentials
     * @param username
     * @param password  
     */
	public void enterCredentials(String username, String password) {
		username_field.findElementByClassName(WIDGET_FRAME).findElementByClassName(EDIT_TEXT).sendKeys(username);
		password_field.findElementByClassName(WIDGET_FRAME).findElementByClassName(EDIT_TEXT).sendKeys(password);
	}
	
	/**
     * Method to submit the login credentials  
     */
	public void submitCredentials() {
		loginBttn.click();
		wait.until(ExpectedConditions.visibilityOf(carousellActBar));
	}
	
	/**
     * Main Method to enter login credentials and verify succesfull login
     * @param username
     * @param password  
     */
	public void loginTillCarousellMainPage(String username, String password){
		try
			{
			clickLoginFromMainScreen();
			if(sso.isDisplayed()){
				noneOfTheAbove.click();
				enterCredentials(username, password);
				submitCredentials();
				}
			}	
			catch(Exception e)
				{
					enterCredentials(username, password);
					submitCredentials();
				}
	}
}
