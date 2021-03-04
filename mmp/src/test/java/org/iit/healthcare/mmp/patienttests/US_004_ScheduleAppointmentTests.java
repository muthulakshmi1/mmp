package org.iit.healthcare.mmp.patienttests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_004_ScheduleAppointmentTests extends BaseClass{

	String actualTitle;
	String expectedTitle;
	
	@Parameters({ "uname", "pword", "moduleName", "expectedModulePageTitle", "doctorName" })
	@Test
	public void scheduleAppointmentTest(String uname, String pword, String moduleName, String expectedModulePageTitle, String doctorName) {

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

		//Calling scheduleAppointment method
		ScheduleAppointmentPage spage=new ScheduleAppointmentPage(driver);
		spage.scheduleAppointment(doctorName);
		
		// Calling validateScheduleAppDatainHomePage method
		boolean result=spage.validateScheduleAppDatainHomePage();
		Assert.assertTrue(result, "Validation failed: Homepage values");

		// Validate the values in Schedule Appointment -->Current Appointments
		result=spage.validateScheduleAppDatainAppointmentPage();
		Assert.assertTrue(result, "validation failed: Schedule Appointment-->Current Appointment");
	}
}
