package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ViewInformationPage {
	
	WebDriver driver;
	By textDisplayed = By.xpath("//div[@class='panel-title']");
		
	public ViewInformationPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void verifyTextDisplayed(String expectedText1, String expectedText2){
		SoftAssert sassert=new SoftAssert();
		String actualText=driver.findElement(textDisplayed).getText().toString();
		String[] splitTexts=actualText.split("\\R+");
		sassert.assertEquals(expectedText1.trim(), splitTexts[0].trim(), "Actual Text in paragraph 1 did not match Expected Text: ");		
		sassert.assertEquals(expectedText2.trim(), splitTexts[1].trim(), "Actual Text in paragraph 2 did not match Expected Text: ");
		sassert.assertAll();
	}
}
