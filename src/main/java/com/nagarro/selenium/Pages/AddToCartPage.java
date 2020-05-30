package com.nagarro.selenium.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.selenium.Base.BaseClass;

public class AddToCartPage extends BaseClass {


	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public static Logger log = Logger.getLogger(AddToCartPage.class.getName());

	// Defining Add to Cart locators
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement addToCartButtonFirst;

	@FindBy(xpath = "//a[@id='buybox-see-all-buying-choices-announce']")
	public WebElement seeAllBuyingButton;

	@FindBy(xpath = "//input[@name='submit.addToCart']")
	public WebElement addToCartButtonSecond;

	@FindBy(xpath = "//div[@id='huc-v2-order-row-messages']")
	public WebElement confirmationMessage;

	// Clicking on Add to Cart button
	public void clickingOnAddToCartButton() {

		if (addToCartButtonFirst.isDisplayed()) {
			waitForElement(addToCartButtonFirst);
			addToCartButtonFirst.click();
		}
		// Clicking on See All Buying button in case of Cart button is not displayed
		// and then click on Add to Cart button
		else if (seeAllBuyingButton.isDisplayed()) {
			waitForElement(seeAllBuyingButton);
			seeAllBuyingButton.click();
			waitForElement(addToCartButtonSecond);
			addToCartButtonSecond.click();
		} else {

			log.info(" ***Button is not displayed*** ");
		}
		test.log(Status.INFO, "Clicked on Add to Cart button");
		log.info(" ***Clicked on Add to Cart button*** ");
	}

	// verifying confirmation message after product is added to cart
	public boolean isConfirmationMessageDisplayed() {
		waitForElement(confirmationMessage);
		Boolean IsConfirmationDisplayed = confirmationMessage.isDisplayed();
		test.log(Status.INFO, "Checked the confirmation message is displayed in Cart page");
		log.info(" ***Checked the confirmation message is displayed in Cart page*** ");
		return IsConfirmationDisplayed;

	}

}
