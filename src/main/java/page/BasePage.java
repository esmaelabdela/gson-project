package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {

	
	
	public void validateElement(String actual, String expected, String errorMsg) {
		Assert.assertEquals(actual, expected ,errorMsg);
		
	}
	

	 public int generateRandomNum(int boundNum) {
		    Random rnd = new Random();
		    int generateNum = rnd.nextInt(boundNum);
			return generateNum;
			 }
	
	    
	 public void selectFromdropDown(WebElement element, String visibleText ) {	 
	   	     Select sel = new Select(element);
			 sel.selectByVisibleText(visibleText);	
		      }
	
}
