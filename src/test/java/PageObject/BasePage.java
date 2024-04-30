package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 WebDriver driver;
	    
	// Constructor for the BasePage class
	 public BasePage(WebDriver driver)
	 {
	     // Assigning the passed WebDriver instance to the class variable
	     this.driver=driver;
	 
	     PageFactory.initElements(driver,this);// Initializing the WebElements of this page object
	 }

	   	   
}





