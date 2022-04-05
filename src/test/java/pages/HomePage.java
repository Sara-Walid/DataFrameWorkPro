package pages;

import org.openqa.selenium.By;

import TestProject.DataFrameWorkPro.ConfigUtil;
import TestProject.DataFrameWorkPro.actions.ElementActions;

public class HomePage extends ElementActions {
	
	//Locators
    By signIn = By.cssSelector("a[title='Log in to your customer account']");
    
    public void openAutomationPractice() {
    	
        System.out.println(ConfigUtil.Web_URL);
        driver.navigate().to(ConfigUtil.Web_URL);
    }
    
    public void clickSignIn() {
    	
    	getElement(signIn).click();
    }
    
}

