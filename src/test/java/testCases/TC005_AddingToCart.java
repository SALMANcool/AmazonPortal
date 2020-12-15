package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import pageObjects.POAddingCart;

public class TC005_AddingToCart {
//	TC004_ProductSearch prodse;
	WebDriver driver;
	POAddingCart poaddcart;
	BaseClass bc=new BaseClass();
	
	public TC005_AddingToCart(WebDriver driver)
	{
	//	prodse=new TC004_ProductSearch();
		//this.driver=prodse.driver;
		poaddcart= new POAddingCart(driver);
	}
	@Test
	public void addingToCart() throws IOException
	{
	//	prodse.productSearch();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		poaddcart.selectingaProduct();
		bc.logger.info("click on product which we have to select");
	//	driver.findElement(By.xpath("//span[contains(text(),'(Renewed) ASUS Zenfone Max Pro M1 4gb 64gb Grey')]")).click();
ArrayList<String> windowhandle= new ArrayList<String>( driver.getWindowHandles());
	for (int i = 1; i < windowhandle.size(); i++)
	{	
		/*
		 * if(i==0) { String homerwindow=windowhandle.get(i);
		 * driver.switchTo().window(homerwindow); }
		 */

			if(i==1) {
		String particularwindow=windowhandle.get(i);
		driver.switchTo().window(particularwindow);	
		
		}
			//driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		//	driver.findElement(By.xpath("//input[@aria-labelledby='submit.buy-now-announce']")) .click();
			poaddcart.buyProduct();
			bc.logger.info("click on Buy now Button");
			
			//selecting the address
			
		}
	
	
	}

}
