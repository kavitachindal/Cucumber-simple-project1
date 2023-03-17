package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase{
	LoginPage loginPage;
	
	@Given ("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		initDriver();
		driver.get("https://techfios.com/billing/?ng=admin/"); 
	}
	
	@When ("User enters username as {string}")
	public void user_enters_username_as(String username) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
    }
	
	@When("User enters password as{string}")
	public void user_enters_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clickSignInButton();
	}

	@Then("User should land on dashboard page")
	public void user_should_land_on_dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
	Assert.assertEquals(expectedTitle, actualTitle);   
	}
	
}