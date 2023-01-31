package com.mavenproject.Amazon1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;

	public static void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void implicitwait(int a) {

		try {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sleep() throws Throwable {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String getText(WebElement element) {
		try {
			String get_Text = element.getText();
			return get_Text;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void passAtributePlaceholder(WebElement element) {
		try {
			String attribute = element.getAttribute("placeholder");
			System.out.println(attribute);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void passAttribute(WebElement element, String value) {
		try {
			String attribute = element.getAttribute(value);
			System.out.println(attribute);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static  void javascript_click(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean isSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			System.out.println(selected);
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
//		return false;

	}

	public static boolean isdisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
//			throw new RuntimeException();
		}
		return false;

	}

	public static WebDriver browserLaunch(String browser) throws Exception {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("gecko")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else {
				throw new Exception("invalid browser");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static void maximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fullscreen() {
		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateto(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String grtCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getwindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> getMultipleWindow(int a) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(a));
		return windowHandles;
	}

	public static void keyDown() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void keyEnter() throws AWTException {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void acceptAlert(String value) {
		try {
			driver.switchTo().alert().sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void alert(String option) throws Exception {
		Alert alert = driver.switchTo().alert();

		try {
			if (option.equalsIgnoreCase("ok")) {
				alert.accept();

			} else if (option.equalsIgnoreCase("cancle")) {
				alert.dismiss();

			} else {
				throw new Exception("No Alert");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void frameswitchTo(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void defaultContant() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void parentframe() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;

	}

	public static void mouseBasedActions(String option, WebDriver driver, WebElement element) {

		try {
			Actions action = new Actions(driver);
			if (option.equalsIgnoreCase("move")) {
				action.moveToElement(element).build().perform();
			} else if (option.equalsIgnoreCase("click")) {
				action.click(element).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dropSelect(WebElement element, String option, String value) throws Exception {

		Select s = new Select(element);

		try {
			if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				int p = Integer.parseInt(value);
				s.selectByIndex(p);

			} else {
				throw new Exception("invalid select");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	public static void takeScreenshot() throws IOException {

		try {
			
//			LocalDateTime dt = LocalDateTime.now();
//			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MMM-yyy HH:mm:ss");
//			String r = dt.format(dateformat);
//			System.out.println(r);
			
			
			Date date=new Date(0);
			SimpleDateFormat sm=new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
			String format = sm.format(date);
			String r = format.replace("/", "-");

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(
					"C:\\Users\\kaaviyan\\eclipse-workspace\\Amazon_Project\\screenshot\\amazon-"+r+".png");
			FileUtils.copyFile(source, des);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}
	

}
