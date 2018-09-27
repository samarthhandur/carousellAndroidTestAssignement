package com.carousell.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carousell.helper.AppiumAndroidBase;
import com.carousell.helper.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

/**
 * A page for a adding sell items
 */

public class AddItemForSellPageObject extends AppiumAndroidBase{
	
	/**
     *  Constructor to assign driver of type AppiumDriver
     */
	public AddItemForSellPageObject(AppiumDriver driver) {
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
     * Sell button locator
     */
	private static final String SELL_BUTTON = "com.thecarousell.Carousell:id/button_sell";
	 /**
     * Image list view
     */
	private static final String IMAGE_LIST = "com.thecarousell.Carousell:id/list_pictures";
	
	 /**
     * First image view
     */
	private static final String FIRST_IMAGE = "com.thecarousell.Carousell:id/view_thumbnail";
	 
	/**
     * "Next" button 
     */
	private static final String NEXT_BTTN = "com.thecarousell.Carousell:id/action_done";
	
	/**
     * Image selected for listing 
     */
	private static final String CATEGORY_IMAGE_SELECTED = "(//android.widget.ImageView[@content-desc=\"Image\"])[1]";
	private static final String TEXT_VIEW = "android.widget.TextView";
	
	/**
     * Xpath for selecting "Everything Else" category 
     */
	private static final String SELECT_CATEGORY_EVERYTHING_ELSE = "//android.widget.FrameLayout[@content-desc=\"24\"]";
	
	/**
     * "Everything Else" text for scrolling into the list 
     */
	private static final String CATEGORY_TEXT = "Everything Else";
	
	/**
     * Inside "Everything Else" category, select MISCELLENEOUS
     */
	private static final String MISCELLENEOUS = "//android.widget.FrameLayout[@content-desc=\"1003\"]";
	
	/**
     * Listing title for naming the list
     */
	private static final String LISTING_TITLE = "//android.widget.EditText[@content-desc=\"title\"]";
	
	/**
     * Price text box
     */
	private static final String PRICE = "com.thecarousell.Carousell:id/text_input";
	
	/**
     * Submit list button
     */
	private static final String LIST_IT = "com.thecarousell.Carousell:id/button_submit";
	
	/**
     * If listing is successful, pop-up for the same
     */
	private static final String SUCCESSFULL_LIST_POPUP = "com.thecarousell.Carousell:id/custom";
	
	/**
     * Successful listing popup text
     */
	private static final String POPUP_TEXT = "android.widget.TextView";
	
	/**
     * Successful listing popup close button
     */
	private static final String POP_UP_CLOSE = "com.thecarousell.Carousell:id/button_close";
	
	/**
     * After Successful listing Skip button for sharing
     */
	private static final String SKIP_BUTTON = "com.thecarousell.Carousell:id/button_skip";
	
	/**
     * PageFactory element assignments  
     */
	@AndroidFindBy(id = SELL_BUTTON)
	private MobileElement sellBttn;
	
	@AndroidFindBy(id = IMAGE_LIST)
	private MobileElement imgList;
	
	@AndroidFindBy(id = FIRST_IMAGE)
	private MobileElement firstImge;
	
	@AndroidFindBy(id = NEXT_BTTN)
	private MobileElement nxtBttn;
	
	@AndroidFindBy(xpath = SELECT_CATEGORY_EVERYTHING_ELSE)
	private MobileElement categorySelect;
	
	@AndroidFindBy(xpath = CATEGORY_IMAGE_SELECTED)
	private MobileElement categoryImageSelected;
	
	@AndroidFindBy(xpath = MISCELLENEOUS)
	private MobileElement miscellenous;
	
	@AndroidFindBy(xpath = LISTING_TITLE)
	private MobileElement listingTitle;
	
	@AndroidFindBy(id = PRICE)
	private MobileElement price;
	
	@AndroidFindBy(id = LIST_IT)
	private MobileElement listItBttn;
	
	@AndroidFindBy(id = SUCCESSFULL_LIST_POPUP)
	private MobileElement popUp;
	
	@AndroidFindBy(id = POPUP_TEXT)
	private MobileElement popUpTxt;
	
	@AndroidFindBy(id = POP_UP_CLOSE)
	private MobileElement popUpClose;

	@AndroidFindBy(id = SKIP_BUTTON)
	private MobileElement skipBttn;
	
	
	/**
     * Method to add the item in the list 
     */
	@SuppressWarnings("deprecation")
	public void ListItem(){
		sellBttn.click();
		wait.until(ExpectedConditions.visibilityOf(imgList));
		firstImge.click();
		nxtBttn.click();
		wait.until(ExpectedConditions.elementToBeClickable(categoryImageSelected));
		util.scrollAndClickElement(CATEGORY_TEXT);
		miscellenous.click();
		wait.until(ExpectedConditions.elementToBeClickable(listingTitle));
		listingTitle.sendKeys(Utils.readProperty("listTitle"));
		price.clear();
		price.sendKeys(Utils.readProperty("price"));
		listItBttn.click();
		wait.until(ExpectedConditions.elementToBeClickable(skipBttn));
		skipBttn.click();
		try{
			popUpClose.click();
		}catch(NoSuchElementException e){
			System.out.println("No Success pop up appeared");
		}
	}
	
	
}
