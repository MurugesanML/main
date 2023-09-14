package GenericLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseClass.BaseClass1;

public class JavaUtility {

	public void dropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public int ageCompare(int year, int month, int day) {
		LocalDate dob = LocalDate.of(year, month , day);  
		LocalDate curDate = LocalDate.now();  
		Period period = Period.between(dob, curDate);  
		return period.getYears();
	}
	
	public int monthExtractor(String monthName) {
		int value = Month.valueOf(monthName.toUpperCase()).getValue();
		return value;
		
	}
	
    public  void setClipboardData(String string) {
           StringSelection stringSelection = new StringSelection(string);
           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }

    public void uploadFile(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(2000);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

	
	
}
