package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	public static WebDriver driver; 

	@FindBy(id = "nav-link-accountList")
	private WebElement login;

	@FindBy(id = "ap_email")
	private WebElement mail;

	@FindBy(id = "continue")
	private WebElement continue1;

	@FindBy(id = "ap_password")
	private WebElement pass;

	@FindBy(id = "signInSubmit")
	private WebElement submit;
	
	

	public Login_Page(WebDriver driver2) {
		Login_Page.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getMail() {
		return mail;
	}

	public WebElement getContinue1() {
		return continue1;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getSubmit() {
		return submit;
	}
}
