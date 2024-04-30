package PageObject;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage2 extends BasePage{
		
	// Constructor for GiftCardPage2 class
	public GiftCardPage2(WebDriver driver) {
	    super(driver);
	}

	// WebElements for the recipient's and customer's details
	@FindBy(xpath="//*[@name='recipient_name']") WebElement recipientname;
	@FindBy(xpath="//*[@name='recipient_email']") WebElement recipientemail;
	@FindBy(xpath="//*[@name='recipient_mobile_number']") WebElement recipientmobile;
	@FindBy(xpath="//*[@name='customer_name']") WebElement customername;
	@FindBy(xpath="//*[@name='customer_email']") WebElement customeremail;
	@FindBy(xpath="//*[@name='customer_mobile_number']") WebElement customermobile;
	@FindBy(xpath="//*[@name='customer_address']") WebElement customeraddress;
	@FindBy(xpath="//*[@name=\"zip\"]") WebElement pincode;
	@FindBy(xpath="//*[@id='app-container']//form/button") WebElement clickbutton;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section/div[2]") WebElement page;

	// Methods to set recipient's details
	public void recipientname(String rname) {
	    recipientname.sendKeys(rname);  // Set recipient's name
	}
	public void recipientemail(String remail) {
	    recipientemail.sendKeys(remail);  // Set recipient's email
	}
	public void recipientemobile(String rmobile) {
	    recipientmobile.sendKeys(rmobile);  // Set recipient's mobile number
	}

	// Methods to set customer's details
	public void customername(String cname) {
	    customername.sendKeys(cname);  // Set customer's name
	}
	public void customeremail(String cemail) {
	    customeremail.sendKeys(cemail);  // Set customer's email
	}
	public void customermobile(String cmobile) {
	    customermobile.sendKeys(cmobile);  // Set customer's mobile number
	}
	public void customeraddress(String caddress) {
	    customeraddress.sendKeys(caddress);  // Set customer's address
	}

	// Method to set pincode
	public void pincode(String string) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
	    pincode.sendKeys(string);  // Set pincode
	}

	// Method to click the button
	public void button() {
	    JavascriptExecutor j=(JavascriptExecutor)driver;
	    j.executeScript("arguments[0].click()",clickbutton);  // Click the button
	    try {
	        Thread.sleep(7000);  // Wait for 7 seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();  // Print the stack trace for the InterruptedException
	    }
	}

	// Method for page navigation
	public void pagenavigation() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Wait for 10 seconds
	    page.isDisplayed();
	}

	   
}
