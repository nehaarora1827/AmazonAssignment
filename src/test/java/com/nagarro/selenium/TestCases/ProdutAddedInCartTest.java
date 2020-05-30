package com.nagarro.selenium.TestCases;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.selenium.Base.BaseClass;
import com.nagarro.selenium.Pages.AddToCartPage;
import com.nagarro.selenium.Pages.CartPage;
import com.nagarro.selenium.Pages.MenuPage;
import com.nagarro.selenium.Pages.ProductPage;
import com.nagarro.selenium.TestData.DataProviderClass;

public class ProdutAddedInCartTest extends BaseClass {

	MenuPage menu;
	ProductPage item;
	AddToCartPage addToCart;
	CartPage cart;
	public static Logger log = Logger.getLogger(ProdutAddedInCartTest.class.getName());

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "getData", groups = { "Regression", "Sanity" })
	public void verifyProductOnSearchResultsPage(Hashtable<String, String> data) throws Exception {

		menu = new MenuPage();
		item = new ProductPage();
		try {
			menu.clickingOnAllDropdown();
			menu.selectTheOptionFromAllDropdown(data.get("Category"));
			menu.enteringValueInSearchField(data.get("Search_Term"));
			menu.clickingOnSearchIcon();
			String expectedText = item.getFirstProductTitleFromResults();
			item.clickingOnFirstProductLink();
			item.verifyNewTab();
			String actualText = item.getTheProductTitleInNewTab();

			// verifying the same product is opened in new tab and getting the title
			Assert.assertTrue(actualText.contains(expectedText));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(dependsOnMethods = { "verifyProductOnSearchResultsPage" }, groups = { "Regression" })
	public void verifyAddToCartPage() throws Exception {
		addToCart = new AddToCartPage();
		try {
			addToCart.clickingOnAddToCartButton();

			// verifying the confirmation message is displaying in Cart page
			Assert.assertTrue(addToCart.isConfirmationMessageDisplayed(), "Confirmation message not displayed");
		} catch (Exception e) {
			throw e;
		}

	}

	@Test(dependsOnMethods = { "verifyAddToCartPage" }, groups = { "Regression" })
	public void clickingOnCartButtonFromHeader() throws Exception {
		cart = new CartPage();
		try {
			cart.cartButtonFromHeader();

			// Verifying the correct product is displaying in cart list
			Assert.assertTrue(cart.getProductTextFromCartPage().contains(ProductPage.selectedProductTitle),
					"is Product displayed on the Cart ?");
		} catch (Exception e) {
			throw e;
		}

	}

}
