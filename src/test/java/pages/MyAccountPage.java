package pages;


import org.openqa.selenium.By;

import TestProject.DataFrameWorkPro.Assertions;
import TestProject.DataFrameWorkPro.actions.ElementActions;

public class MyAccountPage extends ElementActions {
	
	Assertions assertions = new Assertions();
	
    By myAccountTitle = By.cssSelector(".page-heading");
    
    String myAccountTitleText = "MY ACCOUNT";
    
    public void assertMyAccountTitle() {
    	
    	assertions.assertElementText(myAccountTitle, myAccountTitleText);
    }
}