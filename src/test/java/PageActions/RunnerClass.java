package PageActions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BaseClass1;
import Hooks.Hooks;
import PageObject.Login;

public class RunnerClass extends BaseClass1  {
	
	
	@Test(priority=1)
	public void aloginMethod() throws Throwable {
		System.out.println("came to login");
		login.loginUser();
		login.loginVerify();
		login.registerAPatient();
		System.out.println("exit to login");
	}
	
	@Test(priority=2)
	public void dataFilling() throws Throwable {
		System.out.println("came to login");
	 rp.name();
	 rp.gender();
	 rp.birtDate();
	 rp.address();
	 rp.phoneNumber();
	 rp.verify();
	 rp.confirmAndVerify();
	}
	
	@Test(priority=3)
	public void patientDetails() throws Throwable {
		pd.ageVerify();
		pd.startAndConfrim();
		pd.attachment();
		pd.toastVerify();
	}
	
	@Test(priority=4, enabled=false)
	public void patient() throws InterruptedException {
		System.out.println("test 4");
		rp.pateientBack();
	}
	@Parameters({"browser"})
	@BeforeClass
	public void startUp(@Optional("Edge")String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		System.out.println("=========Launching Browser=========");
	}
	
	@AfterClass
	public void tearDown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShots"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		
		driver.quit();
		System.out.println("========Browser Killed======");
	}

}
