package com.nagarro.selenium.Pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.selenium.Base.BaseClass;

public class ProductPage extends BaseClass {


	public ProductPage() {
		//super(driver);
		PageFactory.initElements(driver, this);
	}

	public static Logger log = Logger.getLogger(ProductPage.class.getName());

	public static String selectedProductTitle;

	// Defining Product_Category locators
	@FindBy(xpath = "//*[@class='a-size-medium a-color-base a-text-normal']")
	public WebElement productTitle;

	@FindBy(xpath = "//*[@id='productTitle']")
	public WebElement productHeader;

	// Clicking on first product link
	public void clickingOnFirstProductLink() {
		waitForElement(productTitle);
		productTitle.click();
		test.log(Status.INFO, "Clicked on first product link");
		log.info(" ***Clicked on first product link*** ");

	}

	// Getting the first product title
	public String getFirstProductTitleFromResults() {
		selectedProductTitle = productTitle.getText();
		test.log(Status.INFO, "Get the title of the first product");
		log.info(" ***Get the title of the first product*** ");
		return selectedProductTitle;
	}

	// Switch the driver in new tab
	public void verifyNewTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		log.info(" ***Switched the driver in new tab*** ");
	}

	// Getting the product title opened in new tab
	public String getTheProductTitleInNewTab() {
		String producttext = productHeader.getText();
		System.out.println(producttext);
		test.log(Status.INFO, "Get the title of product opened in new tab");
		log.info(" ***Get the title of product opened in new tab*** ");
		return producttext;
	}

}
