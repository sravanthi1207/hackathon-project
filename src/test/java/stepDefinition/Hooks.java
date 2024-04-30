package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	// Declaring WebDriver, Properties and TakesScreenshot variables
	WebDriver driver;
	static Properties p;
	TakesScreenshot ts;
	     
	@Before
	public void setup() throws IOException
	{
	    // Initializing the browser using BaseClass
	    driver=BaseClass.initilizeBrowser();
	    
	    // Getting properties using BaseClass
	    p=BaseClass.getProperties();
	    
	    // Navigating to the application URL
	    driver.get(p.getProperty("appURL"));
	    
	    // Maximizing the browser window
	    driver.manage().window().maximize();
	}

	@After
	public void addScreenshot(Scenario scenario) throws IOException 
	{
	    // Casting driver to TakesScreenshot
	    ts=(TakesScreenshot) driver;

	    // Taking screenshot and attaching it to the scenario
	    byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	    scenario.attach(screenshot, "image/png",scenario.getName());
	}

	@After(order=2)
	public void tearDown() {
	    // Quitting the driver after test execution
	    driver.quit();
	}

}
   

