package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POBuyingAProject {
WebDriver driver;
	public POBuyingAProject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='address-ui-widgets-enterAddressFullName']" )
	WebElement fullName;
	@FindBy(xpath ="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phoneNumber;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement pinCode;
	@FindBy(xpath ="//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement Address1;
	@FindBy(xpath ="//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement Address2;
	@FindBy(xpath ="//input[@id='address-ui-widgets-landmark']")
	WebElement landMark;
	@FindBy(xpath ="//span[contains(text(),' Select an Address Type')]")
	WebElement selectDropDown;
	@FindBy(xpath = "//a[contains(text(),' Home (7 am – 9 pm delivery) ')]")
	WebElement selectingHomeDelivery;
	@FindBy(xpath ="//input[@type='submit']")
	WebElement submitButton;
	
	public void fullName(String value)
	{
		fullName.sendKeys(value);
	}
	public void phoneNumber(String value)
	{
		phoneNumber.sendKeys(value);
	}
	public void pinCode(String value)
	{
		pinCode.sendKeys(value);
	}
	public void Address1(String value)
	{
		Address1.sendKeys(value);
	}
	public void Address2(String value)
	{
		Address2.sendKeys(value);
	}
	public void landMark(String value )
	{
		landMark.sendKeys(value);
	}
	public void selectDropDown()
	{
		selectDropDown.click();

}
	public void selectingHomeDelivery()
	{
		selectingHomeDelivery.click();

}
	public void submitButton()
	{
		submitButton.click();

}
}
