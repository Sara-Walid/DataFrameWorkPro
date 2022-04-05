package TestProject.DataFrameWorkPro;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import TestProject.DataFrameWorkPro.actions.ElementActions;

public class Assertions extends ElementActions {

	 public SoftAssert feSoftAssert = new SoftAssert();
	
	    public void logTCStatus() {
	    	
	        feSoftAssert.assertAll();
	    }
	
	  public void assertElementNotExist(By locator) {
	        try {
	            assert getElement(locator).isDisplayed();
	            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist");
	            Assert.fail();
	        } catch (Exception e) {
	            System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist.");
	        }
	    }

	  
	  /////////////////////////////
    
	public static void assertElementText(By locator, String text) {
		
        String elementText = "";
        
        try {
            elementText = getElement(locator).getText();
            assertEquals(elementText, text);
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does match expected text successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Assertions passed - Actual Text: [" + elementText + "] does not match expected text successfully.");
            Assert.fail();
        }
    }
}
