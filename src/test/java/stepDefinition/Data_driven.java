package stepDefinition;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import PageObject.Confirm_Page_Gift;
import PageObject.GiftCardPage2;
import Utilities.DataReader;
import factory.BaseClass;
import io.cucumber.java.en.*;

public class Data_driven {
	
	// List of HashMaps for data-driven testing
	List<HashMap<String, String>> datamap;

	// Variables for recipient's details
	String rname;
	String remail;
	String rmobile;

	// Variables for customer's details
	String cname;
	String cemail;
	String cmobile;
	String caddress;
	String pincode;

	// WebDriver instance from the BaseClass
	WebDriver driver=BaseClass.getDriver();

	// Page object for the GiftCardPage2
	GiftCardPage2 pg=new GiftCardPage2(driver);

	
	@Then("user enters the invalid {string} from excel in the form")
	public void user_enters_the_invalid_from_excel_in_the_form(String row) throws InterruptedException {
		// Logs the action of the user passing values from Excel
		BaseClass.getLogger().info("User passes values from excel.. ");

		// Reads data from the Excel file
		datamap=DataReader.data(System.getProperty("user.dir")+"/TestData/Data.xlsx", "Sheet1");

		// Extracts data from the specified row in the Excel file
		int index=Integer.parseInt(row)-1;
		rname= datamap.get(index).get("Recipientsname");
		remail= datamap.get(index).get("Recipientsemail");
		rmobile= datamap.get(index).get("Recipientmobile");
		cname= datamap.get(index).get("Customername");
		cemail= datamap.get(index).get("Customeremail");
		cmobile= datamap.get(index).get("Customermobile");
		caddress= datamap.get(index).get("Customeraddress");
		pincode=datamap.get(index).get("Pincode");

		// Enters the extracted data into the form
		pg.recipientname(rname); 
		pg.recipientemail(remail); 
		pg.recipientemobile(rmobile); 	
		pg.customername(cname);
		pg.customeremail(cemail);
		pg.customermobile(cmobile); 
		pg.customeraddress(caddress);
		pg.pincode(pincode);
	}

	
	@Then("user enters the valid {string} from excel in the form")
	public void user_enters_the_valid_from_excel_in_the_form(String row) {
		// Logs the action of the user passing values from Excel
		BaseClass.getLogger().info("User passes value from excel.. ");

		// Reads data from the Excel file
		datamap=DataReader.data(System.getProperty("user.dir")+"/TestData/Data.xlsx", "Sheet1");

		// Extracts data from the specified row in the Excel file
		int index=Integer.parseInt(row)-1;
		rname= datamap.get(index).get("Recipientsname");
		remail= datamap.get(index).get("Recipientsemail");
		rmobile= datamap.get(index).get("Recipientmobile");
		cname= datamap.get(index).get("Customername");
		cemail= datamap.get(index).get("Customeremail");
		cmobile= datamap.get(index).get("Customermobile");
		caddress= datamap.get(index).get("Customeraddress");
		pincode=datamap.get(index).get("Pincode");

		// Enters the extracted data into the form
		pg.recipientname(rname); 
		pg.recipientemail(remail); 
		pg.recipientemobile(rmobile); 	
		pg.customername(cname);
		pg.customeremail(cemail);
		pg.customermobile(cmobile); 
		pg.customeraddress(caddress);
		pg.pincode(pincode);
	}

	
	@Then("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		// Logs the action of the user clicking the submit button
		BaseClass.getLogger().info("User clicks submit button.. ");

		// Clicks the submit button
		pg.button();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pg.button();
	}

	
	@Then("user checks the confirmdetails page is visible")
	public void user_checks_the_confirmdetails_page_is_visible() {
		// Logs the action of the user checking if the page is visible
		BaseClass.getLogger().info("User checks page is visible ?.. ");

		// Checks if the page has navigated to the confirm details page
		pg.pagenavigation();
	}

	
	@Then("validate the input provided with the inputs in Details section")
	public void validate_the_input_provided_with_the_inputs_in_details_section() {
		// Logs the action of the user validating the entered data with the displayed data
		BaseClass.getLogger().info("User validates the data eneterd with data displayed.. ");

		// Page object for the Confirm_Page_Gift
		Confirm_Page_Gift confrimDetails = new Confirm_Page_Gift(driver);

		// Validates the entered details with the details displayed on the page
		confrimDetails.valid_details(rname,remail,rmobile,cname,cemail,cmobile,caddress);
	}

}
