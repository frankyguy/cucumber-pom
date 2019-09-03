package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage extends TestBase {
	
	public WebDriverWait wait=new WebDriverWait(driver, 30);
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="login-email")
	protected WebElement txtbx_Username;
	
	@FindBy(id="login-password")
	protected WebElement txtbx_Password;
	
	@FindBy(id="btn-submit-login")
	protected WebElement btn_LogIn;
	
	public String getLogInPageTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage logIn(String userName, String password) {
		
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_Username)).clear();
		txtbx_Username.sendKeys(userName);

		wait.until(ExpectedConditions.elementToBeClickable(txtbx_Password)).clear();
		txtbx_Password.sendKeys(password);

		btn_LogIn.click();

		return new HomePage(driver);
	}

}
