package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import resources.Listeners;
import uk.co.automationtesting.Utilities.ExcelReader;
import uk.co.automationtesting.Utilities.ReadConfig;
import uk.co.automationtesting.Utilities.Screenshot;

public class BaseClass  {
	public static WebDriver driver;
	public  ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.getUrl();
	public String br=readconfig.getBrowser();
	public String email=readconfig.getEmail();
	public String password=readconfig.getPassword();
  	public static Logger log=LogManager.getLogger();//log4J2.properties
  //	public static ExcelReader excel=new ExcelReader(
  //			System.getProperty("user.dir")+"\\src\\main\\java\\resources\\credentials.xlsx");
@BeforeTest
 public void setup() {
	
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
