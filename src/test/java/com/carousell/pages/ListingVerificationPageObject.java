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

/**
 * A page for a verifying Listed item
 */
public class ListingVerificationPageObject extends AppiumAndroidBase{
	
	/**
     *  Constructor to assign driver of type AppiumDriver
     */
	public ListingVerificationPageObject(AppiumDriver driver) {
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
     * Carousell bar locator
     */
	private static final String CAROUSELL_BAR = "com.thecarousell.Carousell:id/tabs";
	
	/**
     * Linear Layout class
     */
	private static final String LINEAR_LAYOUT = "android.widget.LinearLayout";
	
	/**
     * Action bar locator
     */
	private static final String APP_ACTION_BAR = "android.support.v7.app.ActionBar$b";
	
	/**
     * See All link locator
     */
	private static final String SEE_ALL = "com.thecarousell.Carousell:id/home_page_see_all_button";
	
	/**
     * Carousell recycler view for awaiting it to appear after an action
     */
	private static final String CAROUSELL_RECYCLER_VIEW = "com.thecarousell.Carousell:id/recyclerView";
	
	/**
     * Everythinh Else category text locator
     */
	private static final String CATEGORY_TEXT = "Everything Else";
	
	/**
     * Filter button locator
     */
	private static final String FILTER_BTTN = "com.thecarousell.Carousell:id/bar_filter";
	
	/**
     * RECENT filter locator
     */
	private static final String RECENT_FILTER = "//android.widget.RadioButton[@content-desc=\"time_created,descending\"]";
	
	/**
     * Save filter button locator
     */
	private static final String SAVE_FILTER = "com.thecarousell.Carousell:id/btn_filter";
	
	/**
     * Product listing grid locator
     */
	private static final String PRODUCT_GRID = "com.thecarousell.Carousell:id/grid_product";
	
	/**
     * First product View from the product grid
     */
	private static final String FIRST_PRODUCT = "com.thecarousell.Carousell:id/card_product";
	
	/**
     * First product name from the product grid
     */
	private static final String PRODUCT_NAME = "com.thecarousell.Carousell:id/text_attribute_1";
	
	/**
     * Feature button for accepting the helper pop up for location
     */
	private static final String OK_BUTTON = "com.thecarousell.Carousell:id/feature_button";
	
	
	/**
     * PageFactory element assignments  
     */
	@AndroidFindBy(id = CAROUSELL_BAR)
	private MobileElement carousellBar;
	
	@AndroidFindBy(id = SEE_ALL)
	private MobileElement seeAll;
	
	@AndroidFindBy(className = CAROUSELL_RECYCLER_VIEW)
	private MobileElement recyclerView;
	
	@AndroidFindBy(id = FILTER_BTTN)
	private MobileElement filterBttn;
	
	@AndroidFindBy(xpath = RECENT_FILTER)
	private MobileElement filterSet;
	
	@AndroidFindBy(id = SAVE_FILTER)
	private MobileElement saveFilter;
	
	@AndroidFindBy(id = PRODUCT_GRID)
	private MobileElement productGrid;
	
	@AndroidFindBy(id = FIRST_PRODUCT)
	private MobileElement firstProduct;
	
	@AndroidFindBy(id = OK_BUTTON)
	private MobileElement acceptLocationAlert;
	
	/**
     * Method to search  the item added in the list and return the name for further verification
     * @return String value of listed item name
     */
	public String searchRecentlyAddedItems(){
		carousellBar.findElement(By.className(LINEAR_LAYOUT)).findElementsByClassName(APP_ACTION_BAR).get(0).click();
		try{
			seeAll.click();
			util.scrollAndClickElement(CATEGORY_TEXT);
			acceptLocationAlert.click();
			wait.until(ExpectedConditions.elementToBeClickable(filterBttn));
			filterBttn.click();
			filterSet.click();
			saveFilter.click();
			wait.until(ExpectedConditions.elementToBeClickable(filterBttn));
			return productGrid.findElement(By.id(FIRST_PRODUCT)).findElement(By.id(PRODUCT_NAME)).getText();
		}catch(NoSuchElementException e){
			return null;
		}
	}
	
	
}
