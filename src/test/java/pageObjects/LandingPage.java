package pageObjects;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	public WebDriver driver;
	String modifiedDate;
	
	@FindBy(xpath="//label[@for='departure']//preceding::span[@class='lbl_input latoBold appendBottom10']")
	WebElement Flights;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement SrchBtn;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlight()
	{
		Flights.click();
	}
	
	public void clickSrch()
	{
		SrchBtn.click();
	}
	
	public void getLaterDate()
	{
		LocalDate today = LocalDate.now();
        String dat = (today.plusDays(30).toString());
		String newD  = dat.substring(dat.length()-2);
	    modifiedDate = "Nov "+newD+" 2020";
	}
	
	public void selectDate()
	{
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+modifiedDate+"')]")).click();
	}

}
