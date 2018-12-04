import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HamburgerMenuPage;
import pages.HomePage;
import pages.ProfilePage;
import properties.HelperMethods;

public class HamburgerMenuPageTests {


    private WebDriver driver;
    private HamburgerMenuPage hamburgerMenuPage;
    private HomePage homePage;
    private ProfilePage profilePage;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        hamburgerMenuPage = PageFactory.initElements(driver, HamburgerMenuPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        helperMethods.login();

    }

    @AfterTest
    public void closeResources() {
        driver.quit();
    }

    @Test(enabled = false)
    public void clickOnViewProfileLink() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnVewProfileLink();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getMyProfileTitleLocator()));
        driver.navigate().back();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void clickOnHomeButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnHomeButton();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getHomeSendFriendImageLocator()));

    }

    @Test
    public void clickOnReferToAFriendButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnReferToAFriendButton();
        //TODO: There is missing presenceOfSomething validation

    }

    @Test
    public void clickOnTermsAndConditionsButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnTermsAndConditionsButton();
        //TODO: There is missing presenceOfSomething validation

    }

    @Test
    public void clickOnPrivacyPolicyButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnPrivacyPolicyButton();
        //TODO: There is missing presenceOfSomething validation

    }

    @Test
    public void clickOnHelpButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnHelpButton();
        //TODO: There is missing presenceOfSomething validation

    }

    @Test
    public void clickOnLogOutButton() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        hamburgerMenuPage.clickOnLogOutButton();
        //TODO: There is missing presenceOfSomething validation
        //login();

    }

}
