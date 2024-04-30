package TestCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.GiftCard;
import PageObject.LivingHomePage;
import PageObject.SearchItems;
import Utilities.excel_Utility;
import factory.base;

public class TC_002 extends base {
	
	public LivingHomePage homepage;
	public  SearchItems search_result;
	GiftCard  gift_carrd;
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");
	
	@Test(priority=0, groups = { "regression" })
	 public void submenu_printcheck() throws InterruptedException, IOException {
		 search_result= new SearchItems(driver); 
		 search_result.scroll_down();
		 //search_result.nhome_page();
		 homepage = new LivingHomePage(driver);
		 
		 homepage.Hover();
		 List<WebElement> submenu = homepage.Living_Options();
		 int menu_count=0;
		 for(int i=0;i<submenu.size();i++) {
		 String sub_menu = submenu.get(i).getText();
		 excel.setCellData("Sheet3", menu_count, 0 ,sub_menu);
		 menu_count++;
//		 System.out.println(sub_menu);
		 }
		 Assert.assertEquals(9, menu_count);
		 
		 
		screenShot("Submenu");
		 
		 
	 }

}

