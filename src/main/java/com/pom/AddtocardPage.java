package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocardPage {
	public static WebDriver driver;
	
	@FindBy(xpath = "//div[@id='nav-cart-count-container']/span[@id='nav-cart-count']")
	private WebElement addtocard;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proceedtoBuy;
	
	@FindBy(id = "shipToThisAddressButton")
	private WebElement usethisAdd;
	
	@FindBy(xpath = "(//span[text()='Cash On Delivery/Pay On Delivery'])[2]")
	private WebElement cashondelivery;
	
	@FindBy(xpath = "//input[@aria-labelledby=\\'orderSummaryPrimaryActionBtn-announce\\']")
	private WebElement usethispayment;
	
	@FindBy(id = "submitOrderButtonId")
	private WebElement placeyourorder;
	
	public AddtocardPage(WebDriver driver2) {
		AddtocardPage.driver=driver2;
		PageFactory.initElements(driver2, this);
		
	}

	public WebElement getAddtocard() {
		return addtocard;
	}

	public WebElement getProceedtoBuy() {
		return proceedtoBuy;
	}

	public WebElement getUsethisAdd() {
		return usethisAdd;
	}

	public WebElement getCashondelivery() {
		return cashondelivery;
	}

	public WebElement getUsethispayment() {
		return usethispayment;
	}

	public WebElement getPlaceyourorder() {
		return placeyourorder;
	}
	
	

}
