package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CanclePage {
	public static WebDriver driver;
	@FindBy(id = "nav-orders")
	private WebElement canelpage;

	@FindBy(id = "Cancel-items_2")
	private WebElement productcancle;

	@FindBy(xpath = "//select[@name='cancel.reason']")
	private WebElement dropselect;
	
	public CanclePage(WebDriver driver2) {
		CanclePage.driver=driver2;
		PageFactory.initElements(driver2, this);

	}

	public WebElement getCanelpage() {
		return canelpage;
	}

	public WebElement getProductcancle() {
		return productcancle;
	}

	public WebElement getDropselect() {
		return dropselect;
	

}
}
