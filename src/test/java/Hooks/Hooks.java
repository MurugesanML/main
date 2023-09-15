package Hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import BaseClass.BaseClass1;

public class Hooks{
	
//	String browserName="Edge";
//	@Parameters("browser")
//	@BeforeClass
//	public void startUp() {
//		
//		if(browserName.equalsIgnoreCase("Chrome")) {
//			driver= new ChromeDriver();
//		}else if(browserName.equalsIgnoreCase("Edge")) {
//			driver= new EdgeDriver();
//		}
//		driver.manage().window().maximize();
//		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
//		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//	}
//	
//	@AfterClass
//	public void tearDown(ITestResult result) throws IOException {
//		if(ITestResult.FAILURE==result.getStatus()) {
//			try {
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			File source=ts.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShots"));
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			}
//		
//		driver.quit();
//	}

}
