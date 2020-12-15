package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import generalUtilities.ConfigPropertiesFile;
import pageObjects.LoginPageObject;

public class TC002__Loginpage {
WebDriver driver;
//TC001_GetUrl gurl;
public LoginPageObject lpo;
ConfigPropertiesFile conProp;
BaseClass bc=new BaseClass();
public TC002__Loginpage(WebDriver driver)
{	this.driver=driver;
 //gurl=new TC001_GetUrl();
// this.driver=gurl.driver;
 lpo= new LoginPageObject(driver);
 conProp=new ConfigPropertiesFile();
}	
	@Test
	public void loginpage() throws IOException
	{
		//gurl.launchAmazonApp();
		lpo.setPhoneNum(conProp.readPropFile("PhoneNumber"));//entering phone number
		bc.logger.info("enter phoneNumber/Mail");
		lpo.phoneNumbSubmitButton();//clicking on login button
		bc.logger.info("click on login button");
		/*
		 * driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7799181822")
		 * ; driver.findElement(By.xpath("//input[@type='submit']")).click();
		 */
	}
}
