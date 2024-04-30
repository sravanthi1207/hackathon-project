package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import PageObject.GiftCard;
import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftCardAlert{

	
	
public WebDriver driver = BaseClass.getDriver();
	
	//Logger instance from the BaseClass
	Logger logger=BaseClass.getLogger();
	
	//Page objects for the LivingHomePage and SearchItems
	LivingHomePage homepage = new LivingHomePage(driver);
	SearchItems search_result = new SearchItems(driver);
	
	//Page object for the GiftCard
	GiftCard  gift_carrd;
	
	//Excel utility for reading data from an Excel file
	excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");
	
	
	@Given("click on gift card")
	public void click_on_gift_card() throws InterruptedException, FileNotFoundException, IOException {
		BaseClass.getLogger().info("click on gift card... ");
	 // User clicks on the gift card
		gift_carrd= new GiftCard(driver);
		gift_carrd.homeButtonGiftCard_click();
		gift_carrd.homeButtonGiftCard_click();
		gift_carrd.search_btn().click();
	}
	
	
	@When("click on type of giftcard")
	public void click_on_type_of_giftcard() {
		BaseClass.getLogger().info("click on type of giftcard... ");
		// User clicks on the type of gift card
		gift_carrd.gift();
	}
	
	
	@And("put valid price add click next")
	public void put_valid_price_add_click_next() throws FileNotFoundException, IOException {
		BaseClass.getLogger().info("put valid price add click next... ");
		// User enters a valid price and clicks next
		String amt = excel.getCellData("Sheet4", 0, 1);
		gift_carrd.searchbox_amt().sendKeys(amt);
		gift_carrd.nxt_button();
	}
	
	
	@And("enter valid details and wrong email")
	public void enter_valid_details_and_wrong_email() throws FileNotFoundException, IOException, InterruptedException {
		BaseClass.getLogger().info("enter valid details and wrong email... ");
		// User enters valid details and an incorrect email
		String rname = excel.getCellData("Sheet4", 1, 1);
		gift_carrd.Name_receiver().sendKeys(rname);
		
		String remail = excel.getCellData("Sheet4", 2, 1);   
		gift_carrd.receiver_Email().sendKeys(remail);
		
		String rnumber = excel.getCellData("Sheet4", 3, 1);
		gift_carrd.receiver_Number().sendKeys(rnumber);
		
		String sname = excel.getCellData("Sheet4", 4, 1);
		gift_carrd.Name_sender().sendKeys(sname);
		
		String semail = excel.getCellData("Sheet4", 5, 1);
		gift_carrd.sender_Email().sendKeys(semail);
		
		String saddress = excel.getCellData("Sheet4", 6, 1);
		gift_carrd.Sender_Address().sendKeys(saddress);
			
		String pincode = excel.getCellData("Sheet4", 7, 1);
		gift_carrd.Sender_pincode().sendKeys(pincode);
		
		String snumber = excel.getCellData("Sheet4", 8, 1);
		
		gift_carrd.Sender_Number().sendKeys(snumber);
		
		String message=excel.getCellData("Sheet4", 9, 1);
		gift_carrd.Send_message().sendKeys(message);
	}
	
	
	@Then("alert should appear")
	public void alert_should_appear() throws InterruptedException, IOException {
		BaseClass.getLogger().info("alert should appear... ");
		// An alert should appear
		gift_carrd.Confirm_button();
		Thread.sleep(3000);
		String AlertMessage= gift_carrd.AlertMessage();
		System.out.println(AlertMessage);
		excel.setCellData("Sheet3", 8, 0, AlertMessage);
	}
	
	
	@And("put the valid Details")
	public void put_the_valid_details() throws FileNotFoundException, IOException {
		BaseClass.getLogger().info("put the valid Details... ");
		// User enters the valid details
		String rremail = excel.getCellData("Sheet4", 10, 1);
		gift_carrd.receiver_Email().clear();
		gift_carrd.receiver_Email().sendKeys(rremail);
		gift_carrd.Confirm_button().click();
	}
	
	
	@And("checkout the page should be validated")
	public void checkout_the_page_should_be_validated() throws FileNotFoundException, IOException {
		BaseClass.getLogger().info("checkout the page should be validated... ");
		// User validates the checkout page
		String examt = excel.getCellData("Sheet5", 0, 0);
		String acamount=gift_carrd.cnfrm_amt_validation().getText();
		Assert.assertEquals(acamount, examt);
		
		String exReceiverName = excel.getCellData("Sheet5", 1, 0);
		String acReceiverName=gift_carrd.cnfrm_rname_validation().getText();
		Assert.assertEquals(exReceiverName, acReceiverName);
		
		String exSendererEmail = excel.getCellData("Sheet5", 2, 0);
		String acSendererEmail=gift_carrd.cnfrm_semail_validation().getText();
		Assert.assertEquals(exSendererEmail, acSendererEmail);
		
		String exMessage = excel.getCellData("Sheet5", 3, 0);
		String acMessage=gift_carrd.cnfrm_message_validation().getText();
		Assert.assertEquals(exMessage, acMessage);
	}

}

