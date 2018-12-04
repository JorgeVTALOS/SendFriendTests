import browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SendMoneyPage;
import properties.ApplicationPropertiesSingleton;
import properties.HelperMethods;

public class SendMoneyPageTests {


    private WebDriver driver;
    private SendMoneyPage sendMoneyPage;
    private ApplicationPropertiesSingleton properties;
    private HelperMethods helperMethods;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
        driver = BrowserFactory.getDriver(browser).getDriver();
        driver.manage().deleteAllCookies();
        helperMethods = new HelperMethods(driver);
        sendMoneyPage = PageFactory.initElements(driver, SendMoneyPage.class);
        sendMoneyPage.setActions(new Actions(driver));
        properties = ApplicationPropertiesSingleton.getInstance();

        helperMethods.login();
        helperMethods.getSendMoneyPage();
    }

    @AfterTest
    public void closeResources() {
        driver.quit();
    }

    //TODO: For any reason when I run the method RecipientGetsField doesn't work, If I debug it runs normally
    @Test
    public void setValidRecipientAndChooseABankAccountAndSetValidAmountAndCheckRecipientGetsAndCheckTotalYouPayAndClickOnContinue() throws InterruptedException {
        //sendMoneyPage.setRecipientNameField("Recipient1");
        sendMoneyPage.setYourBackAccountSelectorLocator();
        double amountToSend = 200;
        sendMoneyPage.clearYouSendField();
        sendMoneyPage.setYouSendField(amountToSend);
        new WebDriverWait(driver, 10).until(
                (driver) -> sendMoneyPage.getRecipientGetsField() != null && !sendMoneyPage.getRecipientGetsField().equals(""));
        Assert.assertEquals(Double.valueOf(sendMoneyPage.getRecipientGetsField()),
                Double.valueOf(sendMoneyPage.getRateLabel()) * amountToSend);
        Assert.assertEquals(Double.valueOf(sendMoneyPage.getTotalYouPayLabel()),
                amountToSend + Double.valueOf(sendMoneyPage.getTransactionFee()));
        driver.navigate().refresh();
        helperMethods.waitForPageToLoad();

    }

}
