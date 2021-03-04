package org.iit.healthcare.mmp.patienttests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ViewInformationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_005_ViewInformationTests extends BaseClass {

	String actualTitle;
	String expectedTitle;
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle"})
	@Test(description="Matching expected and actual texts in the paragaraphs")
	public void testViewInformation(String uname, String pword, String moduleName, String expectedModulePageTitle) throws Exception{

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
		
		//Positive test
		ViewInformationPage viewInfoPage = new ViewInformationPage(driver);
		String expectedText1="Manage My Patient (MMP) is a medical practice management solution that boosts productivity by automating the day-to-day tasks that can slow an office manager down. Central delivers much more than medical billing software. Sure, it has the tools to help generate cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines your workflow to deliver seamless handoffs across departments.";
		String expectedText2="Manage My Patient (MMP) becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";
		viewInfoPage.verifyTextDisplayed(expectedText1, expectedText2);
		Thread.sleep(3000);
	}
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle"})
	@Test(description="Mismatched first paragraph")
	public void testViewInformation_invalid1(String uname, String pword, String moduleName, String expectedModulePageTitle) throws Exception{
		
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

		//Mismatched first paragraph
		ViewInformationPage viewInfoPage = new ViewInformationPage(driver);
		String expectedText1="Manage My Patient is a medical practice management solution that boosts productivity by automating the day-to-day tasks that can slow an office manager down. Central delivers much more than medical billing software. Sure, it has the tools to help generate cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines your workflow to deliver seamless handoffs across departments.";
		String expectedText2="Manage My Patient (MMP) becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";
		System.out.println("Mismatched first paragraph");
		viewInfoPage.verifyTextDisplayed(expectedText1, expectedText2);
		Thread.sleep(3000);		
	}
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle"})
	@Test(description="Mismatched second paragraph")
	public void testViewInformation_invalid2(String uname, String pword, String moduleName, String expectedModulePageTitle) throws Exception{
		
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

		//Mismatched second paragraph
		ViewInformationPage viewInfoPage = new ViewInformationPage(driver);
		String expectedText1="Manage My Patient (MMP) is a medical practice management solution that boosts productivity by automating the day-to-day tasks that can slow an office manager down. Central delivers much more than medical billing software. Sure, it has the tools to help generate cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines your workflow to deliver seamless handoffs across departments.";
		String expectedText2="Manage My Patient becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";
		System.out.println("Mismatched second paragraph");
		viewInfoPage.verifyTextDisplayed(expectedText1, expectedText2);
		Thread.sleep(3000);		
	}
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle"})
	@Test(description="Mismatched both paragraph")
	public void testViewInformation_invalid3(String uname, String pword, String moduleName, String expectedModulePageTitle) throws Exception{
		
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

		//Mismatched Both Paragraph
		ViewInformationPage viewInfoPage = new ViewInformationPage(driver);
		String expectedText1="Manage My Patient is a medical practice management solution that boosts productivity by automating the day-to-day tasks that can slow an office manager down. Central delivers much more than medical billing software. Sure, it has the tools to help generate cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines your workflow to deliver seamless handoffs across departments.";
		String expectedText2="Manage My Patient becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";
		System.out.println("Mismatched both paragraph");
		viewInfoPage.verifyTextDisplayed(expectedText1, expectedText2);
		Thread.sleep(3000);		
	}
}
