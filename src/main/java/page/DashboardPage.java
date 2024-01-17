package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DashboardPage extends BasePage {

	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElements/Attributes
	
	@FindBy(how = How.XPATH,using = "//strong[text() ='Dashboard' ]" ) WebElement dashboardHeaderElement;
	@FindBy(how = How.XPATH,using = "//span[text()='Customers']" ) WebElement customerMenueElement;
	@FindBy(how = How.XPATH,using = "//span[text() = 'Add Customer']" ) WebElement addCustomerMenueElement;
		

		//InteractableMethodes
		public void validateDashboardPage(String dashboardHeaderText ) {
			validateElement(dashboardHeaderElement.getText(), dashboardHeaderText ,"Dashboard is not available");
		}

        public void clickOnCustomerMenue() {
        	customerMenueElement.click();
        }
        public void clickOnaddCustomer() {
        	addCustomerMenueElement.click();
        }
		
	
	
	
}
