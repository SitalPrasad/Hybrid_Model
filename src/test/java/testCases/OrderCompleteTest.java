package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.ShopHomePage;

public class OrderCompleteTest extends BaseClass {
	
	@Test
	public void OrderTest() {
		driver.get(url);
		HomePage hp=new HomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='toggle']")));
		hp.getToggle().click();
		
		
	ShopHomePage shop=new ShopHomePage(driver);
	
	shop.getProdOne().click();
	}
}
