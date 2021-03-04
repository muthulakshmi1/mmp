package org.iit.healthcare.mmp.admintests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.adminmodule.pages.AdminLoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_001_Admin_LoginTests extends BaseClass{

	String actualTitle;
	String expectedTitle;
	
	@Parameters({ "uname", "pword" })
	@Test
	public void loginToAdminTest(String uname, String pword) {

		launchAppURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		
		//calling login method
		AdminLoginPage lpage=new AdminLoginPage(driver);
		actualTitle=lpage.login(uname,pword);
		expectedTitle = "home";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
