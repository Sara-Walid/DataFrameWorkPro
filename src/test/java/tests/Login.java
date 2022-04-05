package tests;

import org.testng.annotations.Test;

import TestProject.DataFrameWorkPro.TestBase;

public class Login extends TestBase {

	@Test
	 public void invokedbrowser() {
		
		 try {
			driver.get("http://automationpractice.com/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	 }
}

