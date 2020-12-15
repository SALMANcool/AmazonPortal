package Amazon.AmazonPortal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generalUtilities.ConfigPropertiesFile;

public class BaseClass {

	public static WebDriver driver;
public static Logger logger;
	ConfigPropertiesFile configProp;
	 
	public BaseClass()
	  
	  {
		  logger = Logger.getLogger("AmazonPortal");
		  PropertyConfigurator.configure("./Data/Log4j.properties");
		  configProp=new ConfigPropertiesFile();
	  }
	 @Test
	  public WebDriver getDDriver() throws IOException
		{
			if(configProp.readPropFile("browser").equalsIgnoreCase("CHROME"))
			{
				System.out.println("chrome opened");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(configProp.readPropFile("browser").equalsIgnoreCase("FIREFOX"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(configProp.readPropFile("browser").equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "./Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", configProp.readPropFile(System.getProperty("user.dir") + "./Drivers/chromedriver.exe"));
				driver = new ChromeDriver();
			}
			return driver;
		}
		
//	@Test
	/*public WebDriver getDDriver()

	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}*/

	

//	@Test
//	public void launchAmazonApp() {
//		// System.setProperty("webdriver.chrome.driver","C:\\Users\\salman\\workspace\\AmazonPortal\\Drivers\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		PropertyConfigurator.configure("C:\\Users\\salman\\workspace\\AmazonPortal\\Data\\Log4j.properties");
//
//		driver.get(
//				"https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_4jbnr0fdp4_e&adgrpid=87514387614&hvpone=&hvptwo=&hvadid=410537403326&hvpos=&hvnetw=g&hvrand=1914842067608519602&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9040219&hvtargid=kwd-895441526047&hydadcr=9_2066133&gclid=Cj0KCQiA5bz-BRD-ARIsABjT4nhxSBhRvMMqo59rIH0vHMSNNfsO9-kdW1bMAtwkmNCc9m0LWC-H6A0aAod0EALw_wcB");
//		logger.info("LaunchUrl");
//		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
//		logger.info("clickonSigninButton");
//
//	}
//
//	@Test
//	public void loginpage() {
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7799181822");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}
//
//	@Test
//	public void passwordPage() {
//		loginpage();
//
//	}
//
//	@Test
//	public void productSearch() {
//		passwordPage();
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
//		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("asus zenfone max pro m1");
//		driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
//		;
//	}
//
//	@Test
//	public void addingToCart() {
//		productSearch();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//span[contains(text(),'(Renewed) ASUS Zenfone Max Pro M1 4gb 64gb Grey')]"))
//				.click();
//		ArrayList<String> windowhandle = new ArrayList<String>(driver.getWindowHandles());
//		for (int i = 1; i < windowhandle.size(); i++) {
//			/*
//			 * if(i==0) { String homerwindow=windowhandle.get(i);
//			 * driver.switchTo().window(homerwindow); }
//			 */
//
//			if (i == 1) {
//				String particularwindow = windowhandle.get(i);
//				driver.switchTo().window(particularwindow);
//
//			}
//			// driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
//			driver.findElement(By.xpath("//input[@aria-labelledby='submit.buy-now-announce']")).click();
//
//			// selecting the address
//
//		}
//
//	}
//
//	@Test
//	public void buyingProduct() {
//		addingToCart();
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']"))
//				.sendKeys("salman irshad");
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']"))
//				.sendKeys("7799181822");
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("517002");
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("15-3186");
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("sankarayagunta");
//		driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).sendKeys("Noorani masjid");
//
//		/*
//		 * driver.findElement(By.xpath(
//		 * "//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Chittoor");
//		 * WebElement selectSstate =
//		 * driver.findElement(By.xpath("//span[contains(text(),'Select state')]"));
//		 * selectSstate.click();
//		 * driver.findElement(By.xpath("//a[contains(text(),'ANDHRA PRADESH')]")).click(
//		 * );
//		 */
//		driver.findElement(By.xpath("//span[contains(text(),' Select an Address Type')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(),' Home (7 am – 9 pm delivery) ')]")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}
}
