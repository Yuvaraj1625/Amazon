package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SDP {
	public static WebDriver driver;

	private HomePage ahp;
	private Login_Page alp;
	private ProductPage app;
	private FirstProductPage afpp;
	private AddtocardPage aacp;
	private CanclePage acp;

	public SDP(WebDriver driver2) {
		SDP.driver=driver2;
		PageFactory.initElements(driver2, this);
		
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public HomePage getAhp() {
		if (ahp == null) {
			ahp = new HomePage(driver);
		}
		return ahp;
	}

	public Login_Page getAlp() {
		if (alp == null) {
			alp = new Login_Page(driver);
		}
		return alp;
	}

	public ProductPage getApp() {
		if (app == null) {
			app = new ProductPage(driver);
		}
		return app;
	}

	public FirstProductPage getAfpp() {
		if (afpp == null) {
			afpp = new FirstProductPage(driver);
		}
		return afpp;
	}

	public AddtocardPage getAacp() {
		if (aacp == null) {
			aacp = new AddtocardPage(driver);
		}
		return aacp;
	}

	public CanclePage getAcp() {
		if (acp == null) {
			acp = new CanclePage(driver);
		}
		return acp;
	}

}
