package GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	 public String getPropertyData(String keysvalue) throws Throwable {
	        Properties p = new Properties();
	        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testData.properties");
	        p.load(fis);
	        return p.getProperty(keysvalue);
	    }

	
}
