package PageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
 
 
 
public class SearchItems extends BasePage{

	public SearchItems(WebDriver driver)
	{
	    super(driver); // Calling the parent class constructor
	}

	// WebElements (locators)

	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")
	WebElement filters; // WebElement for filters

	@FindBy(xpath = "//*[@id=\"filters_primary_category_Kids_Bookshelves\"]")
	WebElement category_kids; // WebElement for kids category

	@FindBy(xpath ="//*[@id='filters_availability_In_Stock_Only']")
	WebElement filters_instock; // WebElement for in-stock filters

	@FindBy(xpath = "//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
	WebElement recommended; // WebElement for recommended

	@FindBy(xpath = "//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")
	WebElement sortby_high_low; // WebElement for sorting by high to low

	@FindBy(xpath = "//*[@id='search-results']/div[3]/ul/li")
	List<WebElement> print_results; // List of WebElements for print results

	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/h2")
	WebElement header; // WebElement for header

	@FindBy(xpath = "//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement authentiaction_popup; // WebElement for authentication popup

	@FindBy(xpath = "//*[@id=\"search-results\"]/div[3]/ul/li[1]/div/div[5]/a")
	WebElement lresult; // WebElement for first result

	@FindBy(xpath ="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]" )
	WebElement mousehover; // WebElement for mouse hover

	@FindBy(xpath ="/html/body/div[1]/div[1]/div[2]/div[1]/div[3]/ul/li/div/div[5]/a/div[2]/meta[1]" )
	List<WebElement> prices; // List of WebElements for prices

	@FindBy(xpath ="//*[@id=\"header\"]/div[1]/div/section[1]/a/figure" )
	WebElement logo; // WebElement for logo

	
	// Methods for actions
	public void kids_filters() throws InterruptedException {
	    category_kids.click(); // Clicking the kids category
	    Thread.sleep(2000); // Waiting for 2 seconds
	}

	public void instock_filters() throws InterruptedException {
	    filters_instock.click(); // Clicking the in-stock filters
	    Thread.sleep(2000); // Waiting for 2 seconds
	}

	public void sort() {
	    Actions a = new Actions(driver); // Actions instance
	    a.moveToElement(recommended).perform(); // Moving to recommended
	    sortby_high_low.click(); // Clicking the sort by high to low
	}

	public List<WebElement> check_print_results() {
	    List<WebElement> details = print_results; // Getting the print results
	    return details;
	}

	public boolean header_check() {
	    boolean a = header.isDisplayed(); // Checking if the header is displayed
	    return a;
	}

	public void close_popup() {
	    authentiaction_popup.click(); // Clicking the authentication popup
	}

	public String first_result() {
	    String lstdetails =lresult.getText(); // Getting the text of the first result
	    return lstdetails;
	}

	public void category_hover() {
	    mousehover.click(); // Clicking the mouse hover
	}

	public List<WebElement> prices(){
	    return prices ; // Returning the prices
	}

	public void nhome_page() {
	    logo.click(); // Clicking the logo
	}

	public void scroll_down() {
	    Actions a= new Actions(driver); // Actions instance
	    a.keyDown(Keys.PAGE_UP).perform(); // Scrolling down
	}
	
}

