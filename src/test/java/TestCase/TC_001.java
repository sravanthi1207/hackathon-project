package TestCase;

import java.io.FileNotFoundException;
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

public class TC_001 extends base{
	

	public LivingHomePage homepage;
	public  SearchItems search_result;
	GiftCard  gift_carrd;
	public excel_Utility excel= new excel_Utility(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\Input.xlsx");

	

	@Test(priority=0, groups = { "smoke" })
	public void search_functionality() throws FileNotFoundException, IOException {
		
		homepage= new LivingHomePage(driver);
		homepage.searchbox();
		String input=excel.getCellData("Sheet1",0,1);
		homepage.searchbox().sendKeys(input);
		homepage.clicksearchbtn();
		
		search_result = new SearchItems(driver);
		
		search_result.close_popup();
		boolean result = search_result.header_check();
		Assert.assertTrue(result);
		
		screenShot("Search");
		
		
	}

	@Test(priority=1,groups = { "smoke" })
	public void filter_functionality() throws InterruptedException, FileNotFoundException, IOException {
		
		search_result.category_hover(); 
		search_result.kids_filters();
		search_result.instock_filters();
		String result=search_result.first_result();
		Assert.assertTrue(result.contains(excel.getCellData("Sheet1",1,1)));
		
		screenShot("filter");
		
	
		
	}
	
	
	@Test(priority=2,groups = { "regression" })
	public void check_sortfuction() throws IOException {
		

		search_result.sort();
		
		List<WebElement> prices=search_result.prices();
		for(int i=1;i<5;i++) {
			
			String price=prices.get(i-1).getAttribute("content");
			String nprice=prices.get(i).getAttribute("content");
			int  pricee= Integer.parseInt(price);
			int  nextprice = Integer.parseInt(nprice);
			Assert.assertTrue(nextprice<=pricee);
			
		
		}
	       screenShot("check");
		
	}
	
	
	@Test(priority=3,groups = { "regression" })
	public void check_and_print() throws FileNotFoundException, IOException {
	
		List<WebElement> Details = search_result.check_print_results();
		int r=1;
		for(int i=0;i<3;i++) {
			String detail = Details.get(i).getText();
			//Assert.assertTrue(detail.contains(excel.getCellData("Sheet1",1,1)));
			excel.setCellData("Sheet2", r ,0, detail);
			r++;
			System.out.println(detail);
			
			
		}
		screenShot("print");
		
		}
	
}