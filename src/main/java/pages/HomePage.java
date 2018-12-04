package pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class HomePage {

    private final String homeSendFriendImageLocator = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/figure/img";
    private final String homeTabLocator = "//*[@id=\"root\"]/div[2]/div/div[4]/div/a[1]";
    private final String activityTabLocator = "//*[@id=\"root\"]/div[2]/div/div[4]/div/a[2]";
    private final String recipientsTabLocator = "//*[@id=\"root\"]/div[2]/div/div[4]/div/a[3]";
    private final String accountsTabLocator = "//*[@id=\"root\"]/div[2]/div/div[4]/div/a[4]";
    private final String activityTitleLocator = "//*[@id=\"root\"]/div[2]/div/div[3]/div/h3";
    private final String recipientsTitleLocator = "//*[@id=\"root\"]/div[2]/div/div[3]/div/h3";
    private final String accountsTitleLocator = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/h4";
    private final String sendMoneyButtonLocator = "//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/button";
    private final String sendMoneyTitleAfterPressSendMoneyButtonLocator = "/html/body/div[2]/div[2]/div/h3";
    private final String sendMoneyCloseButtonInSendMoneyMenuDialogLocator = "//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/button";
    private final String toABankAccountSendMoneyLinkLocator = "/html/body/div[2]/div[2]/div/div/a";
    private final String hamburgerIconLocator = "/html/body/div/div[2]/div/div[2]/div[1]/button";
    private final String helpIconLocator = "/html/body/div/div[2]/div/div[2]/div[2]/button";
    private final String LoadingWrapperLocator = "loading-wrapper";

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = homeTabLocator)
    private WebElement homeTab;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = activityTabLocator)
    private WebElement activityTab;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = recipientsTabLocator)
    private WebElement recipientsTab;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = accountsTabLocator)
    private WebElement accountsTab;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = homeSendFriendImageLocator)
    private WebElement homeSendFriendImage;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = activityTitleLocator)
    private WebElement activityImage;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = recipientsTitleLocator)
    private WebElement recipientsButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = accountsTitleLocator)
    private WebElement recipientsImage;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = sendMoneyButtonLocator)
    private WebElement sendMoneyButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = sendMoneyTitleAfterPressSendMoneyButtonLocator)
    private WebElement sendMoneyTitleAfterPressButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = sendMoneyCloseButtonInSendMoneyMenuDialogLocator)
    private WebElement sendMoneyCloseButtonAfterPressButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = toABankAccountSendMoneyLinkLocator)
    private WebElement toABankAccountSendMoneyLink;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = hamburgerIconLocator)
    private WebElement hamburgerIcon;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = helpIconLocator)
    private WebElement helpIcon;

    public void clickOnHomeTab() {
        homeTab.click();
    }

    public void clickOnActivityTab() {
        activityTab.click();
    }

    public void clickOnRecipientsTab() {
        recipientsTab.click();
    }

    public void clickOnAccountsTab() {
        accountsTab.click();
    }

    public void clickOnSendMoneyButton() {
        sendMoneyButton.click();
    }

    public void clickOnCloseButtonInSendMoneyMenuDialog() {
        sendMoneyCloseButtonAfterPressButton.click();
    }

    public void clickOnToABankAccountSendMoneyLink() {
        toABankAccountSendMoneyLink.click();
    }

    public void clickOnHamburgerIcon() {
        hamburgerIcon.click();
    }

    public void clickOnHelpIcon() {
        helpIcon.click();
    }
}
