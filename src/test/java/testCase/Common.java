package testCase;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {

public WebDriver driver = null;
public void allcases() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(250,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");

	LocalDate today = LocalDate.now();
//	System.out.println(today);
 //   System.out.println(today.plusDays(30));
    String dat = (today.plusDays(30).toString());
	String newD  = dat.substring(dat.length()-2);
    String modifiedDate = "Nov "+newD+" 2020";
  //  System.out.println(modifiedDate);
    /*	
       driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
    driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
    driver.switchTo().defaultContent();
    
    
 //    if(driver.findElement(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")).isDisplayed())
  //   {
      driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
  //   }

    Thread.sleep(2500);
 //   driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
 //   driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
 //   driver.findElement(By.cssSelector("#SW > div.landingContainer > div.headerOuter > div > div > nav > ul > li.menu_Flights > a > span.chNavIcon.appendBottom2.chSprite.chFlights.active")).click();
 //   driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
   driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
*/    driver.findElement(By.xpath("//label[@for='departure']//preceding::span[@class='lbl_input latoBold appendBottom10']")).click();
    driver.findElement(By.xpath("//div[contains(@aria-label,'"+modifiedDate+"')]")).click();
    driver.findElement(By.xpath("//a[text()='Search']")).click();
  
    String totFlights = driver.findElement(By.xpath("//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]")).getText();
    String minPrice   = driver.findElement(By.xpath("//span[text()='ONWARD JOURNEY']//following::p[@class='font14 append_bottom4 lineHeight18'][2]//following::p[@class='font10'][1]")).getText();

    System.out.println("Number of Flights with 1 Stop for 30 days from today is "+totFlights.substring(totFlights.length()-4,totFlights.length()-1));
    System.out.println("Minimum price for Flights with 1 Stop for 30 days from today is Rs"+minPrice.substring(minPrice.length()-5));
    System.out.println(driver.getTitle());
}



}
