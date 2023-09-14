package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseClass.BaseClass1;
import GenericLibrary.JavaUtility;

public class RegisterPatient extends BaseClass1 {

	
	public static final By given=By.name("givenName");//fr9259-field
	public static final By familyName=By.name("familyName");
	public static final By forwardIcon=By.xpath("//icon[@class='fas fa-chevron-right']");
//	public static final By gender=By.xpath("//option[text()='Male']");
	public static final By gender=By.id("gender-field");
	public static final By day=By.id("birthdateDay-field");
//	public static final By month=By.id("birthdateMonth-field");
	public static final By month=By.name("birthdateMonth");
	public static final By year=By.id("birthdateYear-field");
	public static final By address1=By.id("address1");
	public static final By address2=By.id("address2");
	public static final By city=By.id("cityVillage");
	public static final By state=By.id("stateProvince");
	public static final By country=By.id("country");
	public static final By postal=By.id("postalCode");
	public static final By phoneNo=By.name("phoneNumber");
	public static final By textPath=By.xpath("//div[@id='dataCanvas']/div/p");
	public static final By confirmButton=By.id("submit");
	public static final By createdText=By.xpath("//div[@class='toast-item-close']/following-sibling::p");
	public static final By redirectToPatient=By.xpath("//a[@href='/openmrs/coreapps/clinicianfacing/patient.page?patientId=550&']");
	public static final By attachment=By.xpath("//div[@class='ng-binding ng-scope']/i");
	public static final By attachementUploaded=By.xpath("//div[@class='tag ng-binding ng-scope']");
	
	
	
	
	
	public void name() throws Throwable {
		
		driver.findElement(given).sendKeys(propFile.getPropertyData("givenName"));
		driver.findElement(familyName).sendKeys(propFile.getPropertyData("FamilyName"));
		driver.findElement(forwardIcon).click();
	
	}
	public void gender() throws Throwable {
	
		jUtil.dropDown(driver.findElement(gender), propFile.getPropertyData("gender"));
//		driver.findElement(gender).click();
		driver.findElement(forwardIcon).click();
	}
	public void birtDate() throws Throwable {
		driver.findElement(day).sendKeys(propFile.getPropertyData("Birthday"));	
//		driver.findElement(month).click();
		jUtil.dropDown(driver.findElement(month), propFile.getPropertyData("month"));
		driver.findElement(year).sendKeys(propFile.getPropertyData("year"));	
		driver.findElement(forwardIcon).click();
	}
	
	public void address() throws Throwable {
		driver.findElement(address1).sendKeys(propFile.getPropertyData("address1"));
		driver.findElement(address2).sendKeys(propFile.getPropertyData("address2"));
		driver.findElement(city).sendKeys(propFile.getPropertyData("city"));
		driver.findElement(state).sendKeys(propFile.getPropertyData("state"));
		driver.findElement(country).sendKeys(propFile.getPropertyData("country"));
		driver.findElement(postal).sendKeys(propFile.getPropertyData("pincode"));
		driver.findElement(forwardIcon).click();
	}
	public void phoneNumber() throws Throwable {
		driver.findElement(phoneNo).sendKeys(propFile.getPropertyData("phone"));
		driver.findElement(forwardIcon).click();
		driver.findElement(forwardIcon).click();
		
	}
	public void verify() throws Throwable {
		System.out.println("entered Verify");
		List<WebElement> findElements = driver.findElements(textPath);
		List<String> list= new ArrayList();
		for (int i = 0; i < findElements.size(); i++) {
			WebElement temp = findElements.get(i);
			String text = temp.getText();
			list.add(text);
		}
		System.out.println("values Extracted");
		Assert.assertEquals(list.get(0), "Name: "+(propFile.getPropertyData("givenName")+", "+(propFile.getPropertyData("FamilyName"))));
		Assert.assertEquals(list.get(1), "Gender: "+(propFile.getPropertyData("gender")));
		Assert.assertEquals(list.get(2), "Birthdate: "+(propFile.getPropertyData("Birthday")+", "+(propFile.getPropertyData("month")+", "+propFile.getPropertyData("year"))));
		Assert.assertEquals(list.get(3), "Address: "+(propFile.getPropertyData("address1")+", "+(propFile.getPropertyData("address2")+", "+propFile.getPropertyData("city")+", "+propFile.getPropertyData("state")+", "+propFile.getPropertyData("country")+", "+propFile.getPropertyData("pincode"))));
		Assert.assertEquals(list.get(4), "Phone Number: "+(propFile.getPropertyData("phone")));
		System.out.println("Assertion Completed");
		
	}
	
	public void confirmAndVerify() throws Throwable {
		driver.findElement(confirmButton).click();
//		 String text = driver.findElement(createdText).getText();
//		 System.out.println(text);
//		 Assert.assertEquals(text, "Created Patient Record: "+(propFile.getPropertyData("givenName")+" "+(propFile.getPropertyData("FamilyName"))));
	}
	
	public void pateientBack() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/openmrs/coreapps/clinicianfacing/patient.page?patientId=550&']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='ng-binding ng-scope']/i"));
		int temp=findElements.size();
		String present = null;
		if(temp>0) {
			present="Present";
		}
		Assert.assertEquals(present, "Present");
		String uploadedMsg = driver.findElement(By.xpath("//div[@class='tag ng-binding ng-scope']")).getText();
		Assert.assertEquals(uploadedMsg, "Attachment Upload");
		
	}
	 
	
}
