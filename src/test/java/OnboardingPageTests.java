import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.OnboardingPage;
import properties.HelperMethods;

public class OnboardingPageTests {


    private WebDriver driver;
    private OnboardingPage onboardingPage;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        onboardingPage = PageFactory.initElements(driver, OnboardingPage.class);
        helperMethods.getOnboardingPage();

    }

    @AfterTest
    public void closeResources() {
        driver.quit();

    }

    @Test
    public void clickOnButtonOne() {
        onboardingPage.clickOnButtonOne();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonOneTitleLocator()));

    }

    @Test
    public void clickOnButtonTwo() {
        onboardingPage.clickOnButtonTwo();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonTwoTitleLocator()));
    }

    @Test
    public void clickOnButtonThree() {
        onboardingPage.clickOnButtonThree();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonThreeTitleLocator()));

    }

    @Test
    public void clickOnButtonFour() {
        onboardingPage.clickOnButtonFour();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonFourTitleLocator()));

    }

    @Test
    public void clickOnButtonFive() {
        onboardingPage.clickOnButtonFive();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonFiveTitleLocator()));

    }

    @Test
    public void clickOnButtonSix() {
        onboardingPage.clickOnButtonSix();
        helperMethods.presenceOfElementLocated(By.xpath(onboardingPage.getButtonSixTitleLocator()));

    }

    @Test
    public void clickOnSignUpButton() {
        onboardingPage.clickOnSignUp();
        helperMethods.presenceOfElementLocated(By.name("fullName"));
        driver.navigate().back();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void clickOnLoginButton() {
        onboardingPage.clickOnLogin();
        helperMethods.presenceOfElementLocated(By.name("email"));
        driver.navigate().back();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void checkNeedHelpText() {
        Assert.assertEquals(onboardingPage.checkNeedHelpText(), "Need Help?");

    }

}
