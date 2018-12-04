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
import pages.SignupPage;
import properties.HelperMethods;

public class SignupPageTests {


    private final String REQUIRED_MESSAGE = "This field is required";
    private WebDriver driver;
    private SignupPage signupPage;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        signupPage = PageFactory.initElements(driver, SignupPage.class);

        helperMethods.getSingUpPage();
    }

    @AfterTest
    public void closeResources() {
        driver.quit();
    }

    @Test
    public void keepAllClearAndClickOnSubmitButton() {
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getThisFieldIsRequiredNameErrorTextLocator()));
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredNameErrorText(), REQUIRED_MESSAGE);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setNameAndLastNameAndClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getThisFieldIsRequiredEmailErrorTextLocator()));
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredEmailErrorText(), REQUIRED_MESSAGE);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToEmailAndClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getThisFieldIsRequiredPasswordErrorTextLocator()));
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredPasswordErrorText(), REQUIRED_MESSAGE);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToPhoneNumberAndClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getThisFieldIsRequiredPasswordErrorTextLocator()));
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredPasswordErrorText(), REQUIRED_MESSAGE);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToPasswordAndClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.setPassword(DataGenerator.getValidPassword());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getThisFieldIsRequiredConfirmPasswordErrorTextLocator()));
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredConfirmPasswordErrorText(), REQUIRED_MESSAGE);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToConfirmPasswordAndClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.setPassword(DataGenerator.getValidPassword());
        signupPage.setConfirmPassword(DataGenerator.getValidPassword());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getYouMustAcceptTheTermsOfServiceAndConditionsErrorTextLocator()));
        String message = "You must accept the Terms of Service and Conditions";
        Assert.assertEquals(signupPage.checkYouMustAcceptTheTermsOfServiceAndConditionsErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToTCAndPrivacyPolicyCheckboxAndClickOnSubmitButtonWithWrongConfirmPasswordText() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.setPassword(DataGenerator.getValidPassword());
        signupPage.setConfirmPassword(DataGenerator.getValidPassword());
        signupPage.tickAgreeTCandPrivacyPolicyCheckBox();
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getConfirmPasswordDoesNotMatchPasswordErrorTextLocator()));
        String message = "Confirm Password does not match Password";
        Assert.assertEquals(signupPage.checkThisFieldIsRequiredConfirmPasswordErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setFromNameToSendByEmailCheckboxAndClickOnSubmitButtonWithoutTickTCAndPrivacyPolicyCheckBox() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.setPassword(DataGenerator.getValidPassword());
        signupPage.setConfirmPassword(DataGenerator.getValidPassword());
        signupPage.tickNotifyByEmailCheckBox();
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getYouMustAcceptTheTermsOfServiceAndConditionsErrorTextLocator()));
        String message = "You must accept the Terms of Service and Conditions";
        Assert.assertEquals(signupPage.checkYouMustAcceptTheTermsOfServiceAndConditionsErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setAllFieldsAndTickAllCheckBoxAndClickOnSubmitButton() {
        String password = DataGenerator.getValidPassword();
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPhoneNumber(DataGenerator.getValidPhoneNumber());
        signupPage.setPassword(password);
        signupPage.setConfirmPassword(password);
        signupPage.tickAgreeTCandPrivacyPolicyCheckBox();
        signupPage.tickNotifyByEmailCheckBox();
        signupPage.clickOnSubmitButton();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.alertIsPresent()
        );
        driver.switchTo().alert().accept();
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setInvalidEmailAndClickOnSubmit() {
        signupPage.setEmail(DataGenerator.getInvalidEmail());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getShouldBeAValidEmailErrorTextLocator()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setInvalidPasswordAndClickOnSubmit() {
        signupPage.setPassword(DataGenerator.getInvalidPassword());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getShouldBeAValidPasswordErrorTextLocator()));
        String message = "Your password must have an special character, numbers, and at least 7 characters";
        Assert.assertEquals(signupPage.checkShouldBeAValidPasswordErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setInvalidConfirmPasswordAndClickOnSubmit() {
        signupPage.setConfirmPassword(DataGenerator.getInvalidPassword());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getShouldBeAValidConfirmPasswordErrorTextLocator()));
        String message = "Your password must have an special character, numbers, and at least 7 characters";
        Assert.assertEquals(signupPage.checkShouldBeAValidConfirmPasswordErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setDifferentPasswordAndConfirmPasswordClickOnSubmitButton() {
        signupPage.setFullName(DataGenerator.getValidFullName());
        signupPage.setEmail(DataGenerator.getValidEmail());
        signupPage.setPassword(DataGenerator.getValidPassword());
        signupPage.setConfirmPassword(DataGenerator.getInvalidPassword());
        signupPage.tickAgreeTCandPrivacyPolicyCheckBox();
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getConfirmPasswordDoesNotMatchPasswordErrorTextLocator()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void showingPasswordClickOnEyeIcon() {
        signupPage.clickOnEyeIconPassword();
        Assert.assertEquals(signupPage.getPasswordFieldAttribute("type"), "text");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void hidingPasswordClickOnEyeIcon() {
        signupPage.clickOnEyeIconPassword();
        signupPage.clickOnEyeIconPassword();
        Assert.assertEquals(signupPage.getPasswordFieldAttribute("type"), "password");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void showingConfirmPasswordClickOnEyeIcon() {
        signupPage.clickOnEyeIconConfirmPassword();
        Assert.assertEquals(signupPage.getConfirmPasswordFieldAttribute("type"), "text");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void hidingConfirmPasswordClickOnEyeIcon() {
        signupPage.clickOnEyeIconConfirmPassword();
        signupPage.clickOnEyeIconConfirmPassword();
        Assert.assertEquals(signupPage.getConfirmPasswordFieldAttribute("type"), "password");
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setInvalidPhoneNumberAndClickOnSubmit() {
        signupPage.setPhoneNumber(DataGenerator.getInvalidPhoneNumber());
        signupPage.clickOnSubmitButton();
        helperMethods.presenceOfElementLocated(By.xpath(signupPage.getBadInputPhoneNumberErrorTextLocator()));
        String message = "Bad Input";
        Assert.assertEquals(signupPage.checkBadInputPhoneNumberErrorText(), message);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

}
