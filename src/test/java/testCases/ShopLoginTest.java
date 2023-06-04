package testCases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.collect.Table.Cell;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.ShopLoginPage;
import utilities.ExcelReader;
import base.BaseClass;

@Listeners(resources.Listeners.class)
		
public class ShopLoginTest extends BaseClass {
	
	@Test(dataProvider="getData")
	public void loginTest(String username, String password)  {
		
	HomePage hp=new HomePage(driver);
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='toggle']")));
	hp.getToggle().click();
	log.info("Clicked on toggle button on Home Page");
	JavascriptExecutor jse = (JavascriptExecutor)(driver);
	jse.executeScript("arguments[0].scrollIntoView()", hp.getLoginPortalLink()); 
	hp.getLoginPortalLink().click();
	log.info("Clicked on Login Portal Page Link"); 
	//Assert.fail();

	ShopLoginPage slogin=new ShopLoginPage(driver);  
	System.out.println(username);	
	System.out.println(password);slogin.enter_Username().sendKeys(username);
   slogin.enter_Password().sendKeys(password);
	slogin.login_btn(); 
//	String alerttxt=driver.switchTo().alert().getText();
//	if(alerttxt.equals( "validation succded")){
		driver.switchTo().alert().accept();
	
	
//	}
//	else {
	//	Assert.fail();
//	}
	
	}
@DataProvider
public  Object [][] getData() throws IOException
	{
	if(excel ==null) {
	 String path=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\credentials.xlsx";	   
	   excel=new ExcelReader(path);
	}
	String sheetName="loginTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		//Object
		Object[][] data=new Object[rows-1][cols];
		for(int rowNum=2; rowNum<=rows; rowNum++ ) {
			for(int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*	@Test(dataProviderClass=ExcelReader.class, dataProvider="dp")
	public void ShopLoginTest(String email, String password) {

	    HomePage hp=new HomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='toggle']")));
		hp.getToggle().click();
		log.info("Clicked on toggle button on Home Page");
		JavascriptExecutor jse = (JavascriptExecutor)(driver);
		jse.executeScript("arguments[0].scrollIntoView()", hp.getLoginPortalLink()); 
		hp.getLoginPortalLink().click();
		log.info("Clicked on Login Portal Page Link");
		//Assert.fail();
		ShopLoginPage slogin=new ShopLoginPage(driver);
		slogin.enter_Username().sendKeys(email);
		slogin.enter_Password().sendKeys(password);
		slogin.login_btn();
		}
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = "ShopLoginTest";//m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	

		
	}*/



