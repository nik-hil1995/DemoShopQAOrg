package com.demoshopqa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshopqa.actionDrivers.Actionable;
import com.demoshopqa.baseTest.BaseClass;

public class ProductPage extends BaseClass {

	Actionable act = new Actionable();

	@FindBy(css = "#pa_color")
	WebElement coloroption;

	@FindBy(css = "#pa_size")
	WebElement sizeoption;

	@FindBy(css = ".qty-increase")
	WebElement QtyIncrease;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement addToCartBtn;

	@FindBy(css = ".button.wc-forward.wp-element-button")
	WebElement cartBtn;

	@FindBy(css = ".woocommerce-message")
	WebElement alertMsg;

	@FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
	WebElement checkoutbtn;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public CartPage addProductToCart(String color, String size) throws InterruptedException {
		Thread.sleep(5000);
		Select select1 = new Select(coloroption);
		select1.selectByValue(color);
		Select select2 = new Select(sizeoption);
		select2.selectByValue(size);
		QtyIncrease.click();
		addToCartBtn.click();
		alertMsg.isDisplayed();
		act.clickToElement(driver, cartBtn);
		act.clickToElement(driver, checkoutbtn);
		return new CartPage();
	}

}
