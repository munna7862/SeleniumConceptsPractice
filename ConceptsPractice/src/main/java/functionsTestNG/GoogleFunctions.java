package functionsTestNG;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pages.GooglePages;
import util.HelperMethods;

public class GoogleFunctions extends GooglePages {
	
	public void GSearch(WebDriver driver) throws Exception
	{
		String search = "Jaffar Sadhik";
		
		driver.findElement(google_textbox_search).sendKeys(search);
		Thread.sleep(1000);
	
		driver.findElement(google_search_button).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		String s = driver.getTitle();
		HelperMethods h = new HelperMethods();
		h.getScreenshot(driver,"GoogleScreenshot");
		System.out.println(s);
		Assert.assertEquals(search+" - Google Search", s);
	}
	
	public void GFeelingLucky(WebDriver driver) throws InterruptedException
	{
		String search = "Sadhik";
		
		driver.findElement(google_textbox_search).sendKeys(search);
		Thread.sleep(1000);
	
		driver.findElement(google_imfeelinglucky_button).sendKeys(Keys.ENTER);
		driver.findElement(google_imfeelinglucky_button).click();
		Thread.sleep(5000);
		
		String s = driver.getTitle();
		System.out.println(s);
	}
}
