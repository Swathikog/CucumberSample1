package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class PageDefinitions {

	WebDriver driver;
	public LoginPage lp;
	
	@Given("Launch the browser")
	
	public void OpenBrowser() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\SWATHI\\eclipse-workspace\\CucumberSample1\\Drivers\\chromedriver.exe");
	   driver=new ChromeDriver();
	   lp=new LoginPage(driver);
	}

	@When("Open url")
	
	public void openUrl() {
	    driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}

	@Then("Login with valid credentials {string} {string}")
	
	public void validLogin(String email,String password) {
		lp.userNameSet(email);
		lp.userPasswordSet(password);
		lp.btnclick();
		lp.btnloginclick();
	}
	
	@Then("Login with Invalid credentials")
	
	public void InvalidLogin() {
		
		if(driver.getPageSource().contains("Invalid username/password. Please try again.")) {
			
		}else {
				driver.getTitle();
			
			}
		}
	
	@And("close browser")
	
	public void closeBrowser() {
		driver.close();
		
	}
	
}
