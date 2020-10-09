package testCase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {

public WebDriver driver = null;

@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(250,TimeUnit.SECONDS);
	driver.manage().window().maximize();
}

@Test
public void allcases() throws InterruptedException
{
	driver.get("https://www.makemytrip.com/");

	LocalDate today = LocalDate.now();
//	System.out.println(today);
 //   System.out.println(today.plusDays(30));
    String dat = (today.plusDays(30).toString());
	String newD  = dat.substring(dat.length()-2);
    String modifiedDate = "Nov "+newD+" 2020";
  //  System.out.println(modifiedDate);
	
 /*   Thread.sleep(3400);
    driver.switchTo().frame("script");
    //driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
    driver.switchTo().defaultContent();
    
  */  
    driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
    driver.findElement(By.xpath("//label[@for='departure']//preceding::span[@class='lbl_input latoBold appendBottom10']")).click();
    driver.findElement(By.xpath("//div[contains(@aria-label,'"+modifiedDate+"')]")).click();
    driver.findElement(By.xpath("//a[text()='Search']")).click();
  
    String totFlights = driver.findElement(By.xpath("//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]")).getText();
    String minPrice   = driver.findElement(By.xpath("//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]//following::p[@class='font10'][1]")).getText();

    System.out.println("Number of Flights with 1 Stop for 30 days from today is "+totFlights.substring(totFlights.length()-4,totFlights.length()-1));
    System.out.println("Minimum price for Flights with 1 Stop for 30 days from today is Rs."+minPrice.substring(minPrice.length()-5));
    
}

@AfterClass
public void tearDown()
{
	driver.quit();
}


}
