package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class checkLivingMenu {
	// WebDriver instance from the BaseClass
	public WebDriver driver = BaseClass.getDriver();

	// Logger instance from the BaseClass
	Logger logger=BaseClass.getLogger();
	public LivingHomePage homepage = new LivingHomePage(driver);
	public  SearchItems search_result = new SearchItems(driver);
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");

	
	@Given("the user scrolls up to Header")
	public void the_user_scrolls_up_to_header() throws InterruptedException {
		BaseClass.getLogger().info("the user scrolls up to Header... ");
		// Clicks the search button on the homepage
		homepage.clicksearchbtn();
	}

	
	@Then("the user clicks on Living storage")
	public void the_user_clicks_on_living_storage() throws InterruptedException {
		// Logs the action of the user clicking on the living storage header
		BaseClass.getLogger().info("User clicks on living storage header... ");
		
		// Hovers over an element on the homepage
		homepage.Hover();
	}

	
	@Then("the user extracts all items under living storage")
	public void the_user_extracts_all_items_under_living_storage() {
		// Logs the action of the user extracting all items under living storage
		BaseClass.getLogger().info("User extracts all items under living storage... ");
		
		// Gets the options under the Living section
		homepage.Living_Options();
	}

	
	@Then("the user clicks on table section")
	public void the_user_clicks_on_table_section() {
		BaseClass.getLogger().info("the user clicks on table section... ");
		// Searches for a specific item in the search box
		homepage.searchbox();
	}


}
