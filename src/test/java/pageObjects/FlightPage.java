package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FlightPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]")
	WebElement totflights;
	
	@FindBy(xpath="//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]//following::p[@class='font10'][1]")
	WebElement minPrice;
	
	
	public FlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void displayTotalFlights()
	{
		String tf = totflights.getText();
		System.out.println("Number of Flights with 1 Stop for 30 days from today is "+tf.substring(tf.length()-4,tf.length()-1));
	}
	
	public void displayMinimumPrice()
	{
		String mp = driver.findElement(By.xpath("//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]//following::p[@class='font10'][1]")).getText();
		System.out.println("Minimum price for Flights with 1 Stop for 30 days from today is Rs"+mp.substring(mp.length()-5));
	}

}
