package org.iit.healthcare.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	
	WebDriver driver;
	
	public HelperClass(WebDriver driver){
		this.driver=driver;	
	}
	
	//navigate to a module
	public String navigateToAModule(String moduleName,String expectedModulePageTitle){
		driver.findElement(By.xpath("//span[contains(text(), '" + moduleName + "')]")).click();
		String actualTitle = driver.getTitle();
		return actualTitle;
	}	
}
