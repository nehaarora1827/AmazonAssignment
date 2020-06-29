package com.nagarro.selenium.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.selenium.Base.BaseClass;
import com.nagarro.selenium.Pages.MenuPage;

public class YourAccountPageTitleTest extends BaseClass {

	@Test(groups = {"Regression", "Sanity"})
	public void verifyYourAccountsPageTitle() throws Exception{
		try{
		MenuPage header = new MenuPage();
		header.goToYourAccount();
		String PageTitle = driver.getTitle();
		//Applying assertion to fail this test case
		Assert.assertTrue(
				PageTitle.contains(
						"Account"),
				"Title is different");
		
	}
		catch(Exception e){
			throw e;
			}
		}

}
