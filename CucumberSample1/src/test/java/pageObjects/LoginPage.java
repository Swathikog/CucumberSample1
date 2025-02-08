package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver tdriver) {
		driver=tdriver;
		PageFactory.initElements(tdriver,this);
	}
	@FindBy(id="username")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="Inpatient Ward")
	WebElement btnInp;
	
	@FindBy(id="loginButton")
	WebElement btnLogin;
	
	public void userNameSet(String email) {
		txtUserName.sendKeys(email);
	}
	
	public void userPasswordSet(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void btnclick() {
		btnInp.click();
	}
	
	public void btnloginclick() {
		btnLogin.click();
	}
}
