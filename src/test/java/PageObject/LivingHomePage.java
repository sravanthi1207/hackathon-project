package PageObject;

import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 
public class LivingHomePage{
	
	
	public WebDriver driver;
	
	public LivingHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	
	@FindBy(xpath = "//*[@id='header']/div[1]/div/section[1]/a/figure" )
	WebElement Page_title;
	
	@FindBy(xpath = "//input[@type=\'search\'][@placeholder=\'Search\']")
	WebElement type_search;
	
	@FindBy(xpath = "//*[@id='search_button']/span")
	WebElement search_button;
	
	@FindBy(xpath = "//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement Gift_card;
	
	@FindBy(xpath = "//li[@class=\"topnav_item livingunit\"]//div/div/ul/li[3]//li" )
	List<WebElement> Options_Living;
	
	@FindBy(xpath = "//*[@id=\"topnav_wrapper\"]/ul/li[3]" )
	WebElement hower_living;



	// Getter methods for WebElements
	public WebElement searchbox() {
		type_search.click();
		return type_search;

	}
	
	public void clicksearchbtn(){
		search_button.click();
	
	}
	

	public void Hover() throws InterruptedException {
		//WebElement living = (hower_living);
		Actions a= new Actions(driver);
	    a.moveToElement(hower_living).perform();
	    Thread.sleep(3000);
	}
	public List<WebElement> Living_Options() {
		List<WebElement> sub_menu =(Options_Living);
		return sub_menu;
		
		}

 
	}



