package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot extends BaseClass{
		
	public void takeScreenShot(String name) throws IOException {
		//this.ldriver=driver;
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("./Screenshots"+timestamp() + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}
public String timestamp() {
	return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
}
}

