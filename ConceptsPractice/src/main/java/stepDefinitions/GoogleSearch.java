package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePages;
import util.BrowserUtils;

public class GoogleSearch extends GooglePages{

	public GoogleSearch() throws IOException {
	}
	
	public WebDriver driver;
	
	@Before
	public void setup()
	{
		System.out.println("Starting the Browser");
	}
	
	@After
	public void teardown()
	{
		System.out.println("Closing the Browser");
	}

	@Given("^User is on google page$")
	public void user_is_on_google_page() {
		driver = BrowserUtils.init();
	}
	
	@When("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) {
	    driver.findElement(google_textbox_search).sendKeys(arg1);
	}

	@When("^User clicks the search button$")
	public void user_clicks_the_search_button() throws InterruptedException {
		driver.findElement(google_search_button).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@Then("^User able to search the \"([^\"]*)\"$")
	public void user_able_to_search_the(String arg1) {
	   String s = driver.getTitle();
	   System.out.println(s);
	   Assert.assertEquals(arg1+" - Google Search", s);
	   driver.close();
	}
	
	@When("^User enters text$")
	public void user_enters_text(DataTable text) {
		List<List<String>> data = text.raw();
		driver.findElement(google_textbox_search).sendKeys(data.get(0).get(0));
	}

	@Then("^User able to search the text$")
	public void user_able_to_search_the_text(DataTable text) {
		List<List<String>> data = text.raw();
		String s = driver.getTitle();
		   System.out.println(s);
		   Assert.assertEquals(data.get(0).get(0)+" - Google Search", s);
		   driver.close();
	}

	
	@When("^User clicks the I'm Feeling Lucky button$")
	public void user_clicks_the_I_m_Feeling_Lucky_button() throws InterruptedException {
		driver.findElement(google_imfeelinglucky_button).sendKeys(Keys.ENTER);
		driver.findElement(google_imfeelinglucky_button).click();
		Thread.sleep(5000);
		driver.close();
	}
}
