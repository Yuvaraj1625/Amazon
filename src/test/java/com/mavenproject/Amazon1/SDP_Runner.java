package com.mavenproject.Amazon1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.pom.SDP;
import com.pom.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SDP_Runner {

	public static WebDriver driver;

	private static List<String> listOfchromeOption() {

		List<String> listOfOptions = new ArrayList<>();
		listOfOptions.add("start-maximized");
		listOfOptions.add("disable-popup-blocking");

		return listOfOptions;
	}

	public static void main(String[] args) throws Throwable {

		ChromeOptions options = new ChromeOptions();
		options.addArguments(listOfchromeOption());

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		SDP as = new SDP(driver);

//		as.getAlp().getLogin().click();
//		as.getAlp().getMail().sendKeys("9344481690");
//		as.getAlp().getContinue1().click();
//		as.getAlp().getPass().sendKeys("yuvaraj123");
//		as.getAlp().getSubmit().click();

		Thread.sleep(3000);
		String select = "Baby";
		as.getAhp().getSelectall().click();

		Select s = new Select(as.getAhp().getSelectall());
		List<WebElement> dropallOptions = s.getOptions();
		for (int i = 0; i < dropallOptions.size(); i++) {
			WebElement alloption = dropallOptions.get(i);

			String alltext = alloption.getText();
			if (alltext.equalsIgnoreCase(select)) {

				s.selectByVisibleText(select);
				break;
			}

		}

		String searchproduct = "soft toys";

		as.getAhp().getSearchbox().sendKeys(searchproduct);
		Thread.sleep(2000);

		as.getAhp().getRelevant();

		for (int i = 0; i < as.getAhp().getRelevant().size(); i++) {

			String eachProductText = as.getAhp().getEachproduct().getText();

			if (eachProductText.equalsIgnoreCase(searchproduct)) {
				as.getAhp().getEachproduct().click();
				break;

			}
		}
		Thread.sleep(3000);

		String productName = as.getAfpp().getFirstproduct().getText();
		System.out.println(productName);

		String fPOPrice = as.getAfpp().getFirstProductOff().getText();
		System.out.println(fPOPrice);

		as.getAfpp().getFirstproduct().click();

		Thread.sleep(3000);
		String parentTab = driver.getTitle();
		System.out.println(parentTab);

		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<>(window);
		driver.switchTo().window(list.get(1));

		String childTab = driver.getTitle();
		System.out.println(childTab);

		String productText = as.getApp().getFirstProductTitle().getText();

		if (productText.equalsIgnoreCase(productName)) {
			System.out.println("Same Title: " + productText);

		} else {
			System.out.println("Title not Same: " + productText);
		}

		String firstPOP = as.getApp().getFpop().getText();

		if (firstPOP.equalsIgnoreCase(fPOPrice)) {
			System.out.println("Same Price: " + firstPOP);

		} else {
			System.out.println("Price not Match: " + firstPOP);

		}

		as.getApp().getorderClick().click();

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,200)");

		Thread.sleep(2000);
		as.getAacp().getAddtocard().click();
		as.getAacp().getProceedtoBuy().click();
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File f=new File(".\\Selenium_MiniProject\\screenshot\\Amazon1.png");
		FileUtils.copyFile(sc, f);


		Thread.sleep(3000);

		driver.close();

	}
}
