package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends TestBase {
	
	public WebDriverWait wait=new WebDriverWait(driver, 30);
	
	@FindBy(css="a.header__upper-deck-item-link.sign-in")
	protected WebElement btn_LogIn;

	@FindBy(css="span.header__my-gumtree-trigger-text")
	protected WebElement span_Elm;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public LogInPage clickLogInButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_LogIn)).click();
		return new LogInPage(driver);
	}

	public String returnLoggedInUser() {return span_Elm.getText();}

}
