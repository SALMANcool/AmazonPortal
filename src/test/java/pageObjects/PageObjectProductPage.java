package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectProductPage {

	WebDriver driver;
	public PageObjectProductPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@aria-label='Search']")
	WebElement productSearch;
	@FindBy(xpath = "//input[@type='submit'][1]")
	WebElement clickOnSearch;
	public void productSearch(String value )
	{
		productSearch.sendKeys(value);
	}
	public void clickOnSearch()
	{
		clickOnSearch.click();

}
}