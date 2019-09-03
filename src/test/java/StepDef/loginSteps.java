package StepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LogInPage;
import utils.BaseUtil;

public class loginSteps {

    private BaseUtil base;
    HomePage homePage;
    LogInPage loginPage;

    public loginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I am on gumtree home page$")
    public void iAmOnGumtreeHomePage() {
        base.driver.get(base.projectProperties.getProperty("url"));
        homePage=new HomePage(base.driver);
        Assert.assertTrue(homePage.getHomePageTitle().contains("Gumtree"));
    }

    @And("^I click SignIn link$")
    public void iClickSignInLink() {
        loginPage = homePage.clickLogInButton();
        Assert.assertTrue(loginPage.getLogInPageTitle().contains("Gumtree"));
    }

    @And("^I sign in with ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) {
        homePage = loginPage.logIn(username,password);
    }

    @Then("^I should see the home page with user as \"([^\"]*)\" logged in$")
    public void iShouldSeeTheHomePageWithUserAsLoggedIn(String spanTxt) throws Throwable {
        Assert.assertTrue(homePage.returnLoggedInUser().contains(spanTxt));
    }
}
