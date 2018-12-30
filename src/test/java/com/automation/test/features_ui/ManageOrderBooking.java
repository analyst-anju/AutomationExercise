package com.automation.test.features_ui;

import org.openqa.selenium.WebDriver;

import com.automation.test.Login;
import com.automation.test.MyAccount;
import com.automation.test.OrderBooking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageOrderBooking
{
   public WebDriver driver = null;
   OrderBooking ob = new OrderBooking();
   Login lg = new Login();
   MyAccount ma = new MyAccount();

   @Given("^I access the shopping website \"([^\"]*)\"$")
   public void i_access_the_shopping_website(String urlName) throws Throwable
   {
      driver = ob.openWebsite(urlName);
   }

   @When("^I fill in login name \"([^\"]*)\" and password \"([^\"]*)\"$")
   public void i_fill_in_login_name_and_password(String username, String password) throws Throwable
   {
     // ob.loginApp(username, password);
      lg.loginApp(username, password, driver);
   }

   @Then("^The user name \"([^\"]*)\" is visible in the main page$")
   public void the_user_name_is_visible_in_the_main_page(String userName) throws Throwable
   {
      ob.assertPageLogin(userName);
   }

   @When("^I click on \"([^\"]*)\" tab$")
   public void i_click_on_tab(String tabName) throws Throwable
   {
      ob.clickOnTab(tabName);
   }

   @When("^I hover on \"([^\"]*)\" click on Add to cart$")
   public void i_hover_on_click_on_Add_to_cart(String itemName) throws Throwable
   {
      ob.hoverItem(itemName);
   }

   @When("^I click on Proceed to checkout on the pop up window$")
   public void i_click_on_Proceed_to_checkout_on_the_pop_up_window() throws Throwable
   {
      ob.onPopUp();
   }

   @When("^I click on Proceed to checkout on SHOPPING-CART SUMMARY$")
   public void i_click_on_Proceed_to_checkout_on_SHOPPING_CART_SUMMARY() throws Throwable
   {
      ob.onCartSummary();
   }

   @When("^I click on Proceed to checkout on ADDRESSES$")
   public void i_click_on_Proceed_to_checkout_on_ADDRESSES() throws Throwable
   {
      ob.onAddress();
   }

   @When("^I click on Terms of service then Proceed to checkout on SHIPPING window$")
   public void i_click_on_Terms_of_service_then_Proceed_to_checkout_on_SHIPPING_window() throws Throwable
   {
      ob.onShipping();
   }

   @When("^I arrive at the Payment page$")
   public void i_arrive_at_the_Payment_page() throws Throwable
   {
      ob.onPayment();
   }

   @When("^I click on the user name \"([^\"]*)\"$")
   public void i_click_on_the_user_name(String userName) throws Throwable
   {
      ob.clickLoggedUser(userName);
   }

   @When("^I click on \"([^\"]*)\" on My account page$")
   public void i_click_on_on_My_account_page(String itemName) throws Throwable
   {
      //ob.clickUserProfileItem(itemName);
      ma.clickUserProfileItem(itemName,driver);
   }

   @Then("^The order details are visible$")
   public void the_order_details_are_visible() throws Throwable
   {
      ob.assertOrderDetails();
   }

   @Then("^I logout from the shopping website$")
   public void i_logout_from_the_shopping_website() throws Throwable
   {
      //ob.logout();
      lg.logout();
   }

   @Then("^I update the \"([^\"]*)\" as \"([^\"]*)\"$")
   public void i_update_the_as(String fieldName, String value) throws Throwable
   {
      //ob.setValueInProfile(fieldName, value);
      ma.setValueInProfile(fieldName, value);
   }

   @Then("^I click on Save$")
   public void i_click_on_Save() throws Throwable
   {
      ob.clickButtonOnProfile();
   }

}
