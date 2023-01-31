package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver2) {
		HomePage.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	
	@FindBy(id="searchDropdownBox")
	private WebElement selectall;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(xpath = "//div[@class='autocomplete-results-container']/child::div/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']")
	private List<WebElement> relevant;
	
	@FindBy(xpath = "//div[@class='autocomplete-results-container']/child::div/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']")
	private WebElement eachproduct;
	
	
	

	public static WebDriver getDriver() {
		return driver;
	}

	public  WebElement getSelectall() {
		return selectall;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public List<WebElement> getRelevant() {
		return relevant;
	}

	public WebElement getEachproduct() {
		return eachproduct;
	}
	
	
	

}
