package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import generalUtilities.ConfigPropertiesFile;
import pageObjects.PageObjectPasswordPage;

public class TC003_passwordpage 
	{
	//TC002__Loginpage lpg;
	WebDriver driver;
	PageObjectPasswordPage popp;
	ConfigPropertiesFile conProp;
	BaseClass bc=new BaseClass();
	
	public TC003_passwordpage(WebDriver driver)
	
	{this.driver=driver;
	// lpg=new TC002__Loginpage();
	 //driver=lpg.driver;
	  popp=new PageObjectPasswordPage(driver);
	  conProp=new ConfigPropertiesFile();
	}
	@Test
	public void passwordPage() throws IOException
{
	//lpg.loginpage();
	popp.Enterpassword(conProp.readPropFile("Password"));
	bc.logger.info("Enter Password");
	popp.selectCheckBoxPasswordPage();
	bc.logger.info("select CheckBox");
	popp.passwordSubmitButton();
	bc.logger.info("click on login button");
	/*
	 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
	 * "Sal93nia@"); driver.findElement(By.xpath("//input[@tabindex='4']")).click();
	 * driver.findElement(By.xpath("//input[@type='submit']")).click();
	 */
	
}
}
