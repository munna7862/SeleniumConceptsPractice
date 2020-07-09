package util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class SeleniumTestHelper {

	static WebDriver driver;

	public static void clickOnButton(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}

	}

	public static void enterTextInTextBox(WebElement element, String text) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public static void enterText(WebElement element, String text) {
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public static void clear(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.clear();
			}
		} catch (NoSuchElementException exe) {
			Assert.fail(exe.getMessage() + " exception occured.");
		}
	}

	public enum DropDownMode {
		VISIBLE_TEXT, INDEX, VALUE
	}

	public static void selectFromDropDown(WebElement element, String value,
			DropDownMode mode) throws Exception {
		try {
			Select select = new Select(element);

			switch (mode) {
			case VISIBLE_TEXT:
				select.selectByVisibleText(value);
				break;
			case INDEX:
				select.selectByIndex(Integer.parseInt(value));
				break;
			case VALUE:
				select.selectByValue(value);

			}
			retryCount = 0;

		} catch (Exception exe) {

			if (retryCount > 3) {
				throw exe;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			retryCount++;
			selectFromDropDown(element, value, mode);

		}
	}

	private static int retryCount = 0;

	public static void selectFromDropDown(WebElement element, String value,
			String mode) throws Exception {
		try {
			Select select = new Select(element);
			if (mode.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if (mode.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (mode.equalsIgnoreCase("visibletext")) {
				select.selectByVisibleText(value);
			} else {
				Assert.fail("Not a valid mode to select from a drop down.");
			}

			if (mode.equals(""))
				Reporter.log(element.getAttribute("value")
						+ " is entered successfully", true);
			retryCount = 0;

		} catch (Exception exe) {

			if (retryCount > 3) {
				throw exe;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			retryCount++;
			selectFromDropDown(element, value, mode);

		}
	}

	public static boolean isElementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			if (element.isDisplayed()) {
				displayed = true;
			}
		} catch (NoSuchElementException exe) {
			displayed = false;
		}
		return displayed;
	}

	public static void verifyElementDisplayed(WebElement element,String message) {
		assertTrue(element.isDisplayed(),message);
	}


	public static WebElement WaitForElement(WebElement element, int seconds) {

		long start = System.currentTimeMillis();

		while (true) {

			try {
				element.isDisplayed();
				return element;
			} catch (WebDriverException e) {

				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}

				continue;

			} finally {

				long end = System.currentTimeMillis();
				if ((end - start) / 1000 > seconds) {
					throw new NoSuchElementException(
							"Timeout exceeded and element couldn't be found");
				}
			}
		}
	}


	public static void waitForElementToBeDisplayed(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBePresent(WebDriver driver, By element,int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * this function returns true if the element is enabled else false
	 * 
	 * @param element
	 * @return boolean
	 */
	public static boolean isElementEnabled(WebElement element) {
		boolean enabled = false;
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled())
					enabled = true;
			}
		} catch (NoSuchElementException exe) {

			Assert.fail(exe.getMessage() + " exception occured.");
		}
		return enabled;
	}

	public static void switchingToParentWindow(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);

		driver.switchTo().window(pWindows);

	}


	public static WebDriver switchToOtherWindow(WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		return driver;
	}

	public static WebDriver switchToOtherWindowAndCloseCurrentWindow(
			WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.close();
				driver.switchTo().window(handle);
			}
		}
		return driver;
	}

	public static WebDriver switchToOtherWindowAndCloseItAndComeBack(
			WebDriver driver) {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentHandle);
		return driver;
	}

	public static void switchingTochildtWindow(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);

	}

	public static void assertEquals(Object actual, Object expected){
		Assert.assertEquals(actual, expected, null);
	}



	public static void assertNotEquals(Object actual, Object expected){
		Assert.assertNotEquals(actual, expected, null);
	}

	public static void assertTrue(boolean bool, String message){
		Assert.assertEquals(bool, true, message);
	}	

	public static void assertTrue(boolean bool){
		assertTrue(bool, null);
	}

	public static void assertFalse(boolean bool, String message){
		Assert.assertEquals(bool, false, message);
	}	

	public static void assertFalse(boolean bool){
		assertFalse(bool, null);
	}

	public static void fail(String message){
		Assert.assertEquals(true, false, message);
	}

	public static void assertNotNull(Object obj){
		assertNotNull(obj, null);
	}

	public static void assertNotNull(Object obj, String message){
		boolean truthness = true;
		if(null == obj){
			truthness = false;
		}
		Assert.assertEquals(truthness, true, message);
	}

	public static void fail(){
		fail(null);
	}


	public static int generateRandomInt(int min, int max){
		Random foo = new Random();
		return foo.nextInt((max + 1) - min) + min;
	}		public static void waitForTextToBePresentInElement(WebDriver driver,
			WebElement element, int timeOutInSeconds,String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}


	public static void switchingTochildtWindowAndCloseIt(WebDriver driver) {

		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itrs = childWindow.iterator();
		String pWindows = itrs.next();
		String cWindows = itrs.next();
		driver.switchTo().window(cWindows);
		driver.switchTo().window(cWindows).close();

	}

	public static String addDaysToCurrentDate(int days){

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		c.add(Calendar.DATE, days);

		// convert calendar to date
		String currentDatePlusOne = dateFormat.format(c.getTime());
		return currentDatePlusOne;

	}

	public static String generateRandomNumericalString() {
		String saltChars = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { 
			int index = (int) (rnd.nextFloat() * saltChars.length());
			salt.append(saltChars.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String generateRandomNumericalStringWithSpecialCharacters() {
		String SALTCHARS = "1234567890/-";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { 
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}


	public static String generateRandomNumericalStringWithLetters(int stringLength) {
		String SALTCHARS = "1234567890abcdefg";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < stringLength) { 
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String generateRandomNumericalString(int stringLength) {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < stringLength) { 
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	// this method is used when we are getting stale element exception
	public static void waitForElementToBerefreshed(WebDriver driver,WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
	}

	public static String generateRandomNumberString(int stringLength) {
		String SALTCHARS = "123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < stringLength) { 
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}


}