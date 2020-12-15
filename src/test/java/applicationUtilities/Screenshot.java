package applicationUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{
WebDriver driver;
public Screenshot(WebDriver driver)
{
	this.driver=driver;
}
String screenshotfilepath;
public String TakeErrorScreenShot(String fname)
{
	String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String screenshotfilePath= System.getProperty("user.dir")+"/Screenshots/"+fname + timestamp+".png";
    try {
		FileUtils.copyFile(scrFile, new File(screenshotfilepath));
    	//FileUtils.copyFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    scrFile = null;
    System.out.println(screenshotfilepath);
    return screenshotfilepath;
}

}
