package com.nagarro.selenium.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.nagarro.selenium.Base.BaseClass;

public class MenuPage extends BaseClass {


	public MenuPage() {
		PageFactory.initElements(driver, this);
	}

	public static Logger log = Logger.getLogger(MenuPage.class.getName());

	// Defining menu page locators
	@FindBy(xpath = "//*[@id='nav-search']/form/div[1]/div/div")
	public WebElement dropdown;

	@FindBy(id = "searchDropdownBox")
	public WebElement categories;

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	public WebElement searchBar;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement icon;

	// Clicking on All dropdown
	public void clickingOnAllDropdown() {
		dropdown.click();
		test.log(Status.INFO, "Clicked All dropdown");
		log.info(" ***Clicked All dropdown*** ");
	}

	// Selecting a product category
	public void selectTheOptionFromAllDropdown(String option) {
		Select dropDown = new Select(categories);
		dropDown.selectByVisibleText(option);
		test.log(Status.INFO, "Selected a product category");
		log.info(" ***Selected a product category*** ");
	}

	// Enter the value by selecting the product category
	public void enteringValueInSearchField(String value) {
		searchBar.sendKeys(value);
		test.log(Status.INFO, "Entered a category option in search field");
		log.info(" ***Entered a category option in search textbox*** ");
	}

	// Clicking on Search icon
	public void clickingOnSearchIcon() {
		icon.click();
		test.log(Status.INFO, "Clicked on Search icon");
		log.info(" ***Clicked on Search icon*** ");
	}
}
