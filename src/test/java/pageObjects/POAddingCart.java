package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POAddingCart
{
	WebDriver driver;
	public POAddingCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//span[contains(text(),'(Renewed) ASUS Zenfone Max Pro M1 4gb 64gb Grey')]")
WebElement selectingaProduct;
@FindBy(xpath="//input[@aria-labelledby='submit.buy-now-announce']")
WebElement buyProduct;
public void selectingaProduct()
{
	selectingaProduct.click();

}
public void buyProduct()
{
	buyProduct.click();

}
}
