package steps;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.FlightPage;
import pageObjects.LandingPage;

public class StepDefinition {
	
	public WebDriver driver;
	public FlightPage fp;
	public LandingPage lp;
	public static Logger logger;
	
	@Before
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(250,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("Navigate to Make My trip Website")
	public void navigate_to_Make_My_trip_Website() {
		logger = Logger.getLogger("MakeMyTrip");
		PropertyConfigurator.configure("Log4j.properties");
		driver.get("https://www.makemytrip.com/");
		logger.info("URL Accessed");
	}

	@Given("Click Flight Panel")
	public void click_Flight_Panel() {
		lp = new LandingPage(driver);
		lp.clickFlight();
		logger.info("Click Flight");
	}

	@When("Calculate Date")
	public void calculate_Date() {
	    lp.getLaterDate();
	    logger.info("Date calculated");
	}

	@When("Click Date")
	public void click_Date() {
	   lp.selectDate();
	   logger.info("Date Selected");
	}

	@Then("User Navigated to Flight Page")
	public void user_Navigated_to_Flight_Page() {
	    lp.clickSrch();
	    logger.info("Srch Btn Clicked");
		fp = new FlightPage(driver);
	}

	@Then("User gets total number of {int}-Stop Flights")
	public void user_gets_total_number_of_Stop_Flights(Integer int1) {
	   fp.displayTotalFlights();
	   logger.info("Total number of Flights displayed");
	}

	@Then("User gets minimum cost for {int}-Stop Flights")
	public void user_gets_minimum_cost_for_Stop_Flights(Integer int1) {
	    fp.displayMinimumPrice();
	    logger.info("Min Price displayed");
	}
	
	@After
	public void shutDown()
	{
		driver.quit();
	}

}
