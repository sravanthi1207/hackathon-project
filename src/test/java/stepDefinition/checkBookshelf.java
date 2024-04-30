package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.GiftCard;
import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkBookshelf extends BaseClass {
	
	public WebDriver driver = getDriver(); // Getting the WebDriver instance
	Logger logger=BaseClass.getLogger(); // Getting the Logger instance
	public LivingHomePage homepage = new LivingHomePage(driver); // Creating an instance of LivingHomePage
	public SearchItems search_result = new SearchItems(driver); // Creating an instance of SearchItems
	GiftCard gift_carrd; 		// Declaring an instance of GiftCard
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx"); // Creating an instance of excel_Utility

	
	@Given("the user is in Bookshelves page")
	public void the_user_is_in_bookshelves_page() {
		BaseClass.getLogger().info("the user is in Bookshelves page... ");
	    homepage= new LivingHomePage(driver); // Creating a new instance of LivingHomePage
	    homepage.searchbox(); // Accessing the search box
	}

	
	@When("the user enters the invalid input as search {string}")
	public void the_user_enters_the_invalid_input_as_search(String string) {
		BaseClass.getLogger().info("the user enters the invalid input as search {string}... ");
	    homepage.searchbox().sendKeys("Bwqdvnjibvoiqbvb1232"); // Sending the invalid input to the search box
	    homepage.clicksearchbtn(); // Clicking the search button
	}

	
	@When("the user enters the input as search {string}")
	public void the_user_enters_the_input_as_search(String string) {
		BaseClass.getLogger().info("the user enters the input as search {string}... ");
	    homepage.searchbox().sendKeys(string); // Sending the valid input to the search box
	    homepage.clicksearchbtn(); // Clicking the search button
	}

	
	@When("user close the authentication popup")
	public void user_close_the_authentication_popup() {
		BaseClass.getLogger().info("user close the authentication popup... ");
	    search_result.close_popup(); // Closing the popup
	}


	@When("user set the category")
	public void user_set_the_category() throws InterruptedException {
		BaseClass.getLogger().info("user set the category... ");
	    search_result.category_hover(); // Hovering over the category
	    search_result.kids_filters(); // Selecting the kids filters
	}

	
	@When("user set price in dropdown")
	public void user_set_price_in_dropdown() {
		BaseClass.getLogger().info("user set price in dropdown... ");
	    search_result.sort(); // Sorting the results
	}

	
	@Then("user get the first three items name and price in console")
	public void user_get_the_first_three_items_name_and_price_in_console() throws IOException {
		BaseClass.getLogger().info("user get the first three items name and price in console... ");
	    
		List<WebElement> Details = search_result.check_print_results(); // Getting the print results
	    for(int i=0;i<3;i++) {
	        String detail = Details.get(i).getText(); // Getting the text of the detail
	        System.out.println(detail); // Printing the detail
	    }
	}
}

