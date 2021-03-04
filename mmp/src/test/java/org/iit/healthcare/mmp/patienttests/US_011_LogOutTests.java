package org.iit.healthcare.mmp.patienttests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_011_LogOutTests extends BaseClass{

	String actualTitle;
	String expectedTitle;
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle"})
	@Test(description="valid scenario: correct page title")
	public void testLogOutFunction_valid(String uname, String pword, String moduleName, String expectedModulePageTitle){
		
		launchAppURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		//calling login method
		LoginPage lpage=new LoginPage(driver);
		actualTitle=lpage.login(uname,pword);
		expectedTitle = "ria1";
		Assert.assertEquals(actualTitle, expectedTitle);

		//Calling navigate to module method
		HelperClass helperObj=new HelperClass(driver);
		actualTitle=helperObj.navigateToAModule(moduleName,expectedModulePageTitle);
		Assert.assertEquals(actualTitle, expectedModulePageTitle, "Expected page title of the module did not match");
		
	}
	
	@Parameters({ "uname", "pword", "moduleName", "negativeExpectedModulePageTitle"})
	@Test(description="invalid scenario: wrong page title")
	public void testLogOutFunction_invalid(String uname, String pword, String moduleName, String expectedModulePageTitle){
		
		launchAppURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		//calling login method
		LoginPage lpage=new LoginPage(driver);
		actualTitle=lpage.login(uname,pword);
		expectedTitle = "ria1";
		Assert.assertEquals(actualTitle, expectedTitle);

		//Calling navigate to module method
		HelperClass helperObj=new HelperClass(driver);
		actualTitle=helperObj.navigateToAModule(moduleName,expectedModulePageTitle);
		Assert.assertEquals(actualTitle, expectedModulePageTitle, "Expected page title of the module did not match");
		
	}
}
