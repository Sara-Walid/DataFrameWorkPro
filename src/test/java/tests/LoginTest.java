package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.*;

import TestProject.DataFrameWorkPro.Screenshots;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

@Listeners({ExtentITestListenerClassAdapter.class})
public class LoginTest extends LoginPage{
	
	HomePage homePage = new HomePage();
	MyAccountPage myAccountPage = new MyAccountPage();
	Screenshots screenshots = new Screenshots();
	
	
	
	@Test
	public void login() {
		try {
			homePage.openAutomationPractice();
			homePage.clickSignIn();
			typeEmail("zf1adwvvz@moakt.cc");
			typePassword("123abc");
			clickSubmit();
			myAccountPage.assertMyAccountTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tackeScreenShot() { 
		screenshots.captureScreenShot("testScreenshot");
	}
}

