package PageObject;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.auto.common.Visibility;

import BaseClass.BaseClass1;

public class PatientDetails extends BaseClass1 {
	
	public static final By ageText=By.xpath("(//div[@class='gender-age col-auto']/span)[2]");
	public static final By startVist=By.xpath("(//a[@id='org.openmrs.module.coreapps.createVisit']/div/div)[2]");
	public static final By confrimButton=By.xpath("//button[@id='start-visit-with-visittype-confirm']");
	public static final By attachments=By.xpath("//a[@id='attachments.attachments.visitActions.default']");
	public static final By fileUpload=By.xpath("//input[@name='OWASP-CSRFTOKEN']");
	public static final By fileUpload1=By.xpath("//div[@class='dz-default dz-message ng-binding']");
	public static final By caption=By.xpath("//textarea[@placeholder='Enter a caption']");
	public static final By uploadbutton=By.xpath("//button[@class='confirm ng-binding']");
	public static final By toastMsg=By.xpath("//div[@class='toast-item-close']/following-sibling::p");

	
	public void ageVerify() throws Throwable {
		String text = driver.findElement(ageText).getText();
		String[] spilt=text.split(" ");
		String actualAge=spilt[0];
		int actualAge1=Integer.parseInt(actualAge);
		int year=Integer.parseInt(propFile.getPropertyData("year"));
		int month=jUtil.monthExtractor(propFile.getPropertyData("month"));
		int day=Integer.parseInt(propFile.getPropertyData("Birthday"));
		int expectedAge = jUtil.ageCompare(year,month , day);
		Assert.assertEquals(actualAge1, expectedAge);
	}
	
	public void startAndConfrim() {
		driver.findElement(startVist).click();
		driver.findElement(confrimButton).click();
		
	}
	
	
	public void attachment() throws Throwable {
		driver.findElement(attachments).click();
		Thread.sleep(5000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\VIJILALI\\eclipse-workspace\\KNila\\src\\test\\resources\\Patient Details.txt");
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		driver.findElement(fileUpload1).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
//		driver.findElement(By.xpath("//input[@name='OWASP-CSRFTOKEN']")).sendKeys("C:\\Users\\VIJILALI\\eclipse-workspace\\KNila\\src\\test\\resources\\Patient Details.txt");
		Thread.sleep(5000);
		driver.findElement(caption).sendKeys(propFile.getPropertyData("givenName"));
		driver.findElement(uploadbutton).click();
	
	}
	
	public void toastVerify() throws InterruptedException {
		Thread.sleep(1000);
		String toastMsgs = driver.findElement(toastMsg).getText();
		System.out.println(toastMsgs);
		Assert.assertEquals(toastMsgs, "The attachment was successfully uploaded.");
		System.out.println("verified toastMsg");
	}
}
