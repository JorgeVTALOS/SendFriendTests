package properties;

import generator.DataGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

@Slf4j
public class HelperMethods {

    private final WebDriver driver;
    private final ApplicationPropertiesSingleton properties;
    private final LoginPage loginPage;
    private final HomePage homePage;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
        this.properties = ApplicationPropertiesSingleton.getInstance();
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        this.homePage = PageFactory.initElements(driver, HomePage.class);

    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until((driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void login() {
        getLoginPage();
        loginPage.setEmail(DataGenerator.getValidEmail());
        loginPage.setPassword(DataGenerator.getValidPassword());
        loginPage.clickOnSigninButton();
        presenceOfElementLocated(By.xpath(homePage.getSendMoneyButtonLocator()));
        waitForPageToLoad();
    }

    public void getProfilePage() {
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL) + "/profile");
        waitForPageToLoad();
    }

    public void getLoginPage() {
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL) + "/login");
        waitForPageToLoad();
    }

    public void getOnboardingPage() {
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL) + "/");
        waitForPageToLoad();
    }

    public void getSendMoneyPage() {
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL) + "/send-money");
        waitForPageToLoad();
    }

    public void getSingUpPage() {
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL) + "/signup");
        waitForPageToLoad();
    }

    public void presenceOfElementLocated(By by) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public void presenceOfElementLocated(String id) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.id(id))
        );
    }

    public void invisibilityOfElementLocated(By by) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public void invisibilityOfElementLocated(String id) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.invisibilityOfElementLocated(By.id(id))
        );
    }

    public void validateEmptyString(String str) {
        new WebDriverWait(driver, 10).until(
                (driver) -> str == null || str.equals(""));
    }

    public void takeScreenShot(String nameImage) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(String.format(properties.getProperty(EnumProperties.SCREENSHOTS_PATHNAME), nameImage)));
        } catch (IOException e) {
            log.error("Screenshot image could not be recovered");
        }
    }
}
