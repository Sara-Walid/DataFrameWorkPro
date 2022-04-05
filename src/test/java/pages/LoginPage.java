package pages;

import org.openqa.selenium.By;

import TestProject.DataFrameWorkPro.actions.ElementActions;

public class LoginPage extends ElementActions {
    
    By email = By.id("email");
    By password = By.id("passwd");
    By submitLogin = By.id("SubmitLogin");
    
    public void typeEmail(String emailValue)
    {
    	getElement(email).sendKeys(emailValue);
    }
    public void typePassword(String passwordValue)
    {
    	getElement(password).sendKeys(passwordValue);
    }
    public void clickSubmit()
    {
    	getElement(submitLogin).click();
    }
    
}
