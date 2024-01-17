package test;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {

	WebDriver driver;
	JsonElement jsonEleObj;

	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void readJson() {

		try {

			FileReader reader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			@SuppressWarnings("deprecation")
			JsonParser parserObj = new JsonParser();
			jsonEleObj = parserObj.parse(reader);
			jsonEleObj.isJsonObject();

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	@Test (groups = {"regression"})
  public void userShouldBeAbleToAddNewCustomer() {
	  
		driver = BrowserFactory.init();
	    
		LoginPage loginPage2 = PageFactory.initElements(driver, LoginPage.class);
		loginPage2.insertUserName(
				jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage2.insertPassword(
				jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage2.clickOnSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject()
				.get("ValidationTextLogin").getAsString());
	
	 dashboardPage.clickOnCustomerMenue();
	 dashboardPage.clickOnaddCustomer();
	 
	 AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	 addCustomerPage.validateAddCustomerPage(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("ValidationTextAddCustomer").getAsString());
	 addCustomerPage.insertFullName(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("FullName").getAsString());
	 addCustomerPage.selectCompanyName(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Company").getAsString());
	 addCustomerPage.insertEmail(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Email").getAsString());
	 addCustomerPage.insertPhone(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Phone").getAsString());
	 
	 addCustomerPage.insertStreet(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Street").getAsString());
	 addCustomerPage.insertCitty(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("City").getAsString());
	 addCustomerPage.insertZip(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Zip").getAsString()); 
	 addCustomerPage.selectCountryName(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Country").getAsString());
	 addCustomerPage.seletGroupName(jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Group").getAsString());
//	 addCustomerPage.clickSaveButton();
	 
//	 ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
//	 listCustomerPage.validateInsertedNameAndDelete();
//    addCustomerPage.clickOnYesDeleteButton();
	 BrowserFactory.tearDown();
	 
  }
  
	
	
  
	
}
