package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.tools.Generate.CustomLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ReadConfig;
import utilities.Screenshot;

public class BaseClass  {
	public static WebDriver driver;
	public  ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.getUrl();
	public String br=readconfig.getBrowser();
	
  	public static Logger log=LogManager.getLogger();
    public static ExcelReader excel;
@BeforeTest
 public void setup() {
	log = LogManager.getLogger();
	
	log.info("Inside setup method");
	 if(br.equals("chrome")) { 
	log.info("Going to launch Chrome Browser");
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
	 driver.get(url);
 }
public static String takeScreenShot(WebDriver driver) throws IOException {

	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path; String date1=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	path = System.getProperty("user.dir")+"\\Screenshot\\"+date1  +".png";
    File destFile=new File(path);
	FileUtils.copyFile(srcFile, destFile);
	return  path;
}

 @AfterTest
 public void tearDown() {
	//driver.close();
	driver=null;
 }
}