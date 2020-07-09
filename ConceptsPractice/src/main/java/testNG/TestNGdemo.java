package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionsTestNG.GoogleFunctions;
import util.BrowserUtils;

public class TestNGdemo extends GoogleFunctions {
	WebDriver driver = null;

	@BeforeTest
	public void SetUPTest()
	{
		System.out.println("Before Starting the Test initiating the browser");
	}
	
	@Test
	public void TestExcecution() throws Exception
	{
		driver = BrowserUtils.init();
		System.out.println("Google Search Output");
		GSearch(driver);
		driver.close();
	}
	
	@Test
	public void TestExcecution2() throws InterruptedException
	{
		driver = BrowserUtils.init();
		System.out.println("Google Feeling Lucky Output");
		GFeelingLucky(driver);
		driver.close();
	}
	
	@AfterTest
	public void TearUPTest()
	{
		System.out.println("After completing the Test");
	}

}
