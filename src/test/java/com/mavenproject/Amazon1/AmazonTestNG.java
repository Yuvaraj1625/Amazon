package com.mavenproject.Amazon1;

import org.testng.annotations.Test;

import com.pom.AddtocardPage;
import com.pom.CanclePage;
import com.pom.FirstProductPage;
import com.pom.HomePage;
import com.pom.Login_Page;
import com.pom.ProductPage;
import com.properties.Configuration_Helper;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestNG extends Base_Class {

	public static WebDriver driver;
	public static String productName;
	public static String fPOPrice;

	@BeforeTest
	private void browserLaunch() throws Exception {
		
		String browser = Configuration_Helper.getInstanceCR().getbrowser();
		
		driver = browserLaunch(browser);
		String url = Configuration_Helper.getInstanceCR().geturl();
		driver.get(url);

		implicitwait(10);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@BeforeClass
	private void loginPage() {
		Login_Page lg=new Login_Page(driver);
		click(lg.getLogin());
		sendKeys(lg.getMail(), "9344481690");
		click(lg.getContinue1());
		sendKeys(lg.getPass(), "yuvaraj123");
		click(lg.getSubmit());
	}

	@Test(priority = 0)
	private void dropSelect() {

		String select = "Baby";

		HomePage hm = new HomePage(driver);
		hm.getSelectall().click();

		Select s = new Select(hm.getSelectall());

		List<WebElement> dropallOptions = s.getOptions();

		for (int i = 0; i < dropallOptions.size(); i++) {
			WebElement alloption = dropallOptions.get(i);

			String alltext = alloption.getText();
			if (alltext.equalsIgnoreCase(select)) {

				s.selectByVisibleText(alltext);
				break;
			}

		}
	}

	@Test(priority = 1)
	private void searchBox() throws Throwable {

		String searchproduct = "soft toys";
		HomePage hm = new HomePage(driver);
		
		sendKeys(hm.getSearchbox(), searchproduct);
//		hm.getSearchbox().sendKeys(searchproduct);
		sleep();

		for (int i = 0; i < hm.getRelevant().size(); i++) {

			String eachProductText = hm.getEachproduct().getText();

			if (eachProductText.equalsIgnoreCase(searchproduct)) {
				hm.getEachproduct().click();
				break;

			}
		}
		sleep();
	}

	@Test(priority = 2)
	private static void firstProductSelect() throws Throwable {

		FirstProductPage fp = new FirstProductPage(driver);

		productName = fp.getFirstproduct().getText();
		System.out.println(productName);

		fPOPrice = fp.getFirstProductOff().getText();
		System.out.println(fPOPrice);

		fp.getFirstproduct().click();

		sleep();
	}

	@Test(priority = 3)
	private void switchToWindow_FirstProduct() {

		String parentTab = getTitle();
		System.out.println(parentTab);

		getMultipleWindow(1);
		
		String childTab = getTitle();
		System.out.println(childTab);

	}

	@Test(priority = 4)
	private void compareFirst_Product_Price() {

		ProductPage p = new ProductPage(driver);

		String productText = p.getFirstProductTitle().getText();

		if (productText.equalsIgnoreCase(productName)) {
			System.out.println("Same Title: " + productText);

		} else {
			System.out.println("Title not Same: " + productText);
		}
	}

	@Test(priority = 5)
	private void compareFirst_Product_Title() throws Throwable {

		ProductPage p = new ProductPage(driver);

		String firstPOP = p.getFpop().getText();

		if (firstPOP.equalsIgnoreCase(fPOPrice)) {
			System.out.println("Same Price: " + firstPOP);

		} else {
			System.out.println("Price not Match: " + firstPOP);

		}

		sleep();

		p.getorderClick().click();


	}

	@Test(priority = 6)
	private void addToCard() throws Throwable {


		AddtocardPage ad = new AddtocardPage(driver);

		javascript_click(ad.getAddtocard());
		javascript_click(ad.getProceedtoBuy());
//		javascript_click(ad.getUsethisAdd());
//		javascript_click(ad.getCashondelivery());
//		javascript_click(ad.getUsethispayment());
//		javascript_click(ad.getPlaceyourorder());
		
		sleep();
		takeScreenshot();


	}

//	@Test(priority = 7)
	private void cancelOrder() throws Exception {
		CanclePage cp=new CanclePage(driver);

		click(cp.getCanelpage());
		click(cp.getProductcancle());
		
		dropSelect(cp.getDropselect(), "text", "Order Created by Mistake");

	}

//	@AfterClass
	private void logout() {

		WebElement loginpage = driver.findElement(By.id("nav-link-accountList"));
		loginpage.click();

		WebElement loginandsecurity = driver
				.findElement(By.xpath("//div[@data-card-identifier=\'SignInAndSecurity\']"));
		loginandsecurity.click();

		WebElement switchaccount = driver.findElement(By.id("ap_switch_account_link"));
		switchaccount.click();

		WebElement signout = driver.findElement(By.id("sign_out_request"));
		signout.click();

	}
	@AfterTest
	private void browserquit() {

		quit();
	}

}
