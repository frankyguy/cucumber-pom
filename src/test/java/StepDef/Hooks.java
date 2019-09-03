package StepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.BaseUtil;
import utils.PropertyFileReader;
import utils.TestUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.BaseUtil.browserName;
import static utils.BaseUtil.projectProperties;

public class Hooks {

	private BaseUtil base;

	public Hooks(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void startUp() {

		base.browserName =base.projectProperties.getProperty("browser");

		if(base.browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "/src/main/java/drivers/chromedriver.exe");
			base.driver = new ChromeDriver();

		} else if(base.browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/java/drivers/IEDriverServer.exe");
			base.driver = new InternetExplorerDriver();

		} else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.geco.driver", System.getProperty("user.dir") + "/src/main/java/drivers/gecodriver.exe");
			base.driver = new FirefoxDriver();

		} else {
			System.out.println("Default browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
			base.driver = new ChromeDriver();
		}

		base.driver.manage().window().maximize();
		base.driver.manage().deleteAllCookies();
		base.driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		base.driver.manage().timeouts().implicitlyWait(TestUtils.WAIT_FOR_ELEMENT, TimeUnit.SECONDS);

	}

	@After
	//Embed a screenshot in test report if test is marked as failed
	public void tearDown(Scenario scenario) {

		if(scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + base.driver.getCurrentUrl());;
				byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		base.driver.quit();

	}


}
