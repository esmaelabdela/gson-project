package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	static WebDriver deriver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		//InputStream
		
		try {
		      InputStream	input = new FileInputStream("src\\main\\java\\config\\config.properties");
		      Properties prop = new Properties();
		      prop.load(input);
		      browser = prop.getProperty("browser");
		      url = prop.getProperty("url");
		     
		      
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
	} 

	public static WebDriver init() {
		readConfig();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			deriver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver","drivers\\msedgedriver.exe");
			deriver = new EdgeDriver();	
		}else {
			System.out.println("please use a valid browser");
		}
		
		deriver.manage().deleteAllCookies();
		deriver.get(url);
		deriver.manage().window().maximize();
		deriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return deriver;
	}
	
	
	public static void tearDown() {
		deriver.close();
		deriver.quit();
	}
}
