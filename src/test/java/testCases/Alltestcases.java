package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import applicationUtilities.Screenshot;

public class Alltestcases {
	protected WebDriver driver;
	BaseClass bc;
	TC001_GetUrl getURL;
	TC002__Loginpage loginPage;
	TC003_passwordpage passwordPage;
	TC004_ProductSearch productSearch;
	TC005_AddingToCart addingCart;
	TC006_BuyingProduct buyingProduct;
	Screenshot scr;
	public Alltestcases() 
	{

		bc=new BaseClass(); 
		try {
			this.driver=bc.getDDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getURL=new TC001_GetUrl(driver);
		loginPage=new TC002__Loginpage(driver);
		passwordPage=new TC003_passwordpage(driver);
		productSearch=new TC004_ProductSearch(driver);
		addingCart =new TC005_AddingToCart(driver);
		buyingProduct=new TC006_BuyingProduct(driver);
		scr=new Screenshot(driver);
	}

	@Test
	public void launchAllTestCases() throws IOException
	{
		getURL.launchAmazonApp();
		loginPage.loginpage();
		passwordPage.passwordPage();
		productSearch.productSearch();
		addingCart.addingToCart();
		buyingProduct.buyingProduct();
		
	}
	@Test
public void productSearch() throws IOException
{
	getURL.launchAmazonApp();
	loginPage.loginpage();
	passwordPage.passwordPage();
	productSearch.productSearch();
	
}
	}
