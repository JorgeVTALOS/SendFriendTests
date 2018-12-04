import browser.BrowserFactory;
import generator.DataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import properties.HelperMethods;

public class LoginPageTests {


    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        helperMethods.getLoginPage();
    }

    @AfterTest
    public void closeResources() {
        driver.quit();
    }

    @Test
    public void keepAllClearClickOnSignInButton() {
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.getThisFieldIsRequiredEmailErrorTextLocator()))
        );
        String message = "This field is required";
        Assert.assertEquals(loginPage.checkThisFieldIsRequiredEmailErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setEmailAndClickOnSignInButton() {
        loginPage.setEmail(DataGenerator.getValidEmail());
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.getThisFieldIsRequiredPasswordErrorTextLocator()))
        );
        String message = "This field is required";
        Assert.assertEquals(loginPage.checkThisFieldIsRequiredPasswordErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setPasswordAndClickOnSignInButton() {
        loginPage.setPassword(DataGenerator.getValidPassword());
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.getThisFieldIsRequiredEmailErrorTextLocator()))
        );
        String message = "This field is required";
        Assert.assertEquals(loginPage.checkThisFieldIsRequiredEmailErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setAllFieldsAndClickOnSignInButton() {
        loginPage.setEmail("sendfriend@mail.com");
        loginPage.setPassword(DataGenerator.getValidPassword());
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(homePage.getHomeSendFriendImageLocator()))
        );
        driver.manage().deleteAllCookies();
        driver.navigate().back();
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setInvalidEmailAndPasswordAndClickOnSubmit() {
        loginPage.setEmail(DataGenerator.getInvalidEmail());
        loginPage.setPassword(DataGenerator.getValidPassword());
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.getShouldBeAValidEmailErrorTextLocator()))
        );
        String message = "Should be a valid email";
        Assert.assertEquals(loginPage.checkShouldBeAValidEmailErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setEmailAndInvalidPasswordAndClickOnSubmit() {
        loginPage.setEmail(DataGenerator.getValidEmail());
        loginPage.setPassword(DataGenerator.getInvalidPassword());
        loginPage.clickOnSigninButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(loginPage.getShouldBeAValidPasswordErrorTextLocator()))
        );
        String message = "Should be a valid password";
        Assert.assertEquals(loginPage.checkShouldBeAValidPasswordErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void showingPasswordClickOnEyeIcon() {
        loginPage.clickOnEyeIconPassword();
        Assert.assertEquals(loginPage.getPasswordFieldAttribute("type"), "text");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void hidingPasswordClickOnEyeIcon() {
        loginPage.clickOnEyeIconPassword();
        loginPage.clickOnEyeIconPassword();
        Assert.assertEquals(loginPage.getPasswordFieldAttribute("type"), "password");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

}
