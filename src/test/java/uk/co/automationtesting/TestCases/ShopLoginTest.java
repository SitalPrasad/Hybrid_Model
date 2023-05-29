package uk.co.automationtesting.TestCases;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import base.BaseClass;
import uk.co.automationtesting.PageObject.HomePage;
import uk.co.automationtesting.PageObject.ShopLoginPage;
//import uk.co.automationtesting.Utilities.ExcelReader;
@Listeners(resources.Listeners.class)

public class ShopLoginTest extends BaseClass {
	@Test
	public void loginTest() throws IOException {
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
	FileInputStream workbookLocation = new FileInputStream(System.getProperty("user.dir") + 
			"\\src\\main\\java\\resources\\credentials.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	/****************************************************************************
	 * Excel Spreadsheet Layout 
	 * 
	 * |Row=0 -->| Email Address (Cell 0) Password (Cell 1) *
	 * -------------------------------------------------------------------- 
	 * |Row=1 -->| test@test.com (Cell 0) test123 (Cell 1) 
	 * |Row=2 -->| john.smith@test.com (Cell 0) test123 (Cell 1)
	 * |Row=3 -->| lucy.jones@test.com (Cell 0) catlover1 (Cell 1) 
	 * |Row=4 -->| martin.brian@test.com (Cell 0) ilovepasta5 (Cell 1) 
	 ****************************************************************************/
	
	Row row1 = sheet.getRow(1);
	org.apache.poi.ss.usermodel.Cell cellR1C0 = row1.getCell(0);
    org.apache.poi.ss.usermodel.Cell cellR1C1 = row1.getCell(1);
	
	String emailRow1 = cellR1C0.toString();
	String passwordRow1 = cellR1C1.toString();
	
	System.out.println(emailRow1);
	System.out.println(passwordRow1);

	ShopLoginPage slogin=new ShopLoginPage(driver);
	slogin.enter_Username().sendKeys(emailRow1);
	slogin.enter_Password().sendKeys(passwordRow1);
	slogin.login_btn();
}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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



