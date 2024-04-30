package stepDefinition;

import org.openqa.selenium.WebDriver;

import PageObject.GiftCard;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class checkGiftcard {
	
	WebDriver driver = BaseClass.getDriver(); // Getting the WebDriver instance
	public GiftCard giftCard = new GiftCard(driver); // Creating an instance of GiftCard

	
	@Given("the user successfully navigating to the Giftcard page")
	public void the_user_successfully_navigating_to_the_giftcard_page() throws InterruptedException {
		BaseClass.getLogger().info("the user successfully navigating to the Giftcard page... ");
	    giftCard.homeButtonGiftCard_click(); // Navigating to the GiftCard page
	}

	@Then("the user selects Birthday/Aniversary occasion")
	public void the_user_selects_birthday_aniversary_occasion() {
		BaseClass.getLogger().info("the user selects Birthday/Aniversary occasion... ");
	    giftCard.gift(); // Selecting the Birthday/Anniversary occasion
	}

	@Given("user enters the amount {string} in amount section and selects valid inputs")
	public void user_enters_the_amount_in_amount_section_and_selects_valid_inputs(String string) {
		BaseClass.getLogger().info("user enters the amount {string} in amount section and selects valid inputs... ");
	    giftCard.Amount(string); // Entering the valid amount
	}

	@Then("user clicks next button")
	public void user_clicks_next_button() {
		BaseClass.getLogger().info("user clicks next button... ");
	    giftCard.nxt_button(); // Clicking the next button
	}

	@Given("user enters the amount {string} in amount section and selects invalid inputs")
	public void user_enters_the_amount_in_amount_section_and_selects_invalid_inputs(String string) {
		BaseClass.getLogger().info("user enters the amount {string} in amount section and selects invalid inputs... ");
	    giftCard.Amount(string); // Entering the invalid amount
	}

	@Given("user enters the invalid {string} in the form")
	public void user_enters_the_invalid_in_the_form(String string) {
		BaseClass.getLogger().info("user enters the invalid {string} in the form... ");
	    giftCard.sender_Email(); // Entering the invalid email
	}
}