package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject {
	
	WebDriver driver;
	public LoginPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@type='email']")
	WebElement phoneNumber;
	@FindBy(xpath="//input[@type='submit']")
			WebElement phoneNumberSubmit;
public void setPhoneNum(String value )
{
	phoneNumber.sendKeys(value);
}
public void phoneNumbSubmitButton()
{
	phoneNumberSubmit.click();
}
}
