package com.nagarro.selenium.Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.selenium.Base.BaseClass;

public class CartPage extends BaseClass {


	public CartPage() {
		PageFactory.initElements(driver, this);
		
	}

	public Logger log = Logger.getLogger(CartPage.class.getName());

	// Defining Cart page locators
	@FindBy(xpath = "//*[@id='nav-tools']/a[1]/following-sibling::a[4]")
	public WebElement cart;

	@FindBy(xpath = "//span[@class ='a-size-medium sc-product-title a-text-bold']")
	public List<WebElement> CartProductName;

	// Clicking on Cart button from menu
	public void cartButtonFromHeader() {
		cart.click();
		test.log(Status.INFO, "Clicked on Cart button from menu");
		log.info(" ***Clicked on Cart button from menu*** ");
	}

	//Verify the same product is displaying in shopping cart list and get the title of the product
	public List<String> getProductTextFromCartPage() {
		List<String> cartProductTitle = new ArrayList<String>();
		List<WebElement> products = CartProductName;
		test.log(Status.INFO, "Total product in Cart list: " + products.size());
		log.info(" ***Total product in Cart list: " + products.size() + "*** ");
		for (WebElement ele : products) {
			log.info(" ***Product title is: " + ele.getText() + "*** ");
			cartProductTitle.add(ele.getText());
		}
		return cartProductTitle;
	}

}
