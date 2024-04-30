package factory;
 
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class base{
 
	// Declare WebDriver and Logger as static variables
	public static WebDriver driver;
	public static Logger logger;

	// Method to set up the WebDriver before each test
	@BeforeTest(groups={"smoke","regression"})
	@Parameters({"browsers"})
	public void driverSetup(String browser) throws InterruptedException, IOException {
	    
		// Initialize the logger
	    logger = LogManager.getLogger(this.getClass());
	    
	    // Check which browser is specified for the test
	    if(browser.equals("chrome")){
	        // If it's Chrome, initialize the ChromeDriver
	        driver = new ChromeDriver();
	        System.out.println("Chrome Browser Launched Successfully");
	        logger.info("started logs");
	    }
	    else if(browser.equals("edge")) {
	        // If it's Edge, initialize the EdgeDriver
	        driver = new EdgeDriver();
	        System.out.println("Edge Browser Launched Successfully");
	    }
	    
	    //open the specified URL, and maximize the window
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.urbanladder.com/");
	    driver.manage().window().maximize();
	}

	// Method to close the browser after each test
	@AfterTest(groups={"smoke"})
	public void closeBrowser() {
	    driver.quit();
	}

	//Taking screenshots for each test cases
	public static String screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png";
		File trg = new File(path);
		FileUtils.copyFile(src, trg);
		return path;
		//return trg.getAbsolutePath();
		
	}
}