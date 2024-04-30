package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LivingSubMenu {
	
		public WebDriver driver = BaseClass.getDriver();
			
		//Initializing logger from BaseClass
		Logger logger=BaseClass.getLogger();
		
		//Creating an instance of LivingHomePage
		public LivingHomePage homepage = new LivingHomePage(driver);
		
		//Creating an instance of SearchItems
		public  SearchItems search_result = new SearchItems(driver);
		
		//Creating an instance of excel_Utility and providing the path of Input.xlsx file
		public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");
		
		@Given("Hover mouse to living")
		public void hover_mouse_to_living() throws InterruptedException {
		BaseClass.getLogger().info("Hover mouse to living... ");
		 // Hovering mouse to living
		 homepage.Hover();
		}
		
		@When("sub menus should be appeared and print it")
		public void sub_menus_should_be_appeared_and_print_it() throws IOException {
		 // Logging information about sub menus
		 BaseClass.getLogger().info("sub menus should be appeared and print it... ");
		 
		 // Getting the list of sub menus
		 List<WebElement> submenu = homepage.Living_Options();
		 int menu_count=0;
		 
		 // Looping through each sub menu
		 for(int i=0;i<submenu.size();i++) {
		     // Getting the text of sub menu
		     String sub_menu = submenu.get(i).getText();
		     
		     // Writing the sub menu text to the excel file
		     excel.setCellData("Sheet3", menu_count, 0 ,sub_menu);
		     menu_count++;
		 }
		}

}

