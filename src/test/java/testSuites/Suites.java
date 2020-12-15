package testSuites;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generalUtilities.ConfigPropertiesFile;
import testCases.Alltestcases;

public class Suites extends Alltestcases {

public ExtentHtmlReporter htmlReporter;
public	ExtentReports extent;
public ExtentTest test;
public ConfigPropertiesFile configProp;
	
	public Suites()
	{

		configProp=new ConfigPropertiesFile();	
		}
//BaseClass bc;
	
	public void setUpExtentReport()
	{
		//defining  hoe report should be look and feel 
			htmlReporter=new ExtentHtmlReporter("C:\\Users\\salman\\workspace\\AmazonPortal\\ReportsGeneration\\myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);	
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("tester", "salman");
		
	}

@AfterSuite
public void endReport() 
{
	extent.flush();
	 
}

	@Test
		public void smokeSuite() throws IOException
		{setUpExtentReport();
		test=extent.createTest("launchAmazonapp");
			launchAllTestCases();
			
		}
	@Test
	public void regressionSuite() throws IOException
	{setUpExtentReport();
	test=extent.createTest("launchAmazonapp");
		productSearch();
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{if(result.getStatus()== ITestResult.FAILURE)
	{	test.log(Status.FAIL, "testcase failed is"+result.getName());//to add name  in the testcase
	test.log(Status.FAIL, "testcase failed is"+result.getThrowable());//to add error exception in the report
	String screenShot = Suites.takeScreenShot(driver,"HomePage");
	//test.addScreencastFromPath(screenShot);
	test.addScreenCaptureFromPath(screenShot, "titlefailed");
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
//}
//@AfterSuite
//public void quit()
//{
//	driver.quit();
	
}
@Test
public void whichSuiteRun() throws IOException
{
	if(configProp.readPropFile("TestingType").equalsIgnoreCase("smoke"))
	{
		smokeSuite();
	}
	else if(configProp.readPropFile("TestingType").equalsIgnoreCase("regression"))
	{
		regressionSuite();

	}
//}
}

}