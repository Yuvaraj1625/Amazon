package com.mavenproject.Amazon1;

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

import com.pom.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pom_Runner {
	
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
		
		Login_Page lg=new Login_Page(driver);
		
		lg.getLogin().click();
		lg.getMail().sendKeys("9344481690");
		lg.getContinue1().click();
		lg.getPass().sendKeys("yuvaraj123");
		lg.getSubmit().click();
		
		Thread.sleep(3000);
		String select = "Baby";
		WebElement selectall = driver.findElement(By.id("searchDropdownBox"));
		selectall.click();

		Select s = new Select(selectall);
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

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(searchproduct);
		Thread.sleep(2000);

		List<WebElement> relevant = driver.findElements(By.xpath(
				"//div[@class='autocomplete-results-container']/child::div/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']"));

		for (int i = 0; i < relevant.size(); i++) {
			WebElement eachProduct = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div/div/div[@class='s-suggestion s-suggestion-ellipsis-direction']"));

			String eachProductText = eachProduct.getText();

			if (eachProductText.equalsIgnoreCase(searchproduct)) {
				eachProduct.click();
				break;

			}
		}
		Thread.sleep(3000);

		WebElement firstProduct = driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-base']/child::div[2]/descendant::span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));

		String productName = firstProduct.getText();
		System.out.println(productName);

		WebElement firstProductOff = driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-base']/child::div[2]/descendant::span[@class='a-price'])[1]"));
		String fPOPrice = firstProductOff.getText();
		System.out.println(fPOPrice);

		firstProduct.click();

		Thread.sleep(3000);
		String parentTab = driver.getTitle();
		System.out.println(parentTab);

		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<>(window);
		driver.switchTo().window(list.get(1));

		String childTab = driver.getTitle();
		System.out.println(childTab);

//		WebElement firstProductTitle = driver.findElement(By.id("productTitle"));
		WebElement firstProductTitle = driver
				.findElement(By.xpath("//div[@id=\"ppd\"]/child::div[4]/descendant::span[@id='productTitle']"));
		String productText = firstProductTitle.getText();

		if (productText.equalsIgnoreCase(productName)) {
			System.out.println("Same Title: "+productText);

		} else {
			System.out.println("Title not Same: "+productText);
		}
		
		WebElement fpop = driver.findElement(By.xpath("(//div[@id='centerCol']/child::div[@id='apex_desktop']/child::div[@class='celwidget']/descendant::span[@aria-hidden='true'])[1]"));
		String firstPOP = fpop.getText();
		
		if (firstPOP.equalsIgnoreCase(fPOPrice)) {
			System.out.println("Same Price: "+firstPOP);
			
		} else {
			System.out.println("Price not Match: "+firstPOP);

		}
		
		Thread.sleep(3000);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		 js.executeScript("window.scroll(0,200)");
		
		 Thread.sleep(2000);
//		 System.out.println(driver.getTitle());
		driver.findElement(By.id("add-to-cart-button")).click();
//		driver.switchTo().window(list.get(0));
		
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[@id='nav-cart-count']")).click();
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
		
		
//		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Yuvaraj.E");
//		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("9578012196");
//		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("12");
//		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("AD Block 1street,Greens Technologies,Annanagar");
//		driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Akshayam Oppsite");
		driver.findElement(By.id("shipToThisAddressButton")).click();
		
		
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File sc = ts.getScreenshotAs(OutputType.FILE);
//		File f=new File("C:\\Users\\kaaviyan\\eclipse-workspace\\Selenium_MiniProject\\screenshot\\Amazon1.png");
//		FileUtils.copyFile(sc, f);
		
//		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		Thread.sleep(3000);
		WebElement cashondelivery = driver.findElement(By.xpath("(//span[text()='Cash On Delivery/Pay On Delivery'])[2]"));
		cashondelivery.click();
		WebElement usethispayment = driver.findElement(By.xpath("//input[@aria-labelledby=\'orderSummaryPrimaryActionBtn-announce\']"));
		js.executeScript("arguments[0].click();", usethispayment);

		Thread.sleep(3000);
		WebElement placeyourorder = driver.findElement(By.xpath("//input[@aria-labelledby=\'submitOrderButtonId-announce\']"));
		js.executeScript("arguments[0].click();", placeyourorder);
//		placeyourorder.click();
		
		driver.findElement(By.id("nav-orders")).click();
		driver.findElement(By.id("Cancel-items_2")).click();
		
		WebElement dropcancle = driver.findElement(By.xpath("//select[@name='cancel.reason']"));
		Select cancle=new Select(dropcancle);
		cancle.selectByVisibleText("Order Created by Mistake");
		
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File sc = ts.getScreenshotAs(OutputType.FILE);
//		File f=new File("C:\\Users\\kaaviyan\\eclipse-workspace\\Selenium_MiniProject\\screenshot\\Amazon1.png");
//		FileUtils.copyFile(sc, f);
		
//		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		
		driver.findElement(By.id("cancelButton-announce")).click();
		
		
	
		Thread.sleep(3000);
		
//		driver.quit();

	}




}
