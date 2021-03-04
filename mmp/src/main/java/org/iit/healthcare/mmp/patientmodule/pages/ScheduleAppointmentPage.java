package org.iit.healthcare.mmp.patientmodule.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.iit.healthcare.mmp.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {
	
	private HashMap<String, String> sAppointmentHMap;
	private SimpleDateFormat sdf;
	private String formattedHMapDate;
	
	WebDriver driver;
	By createNewAppointmentButton = By.xpath("//input[@value='Create new appointment']");
	By datePicker = By.id("datepicker");
	By datePickerYear = By.className("ui-datepicker-year");
	By datePickerNext = By.xpath("//a[contains(@class,'ui-datepicker-next')]");
	By datePickerMonth = By.className("ui-datepicker-month");
	By datePickerDateCal = By.className("ui-datepicker-calendar");
	By datePickerDateCalTR = By.tagName("tr");
	By datePickerDateCalTD = By.tagName("td");
	By timeMenu = By.id("time");
	By continueBtn = By.xpath("//button[normalize-space()='Continue']");
	By symptomsTextArea = By.id("sym");
	By submitSymptomsBtn = By.xpath("//input[@value='Submit']");
	By homePageAppointmentTable = By.xpath("//table[@class='table']/tbody/tr[1]/td");
	By ScheduleAppointmentPagecurrentAppointments = By.xpath("//div[@class='list-group list-statistics']/child::a");
	
	public ScheduleAppointmentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Select provider and book appointment 
	//Choose date using date picker
	//Assign appointment details to hash map
	public HashMap<String, String> scheduleAppointment(String doctorName){
		driver.findElement(createNewAppointmentButton).click();
		// Select a provider and book an appointment and assign values to hashmap
		sAppointmentHMap = new HashMap<String, String>();
		sAppointmentHMap.put("doctor", doctorName);
		driver.findElement(
				By.xpath("//li/h4[normalize-space()='Dr." + doctorName + "']/ancestor::ul/following-sibling::button"))
				.click();

		// Select date using date picker

		String formattedRandomDate=Utility.getRandomFutureDate();
		
		

		String date, month, year;
		String caldt, calmonth, calyear;

		// Spliting the String into String Array

		String dateArray[] = formattedRandomDate.split(" ");
		date = dateArray[1];
		month = dateArray[0];
		year = dateArray[2];

		// switch frame and select date picker
		driver.switchTo().frame("myframe");
		driver.findElement(datePicker).click();

		sAppointmentHMap.put("date", formattedRandomDate);

		calyear = driver.findElement(datePickerYear).getText();

		// Select the year

		while (!calyear.equals(year)) {
			driver.findElement(datePickerNext).click();
			calyear = driver.findElement(datePickerYear).getText();
			System.out.println("The Displayed Year::" + calyear);
		}

		calmonth = driver.findElement(datePickerMonth).getText();

		// Select the Month

		while (!calmonth.equalsIgnoreCase(month)) {
			driver.findElement(datePickerNext).click();
			calmonth = driver.findElement(datePickerMonth).getText();
			System.out.println("The Displayed Month::" + calmonth);
		}

		WebElement dateCal = driver.findElement(datePickerDateCal);

		// Select the Date

		List<WebElement> rows, cols;
		rows = dateCal.findElements(datePickerDateCalTR);
		System.out.println("Random Date: " + date);
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(datePickerDateCalTD);
			for (int k = 0; k < cols.size(); k++) {
				caldt = cols.get(k).getText();
				if (caldt.equals(date)) {
					System.out.println("calendar date: "+cols.get(k).getText());
					cols.get(k).click();
					break;
				}
			}
		}

		// Select time

		Select select = new Select(driver.findElement(timeMenu));
		String timeOfAppointment = "11Am";
		sAppointmentHMap.put("time", timeOfAppointment);
		select.selectByVisibleText("11Am");

		// click on continue button
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement continueButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(continueBtn));
		continueButton.click();

		// Enter the symptoms and submit
		String symptoms = "Wellness Visit";
		sAppointmentHMap.put("symptoms", symptoms);
		driver.findElement(symptomsTextArea).sendKeys(symptoms);

		driver.findElement(submitSymptomsBtn).click();
		
		return sAppointmentHMap;
	}

	// Validate the values in home page
	public boolean validateScheduleAppDatainHomePage(){
		List<WebElement> tdList = driver.findElements(homePageAppointmentTable);
		boolean result = false;
		
		System.out.println("Homepage date: " + tdList.get(0).getText()+" hashmap date: "+sAppointmentHMap.get("date"));
		
		Date hMapDate=null;
		try {
			hMapDate = new SimpleDateFormat("MMMM dd yyyy").parse(sAppointmentHMap.get("date"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sdf = new SimpleDateFormat("MM/dd/yyyy");
		formattedHMapDate=sdf.format(hMapDate);
		System.out.println("HMap date: " + hMapDate+" Formatted Date: "+formattedHMapDate);
		if (formattedHMapDate.equals(tdList.get(0).getText()) && sAppointmentHMap.get("time").equals(tdList.get(1).getText())
				&& sAppointmentHMap.get("symptoms").equals(tdList.get(2).getText())
				&& sAppointmentHMap.get("doctor").equals(tdList.get(3).getText())) {
			result = true;
		}
		return result;
	}
	
	// Validate the values in Schedule Appointment -->Current Appointments
	public boolean validateScheduleAppDatainAppointmentPage(){
		String moduleName = "Schedule Appointment";
		boolean result=false;
		driver.findElement(By.xpath("//span[contains(text(), '" + moduleName + "')]")).click();
		String dte = (driver.findElement(By.xpath("//div[@class='panel panel-info']/descendant::h3"))).getText();
		List<WebElement> currentAppointmentData = driver
				.findElements(ScheduleAppointmentPagecurrentAppointments);
		
		String[] time = currentAppointmentData.get(0).getText().split(":");
		String[] doctor = currentAppointmentData.get(1).getText().split(":");
		String[] sym = currentAppointmentData.get(2).getText().split(":");
		
		if (formattedHMapDate.equals(dte) && sAppointmentHMap.get("time").equals(time[1].trim())
				&& sAppointmentHMap.get("doctor").equals(doctor[1].trim())
				&& sAppointmentHMap.get("symptoms").equals(sym[1].trim())) {
			result = true;
		}	
		return result;
	}

}
