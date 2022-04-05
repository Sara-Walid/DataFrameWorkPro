package TestProject.DataFrameWorkPro;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import TestProject.DataFrameWorkPro.actions.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase{
	
    BrowserActions browserActions = new BrowserActions();

    @After(order = 10, value = "@FERegression")
    
    public void takeScreenshot(Scenario scenario) {
    	
        byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }
}