package com.demoshopqa.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.actionDrivers.Actionable;
import com.demoshopqa.baseTest.BaseClass;

public class IndexPage extends BaseClass {

	Actionable act = new Actionable();

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement myAccountbtn;

	@FindBy(xpath = "//a[contains(text(),'My Wishlist')]")
	WebElement wishlistbtn;

	@FindBy(css = ".noo-search")
	WebElement searchBar;

	@FindBy(xpath = "(//img[@class='custom-logo'])[1]")
	WebElement CustomLogo;

	@FindBy(css = ".woocommerce-store-notice__dismiss-link")
	WebElement dismissbtn;

	@FindBy(css = ".form-control")
	WebElement searchTypeBox;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickTosignIn() {
		act.waitUntilClickable(driver, dismissbtn);
		act.clickToElement(driver, myAccountbtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return act.isDisplayed(driver, CustomLogo);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public SearchResultPage searchProducts(String productName) {
		searchBar.click();
		searchTypeBox.sendKeys(productName);
		searchTypeBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();

	}


}
