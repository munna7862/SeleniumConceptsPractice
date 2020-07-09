package pages;

import org.openqa.selenium.By;

public class GooglePages{
	public By google_textbox_search = By.xpath("//input[@name='q']");
	public By google_search_button = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']");
	public By google_imfeelinglucky_button = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnI']");
	public By google_gmail_button = By.xpath("//a[contains(text(),'Gmail')]");
	public By google_image_button = By.xpath("//a[contains(text(),'Images')]");
	
}
