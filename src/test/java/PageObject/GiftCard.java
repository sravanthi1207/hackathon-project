package PageObject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


 
 
public class GiftCard  {
	public WebDriver driver; // WebDriver instance

	// Constructor for GiftCard class
	public GiftCard(WebDriver driver)
	{
	    this.driver=driver; // Assigning the passed WebDriver instance to the local instance
	    PageFactory.initElements(driver, this); // Initializing the WebElements in this class with the driver instance
	}

	// WebElements (locators)

	@FindBy(xpath ="//*[@id='header']/section/div/ul[2]/li[3]/a")
	WebElement Gift_cards; // WebElement for Gift Cards

	@FindBy(xpath = "//*[@id='app-container']/div/main/section/section[1]/ul/li[3]")
	WebElement Birthday_button; // WebElement for Birthday button

	@FindBy(xpath = "//*[@id=\'ip_2251506436\']")
	WebElement searchbox_amt; // WebElement for search box amount

	@FindBy(xpath = "//*[@id=\"ip_4036288348\"]")
	WebElement Name_receiver; // WebElement for receiver's name

	@FindBy(xpath = "//*[@id=\"ip_137656023\"]" )
	WebElement receiver_Email; // WebElement for receiver's email

	@FindBy(xpath =  "//*[@id=\"ip_3177473671\"]")
	WebElement receiver_Number; // WebElement for receiver's number

	@FindBy(xpath = "//*[@id=\"ip_1082986083\"]" )
	WebElement Name_sender; // WebElement for sender's name

	@FindBy(xpath =  "//*[@id=\"ip_4081352456\"]")
	WebElement sender_Email; // WebElement for sender's email

	@FindBy(xpath = "//*[@id=\"ip_2194351474\"]" )
	WebElement Sender_Address; // WebElement for sender's address

	@FindBy(xpath = "//*[@id=\"ip_567727260\"]")
	WebElement Sender_pincode; // WebElement for sender's pincode

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement Confirm_button; // WebElement for confirm button

	@FindBy(xpath = "//*[@id=\"ip_2121573464\"]")
	WebElement Sender_Number; // WebElement for sender's number

	@FindBy(xpath = "//*[@id=\'ip_2251506436\']" )
	WebElement amount; // WebElement for amount

	// Method to set the amount
	public void Amount(String price) {
	    amount.sendKeys(price); // Sending the price to the amount WebElement
	}

	
	// WebElements for locating the elements
	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	WebElement button; 

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement cnfrm_button; 

	@FindBy(xpath = "//*[@id='search_button']/span")
	WebElement Gift_card; 

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	WebElement nxt_button;

	@FindBy(xpath = "//*[@id=\"ip_582840596\"]")
	WebElement Message; 

	@FindBy(xpath = "//*[@id='ip_137656023']")
	WebElement AlertMessage; 

	@FindBy(xpath = "//*[@id='app-container']/div/main/section/section[4]/div[2]/section[1]/div[2]")
	WebElement cnfrm_amt; 

	@FindBy(xpath = "//*[@id='app-container']/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div[1]")
	WebElement cnfrm_receiver_name; 

	@FindBy(xpath = "//*[@id='app-container']/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div[2]")
	WebElement cnfrm_sender_email; 
	
	@FindBy(xpath = "//*[@id='app-container']/div/main/section/section[4]/div[2]/section[3]/div[3]/div[2]")
	WebElement cnfrm_message; 

	@FindBy(xpath = "//*[@id='search_button']/span")
	WebElement search_button; 

	JavascriptExecutor j=(JavascriptExecutor)driver; 

	// Method to click next button
	public void nxt_button() {
	    try {
	        nxt_button.click(); // Clicking the next button
	    }
	    catch(Exception e){
	        System.out.println("User enter the Invalid Input"); // Exception handling for invalid input
	    }
	}

	// Method to return search button WebElement
	public WebElement search_btn() {
	    return search_button;
	}

	// Method to click home button in gift card
	public void homeButtonGiftCard_click() {
	    Gift_cards.click(); // Clicking the gift cards
	}

	// Method to click gift
	public void gift() {
	    Actions act=new Actions(driver);    // Actions instance
	    act.moveToElement(Birthday_button); // Moving to birthday button
	    Birthday_button.click();            // Clicking the birthday button
	}

	// Method to click gift card
	public void click_giftcard() {
	    Gift_card.click(); // Clicking the gift card
	}

	// Getter methods for WebElements

	public WebElement Name_receiver() {
	    return Name_receiver;
	}

	public WebElement searchbox_amt() {
	    return searchbox_amt;
	}

	public WebElement receiver_Email() {
	    return receiver_Email;
	}

	public WebElement receiver_Number() {
	    return receiver_Number;
	}

	public WebElement Name_sender() {
	    return Name_sender;
	}

	public WebElement sender_Email() {
	    return sender_Email;
	}

	public WebElement Sender_Address() {
	    return Sender_Address;
	}

	public WebElement Sender_pincode() {
	    return Sender_pincode;
	}

	public WebElement Confirm_button() {
	    return Confirm_button;
	}

	public WebElement Sender_Number() {
	    return Sender_Number;
	}

	// Method to send message
	public WebElement Send_message() {
	    Message.click(); // Clicking the message
	    return Message;
	}

	// Method to get alert message
	public String AlertMessage() {
	    return AlertMessage.getAttribute("validationMessage"); // Getting the validation message attribute from the alert message WebElement
	}

	
	// Getter methods for validation WebElements

	public WebElement cnfrm_amt_validation() {
	    return cnfrm_amt;
	}

	public WebElement cnfrm_rname_validation() {
	    return cnfrm_receiver_name;
	}

	public WebElement cnfrm_message_validation() {
	    return cnfrm_message;
	}

	public WebElement cnfrm_semail_validation() {
	    return cnfrm_sender_email;
	}

}
 