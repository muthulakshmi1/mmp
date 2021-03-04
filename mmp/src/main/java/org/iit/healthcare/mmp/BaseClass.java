package org.iit.healthcare.mmp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;

	//initiate WebDriver
	@BeforeClass
	public void initiateDriver(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/*@BeforeMethod
	public void launchApp(){
		launchAppURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	}*/
	
	@AfterTest
	public void closeDriver(){
		driver.close();
	}
	
		
	//launch application by passing url as parameter
	public void launchAppURL(String url){
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
