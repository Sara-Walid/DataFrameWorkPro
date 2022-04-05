package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class Login_StepDef extends LoginPage{
	HomePage homePage = new HomePage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	
	@Given("I open Website")
	public void i_open_website() {
	    homePage.openAutomationPractice();
	}

	@When("I click signin")
	public void i_click_signin() {
	    homePage.clickSignIn();
	}

	@When("I type email {string}")
	public void i_type_email(String email) {
	    typeEmail(email);
	}

	@When("I type password {string}")
	public void i_type_password(String password) {
	    typePassword(password);
	}


	@When("I click on submit login")
	public void i_click_on_submit_login() {
	    clickSubmit();
	}

	@Then("I validate my account title")
	public void i_validate_my_account() {
		myAccountPage.assertMyAccountTitle();
	}
}

