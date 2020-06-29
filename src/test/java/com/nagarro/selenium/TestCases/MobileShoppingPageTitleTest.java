package com.nagarro.selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.selenium.Base.BaseClass;
import com.nagarro.selenium.Pages.MenuPage;

public class MobileShoppingPageTitleTest extends BaseClass {
	MenuPage menu;
	
	@Test(groups = { "Regression", "Sanity" })
	public void verifyMobileShoppingPageTitle() throws InterruptedException
	{
		menu=new MenuPage();
		menu.clickingOnMobilesLink();
		Thread.sleep(10000);
		
		//Failing this test case
		Assert.assertTrue(driver.getTitle().contains("Mobiles"));
	}

}
