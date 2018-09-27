package com.carousell.tests;

import org.junit.Test;


import com.carousell.helper.AppiumAndroidBase;
import com.carousell.helper.Utils;
import com.carousell.pages.AddItemForSellPageObject;
import com.carousell.pages.ListingVerificationPageObject;
import com.carousell.pages.LoginPageObject;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;


public class StartupTest extends AppiumAndroidBase {
LoginPageObject login = new LoginPageObject(driver);
AddItemForSellPageObject sellItem = new AddItemForSellPageObject(driver);
ListingVerificationPageObject listVerify = new ListingVerificationPageObject(driver);
	
	@Test
	public void flowTest() {
		login.loginTillCarousellMainPage(Utils.readProperty("username"), Utils.readProperty("password"));
		sellItem.ListItem();
		Assert.assertEquals(Utils.readProperty("listTitle"),listVerify.searchRecentlyAddedItems());
	}
	
	
}