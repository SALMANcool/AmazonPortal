package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.AmazonPortal.BaseClass;
import generalUtilities.ConfigPropertiesFile;
import pageObjects.POBuyingAProject;

public class TC006_BuyingProduct  {
	WebDriver driver;
//	TC005_AddingToCart addingCart;
	POBuyingAProject pobuyprod;
	ConfigPropertiesFile conProp;
	BaseClass bc=new BaseClass();
	public TC006_BuyingProduct(WebDriver driver) {
		this.driver=driver;;
	//	addingCart = new TC005_AddingToCart();
		//this.driver = addingCart.driver;
		pobuyprod = new POBuyingAProject(driver);
		 conProp= new ConfigPropertiesFile();
	}

	@Test
	public void buyingProduct() throws IOException {
		//addingCart.addingToCart();

		pobuyprod.fullName(conProp.readPropFile("fullName"));
		bc.logger.info("Enter full name in Address page");
		pobuyprod.phoneNumber(conProp.readPropFile("phoneNumber"));
		bc.logger.info("Enter phone number in Address page");
		pobuyprod.pinCode(conProp.readPropFile("pinCode"));
		bc.logger.info("Enter pincode in Address page");
		pobuyprod.Address1(conProp.readPropFile("Address1"));
		bc.logger.info("Enter doorno in Addresspage");
		pobuyprod.Address2(conProp.readPropFile("Address2"));
		bc.logger.info("Enter full address in Address page");
		pobuyprod.landMark(conProp.readPropFile("landMark"));
		bc.logger.info("Enter landmark in the Address page");
		pobuyprod.selectDropDown();
		bc.logger.info("select Dropdown ");
		pobuyprod.selectingHomeDelivery();
		bc.logger.info("select homedelivery");
		pobuyprod.submitButton();
		bc.logger.info("click on submit button");
	}/*
		 * driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressFullName']")).
		 * sendKeys("salman irshad"); driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys(
		 * "7799181822"); driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys(
		 * "517002"); driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("15-3186");
		 * driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys(
		 * "sankarayagunta");
		 * driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).
		 * sendKeys("Noorani masjid");
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Chittoor");
		 * WebElement selectSstate =
		 * driver.findElement(By.xpath("//span[contains(text(),'Select state')]"));
		 * selectSstate.click();
		 * driver.findElement(By.xpath("//a[contains(text(),'ANDHRA PRADESH')]")).click(
		 * );
		 * 
		 * driver.findElement(By.
		 * xpath("//span[contains(text(),' Select an Address Type')]")).click();
		 * driver.findElement(By.
		 * xpath("//a[contains(text(),' Home (7 am – 9 pm delivery) ')]")).click();
		 * driver.findElement(By.xpath("//input[@type='submit']")).click();
		 */
	}


