import browser.BrowserFactory;
import generator.DataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProfilePage;
import properties.HelperMethods;

public class ProfilePageTests {


    private final String SUCCESS_MESSAGE = "Your personal info was successfully updated.";
    private WebDriver driver;
    private ProfilePage profilePage;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        profilePage.setActions(new Actions(driver));
        profilePage.setJavascriptExecutor(((JavascriptExecutor) driver));

        helperMethods.login();
        helperMethods.getProfilePage();

    }

    @AfterTest
    public void closeResources() {
        driver.quit();

    }

    @Test
    public void enablingFullNameTextFieldByClickOnPencilIcon() {
        profilePage.clickOnPencilIcon();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getFullNameInputLocator()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void disablingFullNameTextFieldByClickOnPencilIcon() {
        profilePage.clickOnPencilIcon();
        profilePage.clickOnPencilIcon();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getFullNameLabelLocator()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void setValidFullNameAndClickOnSaveChangesButton() {
        String name = DataGenerator.getValidFullName();
        profilePage.clickOnPencilIcon();
        profilePage.clearFullName();
        profilePage.setFullNameInput(name);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getFullNameLabel(), name);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

    @Test(enabled = false)
    public void setBirthdayAndClickOnSaveChangesButton() {
        String birthday = "2018-10-03";
        profilePage.setBirthday(birthday);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getBirthday(), birthday);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

    @Test
    public void setValidStreetAddressAndClickOnSaveChangesButton() {
        String address = DataGenerator.getValidFullName();
        profilePage.clearStreetAddress();
        helperMethods.validateEmptyString(profilePage.getStreetAddress());
        profilePage.setStreetAddress(address);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getStreetAddress(), address);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void setInvalidStreetAddressAndClickOnSaveChangesButton() {
        String address = DataGenerator.getValidFullName();
        profilePage.clearStreetAddress();
        helperMethods.validateEmptyString(profilePage.getStreetAddress());
        profilePage.setStreetAddress(address);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getStreetAddress(), address);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setValidCityAndClickOnSaveChangesButton() {
        String city = DataGenerator.getValidFullName();
        profilePage.clearCity();
        helperMethods.validateEmptyString(profilePage.getCity());
        profilePage.setCity(city);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getCity(), city);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void setInvalidCityAndClickOnSaveChangesButton() {
        String city = DataGenerator.getValidFullName();
        profilePage.clearCity();
        helperMethods.validateEmptyString(profilePage.getCity());
        profilePage.setCity(city);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getCity(), city);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setValidStateAndClickOnSaveChangesButton() {
        String state = DataGenerator.getValidFullName();
        profilePage.clearState();
        helperMethods.validateEmptyString(profilePage.getState());
        profilePage.setState(state);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getState(), state);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void setInvalidStateAndClickOnSaveChangesButton() {
        String state = DataGenerator.getValidFullName();
        profilePage.clearState();
        helperMethods.validateEmptyString(profilePage.getState());
        profilePage.setState(state);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getState(), state);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void setValidZipCodeAndClickOnSaveChangesButton() {
        String zipCode = DataGenerator.getValidZipCode();
        profilePage.clearZipCode();
        helperMethods.validateEmptyString(profilePage.getZipCode());
        profilePage.setZipCode(zipCode);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getZipCode(), zipCode);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void setInvalidZipCodeAndClickOnSaveChangesButton() {
        String zipCode = DataGenerator.getInvalidZipCode();
        profilePage.clearZipCode();
        helperMethods.validateEmptyString(profilePage.getZipCode());
        profilePage.setZipCode(zipCode);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getZipCode(), zipCode);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void checkEmailAndClickOnSaveChangesButton() {
        String email = "sendfriend@mail.com";
        Assert.assertEquals(profilePage.getEmail(), email);
    }

    @Test
    public void setValidMobilePhoneAndClickOnSaveChangesButton() {
        String number = DataGenerator.getValidPhoneNumber();
        profilePage.clearMobilePhoneNumber();
        helperMethods.validateEmptyString(profilePage.getMobilePhone());
        profilePage.setMobilePhoneNumber(number);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getMobilePhone(), number);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void setInvalidMobilePhoneAndClickOnSaveChangesButton() {
        String number = DataGenerator.getInvalidPhoneNumber();
        profilePage.clearMobilePhoneNumber();
        helperMethods.validateEmptyString(profilePage.getMobilePhone());
        profilePage.setMobilePhoneNumber(number);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getMobilePhone(), number);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test
    public void checkNotifyMeByEmailAndClickOnSaveChangesButton() {
        if (!profilePage.checkStatusNotifyByEmailCheckBox()) {
            profilePage.tickNotifyByEmailCheckBox();
            Assert.assertTrue(profilePage.checkStatusNotifyByEmailCheckBox());
        } else {
            profilePage.tickNotifyByEmailCheckBox();
            Assert.assertFalse(profilePage.checkStatusNotifyByEmailCheckBox());
        }

    }

    @Test(enabled = false)
    public void clearBirthdayAndClickOnSaveChangesButton() {
        String birthday = "";
        profilePage.setBirthday(birthday);
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
        Assert.assertEquals(profilePage.getBirthday(), birthday);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

    @Test(enabled = false)
    public void clearStreetAddressAndClickOnSaveChangesButton() {
        profilePage.clearStreetAddress();
        helperMethods.validateEmptyString(profilePage.getStreetAddress());
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getStreetAddress(), address);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void clearCityAndClickOnSaveChangesButton() {
        profilePage.clearCity();
        helperMethods.validateEmptyString(profilePage.getCity());
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getCity(), city);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void clearStateAndClickOnSaveChangesButton() {
        profilePage.clearState();
        helperMethods.validateEmptyString(profilePage.getState());
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getState(), state);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void clearZipCodeAndClickOnSaveChangesButton() {
        profilePage.clearZipCode();
        helperMethods.validateEmptyString(profilePage.getZipCode());
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getZipCode(), zipCode);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

    @Test(enabled = false)
    public void clearMobilePhoneAndClickOnSaveChangesButton() {
        profilePage.clearMobilePhoneNumber();
        helperMethods.validateEmptyString(profilePage.getMobilePhone());
        profilePage.clickOnSaveChangesButton();
        helperMethods.presenceOfElementLocated(By.xpath(profilePage.getSuccessChangesSavedDialogInnerTextLocator()));
        Assert.assertEquals(profilePage.getSuccessChangesSavedDialogInnerText(), SUCCESS_MESSAGE);
        profilePage.clickOnChangesSavedDialogButton();
//        Assert.assertEquals(profilePage.getMobilePhone(), number);
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
    }

}
