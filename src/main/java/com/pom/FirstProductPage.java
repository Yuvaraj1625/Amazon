package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstProductPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "(//div[@class='a-section a-spacing-base']/child::div[2]/descendant::span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	private WebElement firstproduct;
	
	

	@FindBy(xpath = "(//div[@class='a-section a-spacing-base']/child::div[2]/descendant::span[@class='a-price'])[1]")
	private WebElement firstProductOff;
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	

	public FirstProductPage(WebDriver driver1) {
		FirstProductPage.driver=driver1;
		PageFactory.initElements(driver1, this);
	}

	public WebElement getFirstproduct() {
		return firstproduct;
	}

	public WebElement getFirstProductOff() {
		return firstProductOff;
	}

}
