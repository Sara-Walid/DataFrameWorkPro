package testRunner;

import TestProject.DataFrameWorkPro.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features"}
,glue = {"stepDef","pages", "utilities"}
,tags = ("@test and @FERegression")
,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class FETestRunner extends TestBase {
	
}