package com.cucumberStepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumberRunner.RunnerClass;
import com.mavenproject.Amazon1.Base_Class;
import com.mavenproject.Amazon1.SDP_Runner;
import com.pom.HomePage;
import com.pom.SDP;
import com.properties.Configuration_Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base_Class {

	public WebDriver driver = RunnerClass.driver;

	public SDP sdp;
	public String searchproduct;

	
	
	@Given("userLaunch the Application Url")
	public void user_launch_the_application_url() throws IOException {
		String url = Configuration_Helper.getInstanceCR().geturl();
		launchUrl(url);
		implicitwait(10);
	}
	@When("user Selectes the {string} From")
	public void user_selectes_the_from(String dropDown) {
		String selectvalue = dropDown;

		sdp = new SDP(driver);
		sdp.getAhp().getSelectall().click();

		Select s = new Select(sdp.getAhp().getSelectall());

		List<WebElement> dropallOptions = s.getOptions();

		for (int i = 0; i < dropallOptions.size(); i++) {
			WebElement eachoption = dropallOptions.get(i);
			String eachtext = eachoption.getText();

			if (eachtext.equalsIgnoreCase(selectvalue)) {

				s.selectByVisibleText(eachtext);
				break;
			}

		}
	}
	@When("user Search The {string} In SearchBox")
	public void user_search_the_in_search_box(String product) throws Throwable {
		searchproduct = product;
		sdp=new SDP(driver);
		
		sendKeys(sdp.getAhp().getSearchbox(), searchproduct);
		sleep();
	}
	@Then("user Click The Searched Product From The Suggestion and It navigates To productPage")
	public void user_click_the_searched_product_from_the_suggestion_and_it_navigates_to_product_page() {
		for (int i = 0; i < sdp.getAhp().getRelevant().size(); i++) {

			String eachProductText = sdp.getAhp().getEachproduct().getText();

			if (eachProductText.equalsIgnoreCase(searchproduct)) {
				sdp.getAhp().getEachproduct().click();
				break;

			}
		}
	}
}
