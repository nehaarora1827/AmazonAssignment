package com.nagarro.selenium.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.nagarro.selenium.Base.BaseClass;

public class MenuPage extends BaseClass {


	public MenuPage() {
		PageFactory.initElements(driver, this);
	}

	public Logger log = Logger.getLogger(MenuPage.class.getName());

	// Defining menu page locators
	@FindBy(xpath = "//*[@id='nav-search']/form/div[1]/div/div")
	public WebElement dropdown;

	@FindBy(id = "searchDropdownBox")
	public WebElement categories;

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	public WebElement searchBar;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement icon;
	
	@FindBy(xpath="//*[@id='nav-xshop']/a[1]")
	public WebElement Mobiles;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	public WebElement AccountAndLists;
	
	@FindBy(xpath="//a[@href='/gp/css/homepage.html?ref_=nav_AccountFlyout_ya']")
	public WebElement YourAccount;

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
	
	//Clicking on amazon navigation bar
	public void clickingOnMobilesLink()
	{
		waitForElement(Mobiles);
		Mobiles.click();
		test.log(Status.INFO, "Clicked on Mobiles link");
		log.info(" ***Clicked on Mobiles link*** ");
	}
	
	// method to navigate to "Your Account" option from header
    public void goToYourAccount() {

 

        Actions actions = new Actions(driver);
        actions.moveToElement(AccountAndLists).perform();
        waitForElement(YourAccount);
        YourAccount.click();
        test.log(Status.INFO, " Clicked on Your Account link ");
        log.info(" *** Clicked on Your Account link *** ");
    }
}
