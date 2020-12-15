package generalUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesFile 
{
Properties prop;
//String filePath="./Data/config.properties";
public  String readPropFile(String key) throws IOException
{
	
	File src=new File("./Data/config.properties");
	FileInputStream fis=new FileInputStream(src);
	prop=new Properties();
	prop.load(fis);
	 String value = prop.getProperty(key);
	 return value;
}
/*
 * public String getApllicationURL() { prop.getProperty(url); return url; }
 * public void enterPhoneNumber(String phoneNumber) {
 * prop.getProperty(phoneNumber); } public void getPassword(String password) {
 * prop.getProperty(password); }
 */
}
