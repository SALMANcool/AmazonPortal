package generalUtilities;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import Amazon.AmazonPortal.BaseClass;

public class Reports {
	
WebDriver driver;
public ExtentHtmlReporter htmlReporter;
public	ExtentReports extent;
public ExtentTest test;
public ConfigPropertiesFile conProp;
	//BaseClass bc;
		@BeforeTest
	public void setUpExtentReport()
	{
		//defining  hoe report should be look and feel 
			htmlReporter=new ExtentHtmlReporter("./ReportsGeneration/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);	
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("tester", "salman");
		
	}

@AfterTest
public void endReport() 
{
	extent.flush();
	 
}
		@BeforeMethod
		public void getDDriver()
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

			driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_4jbnr0fdp4_e&adgrpid=87514387614&hvpone=&hvptwo=&hvadid=410537403326&hvpos=&hvnetw=g&hvrand=1914842067608519602&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9040219&hvtargid=kwd-895441526047&hydadcr=9_2066133&gclid=Cj0KCQiA5bz-BRD-ARIsABjT4nhxSBhRvMMqo59rIH0vHMSNNfsO9-kdW1bMAtwkmNCc9m0LWC-H6A0aAod0EALw_wcB");
			
		}
		
		@Test
		public void launchAmazonApp() throws IOException
		{test=extent.createTest("launchAmazonApp");
			// bc=new BaseClass();
				 conProp = new ConfigPropertiesFile();
			//extent.createTest("login Amazon");
	//driver.get(conProp.readPropFile("url"));
		//bc.logger.info("launch URL");
		String actual = driver.getTitle();
		System.out.println("title is"+driver.getTitle());
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.i";
		Assert.assertEquals(actual, expected, "completed");
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();	
//			bc.logger.info("click on signIn Button");
		}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{if(result.getStatus()== ITestResult.FAILURE)
	{	test.log(Status.FAIL, "testcase failed is"+result.getName());//to add name  in the testcase
	test.log(Status.FAIL, "testcase failed is"+result.getThrowable());//to add error exception in the report
	String screenShot = Reports.takeScreenShot(driver,"HomePage");
	test.addScreencastFromPath(screenShot);
	//test.addScreenCaptureFromPath(screenShot, "titlefailed");
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "testcase is skipped"+result.getName());
	}
	else if (result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, "testcase passed"+result.getName());
	}

	}	

public static String takeScreenShot(WebDriver driver,String ScrrenshotName) throws IOException
{
	String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//	String timestamp = date.format("yyyymmddhhmmss");
	TakesScreenshot scrrenshot = (TakesScreenshot)driver;
	 File src = scrrenshot.getScreenshotAs(OutputType.FILE);
	 String filePath= System.getProperty("user.dir")+"/Screenshots/"+ScrrenshotName + timestamp+".png";
	 File destinattion=new File(filePath); 
	 FileUtils.copyFile(src,destinattion);
	 return filePath;
}
@AfterSuite
public void quit()
{
	driver.quit();
	
}
}
