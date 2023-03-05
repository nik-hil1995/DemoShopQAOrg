package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshopqa.actionDrivers.Actionable;
import com.demoshopqa.baseTest.BaseClass;

public class CheckoutPage extends BaseClass {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	LoginPage loginpage;

	Actionable act = new Actionable();

	@FindBy(css = ".showlogin")
	WebElement loginbtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement termsandcondn;
	
	@FindBy(css = "#place_order")
	WebElement PlaceOrderBtn;


	public OrderConfirmationPage checkoutAProduct() throws InterruptedException {
	loginbtn.click();
	loginpage=new LoginPage();
	loginpage.loginToApp(prop.getProperty("UserEmail"), prop.getProperty("Password"));
	Thread.sleep(6000);
    termsandcondn.click();
	PlaceOrderBtn.click();
	
	return new OrderConfirmationPage();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

}
	

	
	
