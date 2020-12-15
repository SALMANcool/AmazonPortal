package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import generalUtilities.ConfigPropertiesFile;
import pageObjects.PageObjectProductPage;

public class TC004_ProductSearch {
	WebDriver driver;
	//TC003_passwordpage passwp;
	PageObjectProductPage poprdctpage;
	ConfigPropertiesFile conProp;
	BaseClass bc=new BaseClass();
	public  TC004_ProductSearch(WebDriver driver)
	 {
		this.driver=driver;
		//passwp= new TC003_passwordpage(); 
		//.driver=passwp.driver;
		poprdctpage=new PageObjectProductPage(driver);
		 conProp=new ConfigPropertiesFile();
	 }
	@Test
	public void productSearch() throws IOException
	{
		//passwp.passwordPage();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		poprdctpage.productSearch(conProp.readPropFile("productSearch"));
		bc.logger.info("enter the product which we have to search");
		poprdctpage.clickOnSearch();
	    bc.logger.info("click on search button");
		
		/*
		 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		 * driver.findElement(By.xpath("//input[@aria-label='Search']")).
		 * sendKeys("asus zenfone max pro m1");
		 * driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
		 */
	}

}
