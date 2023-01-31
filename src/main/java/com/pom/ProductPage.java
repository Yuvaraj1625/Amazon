package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "//div[@id=\"ppd\"]/child::div[4]/descendant::span[@id='productTitle']")
	private WebElement firstProductTitle;
	
	

	@FindBy(xpath = "(//div[@id='centerCol']/child::div[@id='apex_desktop']/child::div[@class='celwidget']/descendant::span[@aria-hidden='true'])[1]")
	private WebElement fpop;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement orderclick;
	
	public static WebDriver getDriver() {
		return driver;
	}


	public WebElement getorderClick() {
		return orderclick;
	}


	public ProductPage(WebDriver driver1) {
		ProductPage.driver=driver1;
		PageFactory.initElements(driver1, this);

	}
	

	public WebElement getFirstProductTitle() {
		return firstProductTitle;
	}

	public WebElement getFpop() {
		return fpop;
	}



}
