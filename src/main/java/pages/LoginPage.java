package pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class LoginPage {

    private final String emailLocator = "email";
    private final String passwordLocator = "password";
    private final String eyeIconPasswordLocator = "/html/body/div/div/form/div[2]/div/div/button";
    private final String signinButtonLocator = "/html/body/div/div/form/button";
    private final String loginWithFacebookButtonLocator = "//*[@id=\"facebook-login-button\"]";
    private final String forgotYourPasswordLinkLocator = "/html/body/div/div/form/div[4]/a";
    private final String thisFieldIsRequiredEmailErrorTextLocator = "/html/body/div/div/form/div[1]/p";
    private final String thisFieldIsRequiredPasswordErrorTextLocator = "/html/body/div/div/form/div[2]/p";
    private final String shouldBeAValidEmailErrorTextLocator = "/html/body/div/div/form/div[1]/p";
    private final String shouldBeAValidPasswordErrorTextLocator = "/html/body/div/div/form/div[2]/p";

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = emailLocator)
    private WebElement email;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = passwordLocator)
    private WebElement password;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = eyeIconPasswordLocator)
    private WebElement eyeIconPassword;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = signinButtonLocator)
    private WebElement signinButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = loginWithFacebookButtonLocator)
    private WebElement loginWithFacebookButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = forgotYourPasswordLinkLocator)
    private WebElement forgotYourPasswordLink;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredEmailErrorTextLocator)
    private WebElement thisFieldIsRequiredEmailErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredPasswordErrorTextLocator)
    private WebElement thisFieldIsRequiredPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = shouldBeAValidEmailErrorTextLocator)
    private WebElement shouldBeAValidEmailErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = shouldBeAValidPasswordErrorTextLocator)
    private WebElement shouldBeAValidPasswordErrorText;

    //--------------------- Actions Model

    public void setEmail(String str) {
        email.sendKeys(str);
    }

    public void setPassword(String str) {
        password.sendKeys(str);
    }

    public void clickOnEyeIconPassword() {
        eyeIconPassword.click();
    }

    public void clickOnSigninButton() {
        signinButton.click();
    }

    public void clickOnLoginWithFacebookButton() {
        loginWithFacebookButton.click();
    }

    public void clickOnForgotYourPasswrodLink() {
        forgotYourPasswordLink.click();
    }

    //--------------------- Error Labels

    public String checkThisFieldIsRequiredEmailErrorText() {
        return thisFieldIsRequiredEmailErrorText.getText();
    }

    public String checkThisFieldIsRequiredPasswordErrorText() {
        return thisFieldIsRequiredPasswordErrorText.getText();
    }

    public String checkShouldBeAValidEmailErrorText() {
        return shouldBeAValidEmailErrorText.getText();
    }

    public String checkShouldBeAValidPasswordErrorText() {
        return thisFieldIsRequiredPasswordErrorText.getText();
    }

    //-------------------- Get Attributes

    public String getPasswordFieldAttribute(String attribute) {
        return password.getAttribute(attribute);
    }

}
