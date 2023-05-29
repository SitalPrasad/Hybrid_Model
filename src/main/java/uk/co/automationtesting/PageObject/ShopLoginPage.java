package uk.co.automationtesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import uk.co.automationtesting.PageObject.*;

public class ShopLoginPage extends BaseClass{
	public WebDriver driver;
	public ShopLoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By user=By.xpath("//input[@id='login_text']");
	By pass=By.xpath("//input[@id='login_password']");
	By loginbtn=By.xpath("//button[@id='login_btn']");
	
	public WebElement enter_Username() {
		return driver.findElement(user);
	}
	public WebElement enter_Password() {
		return driver.findElement(pass);
	}
	public void login_btn() {
		driver.findElement(loginbtn).click();
	}
}
