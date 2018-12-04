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
import pages.SendMoneyPage;
import properties.HelperMethods;

public class HomePageTests {


    private WebDriver driver;
    private SendMoneyPage sendMoneyPage;
    private HamburgerMenuPage hamburgerMenuPage;
    private HelperMethods helperMethods;
    private HomePage homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();

        helperMethods = new HelperMethods(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
        sendMoneyPage = PageFactory.initElements(driver, SendMoneyPage.class);
        hamburgerMenuPage = PageFactory.initElements(driver, HamburgerMenuPage.class);
        helperMethods.login();

    }

    @AfterTest
    public void closeResources() {
        driver.quit();
    }

    @Test
    public void clickOnHomeTabAndClickOnSendMoneyButton() {
        homePage.clickOnHomeTab();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getHomeSendFriendImageLocator()));
        continueWithTestAndCheckToBankAccountLinkAndCloseButtonInSendMoneyPageAndCloseButtonInSendMoneyMenuDialog();
        continueWithTestAndCheckHamburgerMenuAndCloseIt();
        continueWithTestAndCheckHelpButton();
    }

    @Test
    public void clickOnActivityTabAndClickOnSendMoneyButton() {
        homePage.clickOnActivityTab();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getActivityTitleLocator()));
        continueWithTestAndCheckToBankAccountLinkAndCloseButtonInSendMoneyPageAndCloseButtonInSendMoneyMenuDialog();
        continueWithTestAndCheckHamburgerMenuAndCloseIt();
        continueWithTestAndCheckHelpButton();

    }

    @Test
    public void clickOnRecipientsTabAndClickOnSendMoneyButton() {
        homePage.clickOnRecipientsTab();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getRecipientsTitleLocator()));
        continueWithTestAndCheckToBankAccountLinkAndCloseButtonInSendMoneyPageAndCloseButtonInSendMoneyMenuDialog();
        continueWithTestAndCheckHamburgerMenuAndCloseIt();
        continueWithTestAndCheckHelpButton();

    }

    @Test
    public void clickOnAccountsTabAndClickOnSendMoneyButton() {
        homePage.clickOnAccountsTab();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getAccountsTitleLocator()));
        continueWithTestAndCheckToBankAccountLinkAndCloseButtonInSendMoneyPageAndCloseButtonInSendMoneyMenuDialog();
        continueWithTestAndCheckHamburgerMenuAndCloseIt();
        continueWithTestAndCheckHelpButton();

    }


    private void continueWithTestAndCheckToBankAccountLinkAndCloseButtonInSendMoneyPageAndCloseButtonInSendMoneyMenuDialog() {
        homePage.clickOnSendMoneyButton();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getSendMoneyCloseButtonInSendMoneyMenuDialogLocator()));
        homePage.clickOnToABankAccountSendMoneyLink();
        helperMethods.presenceOfElementLocated(By.xpath(sendMoneyPage.getSendMoneyTitleLocator()));
        sendMoneyPage.clickOnCloseButton();
        helperMethods.presenceOfElementLocated(By.xpath(homePage.getSendMoneyCloseButtonInSendMoneyMenuDialogLocator()));
        homePage.clickOnCloseButtonInSendMoneyMenuDialog();
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
        helperMethods.invisibilityOfElementLocated(By.className(homePage.getLoadingWrapperLocator()));
    }

    // TODO : This method is missing a way to close the menu without refresh
    private void continueWithTestAndCheckHamburgerMenuAndCloseIt() {
        homePage.clickOnHamburgerIcon();
        helperMethods.presenceOfElementLocated(By.xpath(hamburgerMenuPage.getLogOutButtonLocator()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();
        helperMethods.invisibilityOfElementLocated(By.className(homePage.getLoadingWrapperLocator()));
    }

    // TODO : Implementation is missing
    private void continueWithTestAndCheckHelpButton() {

    }


}
