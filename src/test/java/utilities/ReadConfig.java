package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties config;  FileInputStream fis;
	public ReadConfig()
	{
		config=new Properties();
		File src=new File(System.getProperty("user.dir")+"./Configuration/config.properties");

		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	    try {
			config.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
    public String getBrowser() {
    String browser=config.getProperty("browser");
    return browser;
    	
    }
	public String getUrl() {
	String url=config.getProperty("url");
	return url;
}
	
}
