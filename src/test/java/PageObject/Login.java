package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.BaseClass1;
import GenericLibrary.PropertyFile;

public class Login extends BaseClass1 {
	
	public static final By userName=By.id("username");
	public static final By passWord=By.id("password");
	public static final By OutPatient=By.id("Outpatient Clinic");
	public static final By loginButton=By.id("loginButton");
	public static final By logutbutton=By.xpath("//li[@class='nav-item logout']/a");
	public static final By registerAPatient=By.xpath("//i[@class='icon-user']");
	

	public void loginUser() throws Throwable {
		driver.findElement(userName).sendKeys(propFile.getPropertyData("username"));
		driver.findElement(passWord).sendKeys(propFile.getPropertyData("password"));
		driver.findElement(OutPatient).click();
		driver.findElement(loginButton).click();
	}
	
	public void loginVerify() {
		String logOutMsg = driver.findElement(logutbutton).getText();
//		System.out.println(logOutMsg);
		Assert.assertEquals(logOutMsg, "Logout");
		System.out.println("User Navigated to Login Page SucessFully");
	}
	
	public void registerAPatient() {
		driver.findElement(registerAPatient).click();
	}

}
