package pages;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class HamburgerMenuPage {

    private final String vewProfileLinkLocator = "/html/body/div[2]/div[2]/div/div/div[1]/div/a";
    private final String homeButtonLocator = "/html/body/div[2]/div[2]/div/div/div[2]/a";
    private final String referToAFriendButtonLocator = "/html/body/div[2]/div[2]/div/div/div[2]/button[1]";
    private final String termsAndConditionsButtonLocator = "/html/body/div[2]/div[2]/div/div/div[2]/button[2]";
    private final String privacyPolicyButtonLocator = "/html/body/div[2]/div[2]/div/div/div[2]/button[3]";
    private final String helpButtonLocator = "/html/body/div[2]/div[2]/div/div/div[2]/button[4]";
    private final String logOutButtonLocator = "/html/body/div[2]/div[2]/div/div/div[3]/button";

    @Getter(AccessLevel.NONE)
    @Setter
    private Actions actions;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = vewProfileLinkLocator)
    private WebElement vewProfileLink;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = homeButtonLocator)
    private WebElement homeButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = referToAFriendButtonLocator)
    private WebElement referToAFriendButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = termsAndConditionsButtonLocator)
    private WebElement termsAndConditionsButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = privacyPolicyButtonLocator)
    private WebElement privacyPolicyButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = helpButtonLocator)
    private WebElement helpButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = logOutButtonLocator)
    private WebElement logOutButton;

    public void clickOnVewProfileLink() {
        vewProfileLink.click();
    }

    public void clickOnHomeButton() {
        homeButton.click();
    }

    public void clickOnReferToAFriendButton() {
        referToAFriendButton.click();
    }

    public void clickOnTermsAndConditionsButton() {
        termsAndConditionsButton.click();
    }

    public void clickOnPrivacyPolicyButton() {
        privacyPolicyButton.click();
    }

    public void clickOnHelpButton() {
        helpButton.click();
    }

    public void clickOnLogOutButton() {
        logOutButton.click();
    }


}
