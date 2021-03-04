package org.iit.healthcare.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

	WebDriver driver;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
	}

	//login to the application	
	public String login(String uname, String password){
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("admin")).click();
		String actual = driver.getTitle();
		return actual;
	}
}
