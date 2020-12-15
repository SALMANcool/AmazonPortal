package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectPasswordPage {

	WebDriver driver;
	public PageObjectPasswordPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Enterpassword;
	@FindBy(xpath = "//input[@tabindex='4']")
	WebElement selectCheckBoxPasswordPage;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement passwordSubmitButton;
	public void Enterpassword(String value )
	{
		Enterpassword.sendKeys(value);
	}
	public void selectCheckBoxPasswordPage()
	{
		selectCheckBoxPasswordPage.click();
	}
	public void passwordSubmitButton()
	{
		passwordSubmitButton.click();
	}
}
