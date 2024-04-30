package stepDefinition;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObject.GiftCard;
import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class BookShelf extends BaseClass {
	
	public WebDriver driver = getDriver(); 	// Getting the WebDriver instance
	Logger logger=BaseClass.getLogger(); 	// Getting the Logger instance
	public LivingHomePage homepage = new LivingHomePage(driver); // Creating an instance of LivingHomePage
	public SearchItems search_result = new SearchItems(driver); // Creating an instance of SearchItems
	GiftCard gift_carrd; // Declaring an instance of GiftCard
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx"); // Creating an instance of excel_Utility

	@Given("search for bookshelves")
	public void search_for_bookshelves_under() throws FileNotFoundException, IOException {
		
		BaseClass.getLogger().info("search for bookshelves... ");
		
	    homepage= new LivingHomePage(driver); 		// Creating a new instance of LivingHomePage
	    homepage.searchbox();		 	// Accessing the search box
	    String input=excel.getCellData("Sheet1",0,1); // Getting the cell data from the excel sheet
	    homepage.searchbox().sendKeys(input); 		// Sending the input to the search box
	    homepage.clicksearchbtn(); 		// Clicking the search button
	    search_result = new SearchItems(driver); 	// Creating a new instance of SearchItems
	    search_result.close_popup(); 	// Closing the popup
	}	

	@When("select kids category")
	public void select_kids_category() throws InterruptedException {
		BaseClass.getLogger().info("select kids category... ");
	    search_result.category_hover(); // Hovering over the category
	    search_result.kids_filters(); 	// Selecting the kids filters
	}

	@And("select in stock")
	public void select_in_stock() throws InterruptedException {
		BaseClass.getLogger().info("select in stock... ");
	    search_result.instock_filters(); // Selecting the in-stock filters
	}

	@And("priority high to low")
	public void priority_low_to_high() {
		BaseClass.getLogger().info("priority high to low... ");
	    search_result.sort(); // Sorting the results
	}

	@Then("Print the first three bookshelves")
	public void print_the_first_three_bookshelves_under() throws IOException {
		BaseClass.getLogger().info("Print the first three bookshelves... ");
	    List<WebElement> Details = search_result.check_print_results(); // Getting the print results
	    int r=1;
	    for(int i=0;i<3;i++) {
	        String detail = Details.get(i).getText();		 // Getting the text of the detail
	        Assert.assertTrue(detail.contains(excel.getCellData("Sheet1",1,1))); // Asserting that the detail contains the cell data
	        excel.setCellData("Sheet2", r ,0, detail); 		// Setting the cell data in the excel sheet
	        r++;
	        System.out.println(detail); // Printing the detail
	    }
	}
}
	
