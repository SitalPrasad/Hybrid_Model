package uk.co.automationtesting.Utilities;

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
		File src=new File(System.getProperty("user.dir")+"\\src/main/java\\resources\\config.properties");
	//    FileInputStream fis;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	public String getEmail() {
		String email=config.getProperty("email");
		return email;
	}
	public String getPassword() {
		String password=config.getProperty("password");
		return password;
	}
}
