package TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.GiftCard;
import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.base;

public class TC_003 extends base {
	
	public LivingHomePage homepage;
	public  SearchItems search_result;
	GiftCard  gift_carrd;
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");
	
	@Test(priority=0, groups = { "smoke" })
	public void choose_giftcard_validate() throws FileNotFoundException, IOException, InterruptedException{
	 gift_carrd= new GiftCard(driver);
				 
	gift_carrd.homeButtonGiftCard_click();
	gift_carrd.gift();
	
	
    String amt = excel.getCellData("Sheet4", 0, 1);
    gift_carrd.searchbox_amt().sendKeys(amt);
	
	gift_carrd.nxt_button();
	
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
	

	gift_carrd.Confirm_button().click();
	Thread.sleep(3000);
	
	String AlertMessage= gift_carrd.AlertMessage();
	System.out.println(AlertMessage);
	excel.setCellData("Sheet3", 8, 0, AlertMessage);
	
	
	
     screenShot("giftcard");
	
	 }
    @Test(priority=1, groups = { "regression" })
	public void checkout_validation() throws FileNotFoundException, IOException {
    	
    	 gift_carrd.receiver_Email().clear();
		 String rremail = excel.getCellData("Sheet4", 10, 1);
		
		 gift_carrd.receiver_Email().sendKeys(rremail);
		 
		 gift_carrd.Confirm_button().click();
		 
		 
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
		 
		 screenShot("out");
		 
		 
	 }

}

