package GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	 public String getPropertyData(String keysvalue) throws Throwable {
	        Properties p = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\VIJILALI\\eclipse-workspace\\KNila\\src\\test\\resources\\testData.properties");
	        p.load(fis);
	        return p.getProperty(keysvalue);
	    }

	
}
