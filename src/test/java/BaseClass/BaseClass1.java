package BaseClass;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFile;
import Hooks.Hooks;
import PageActions.RunnerClass;
import PageObject.Login;
import PageObject.PatientDetails;
import PageObject.RegisterPatient;

public class BaseClass1 {

	public static WebDriver driver;
	
	public static PropertyFile propFile= new PropertyFile();
	public static JavaUtility jUtil= new JavaUtility();
	public static Login login = new Login();
	public static RegisterPatient rp = new RegisterPatient();
	public static PatientDetails pd = new PatientDetails();
	
	
	
}
