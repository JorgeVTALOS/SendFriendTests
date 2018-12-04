package pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class SignupPage {

    private final String fullNameLocator = "fullName";
    private final String emailLocator = "email";
    private final String phoneNumberLocator = "number_3";
    private final String passwordLocator = "password";
    private final String eyeIconPasswordLocator = "/html/body/div/div/div[3]/form/div[4]/div/div[2]/button";
    private final String confirmPasswordLocator = "confirmPassword";
    private final String eyeIconConfirmPasswordLocator = "/html/body/div/div/div[3]/form/div[5]/div/div[2]/button";
    private final String validPasswordTextLocator = "/html/body/div/div/div[3]/form/div[4]/p";
    private final String validConfirmPasswordTextLocator = "//*[@id=\"root\"]/div/div[3]/form/div[5]/p";
    private final String agreeTCandPrivacyPolicyCheckBoxLocator = "checkbox_6";
    private final String notifyOffersCheckBoxLocator = "checkbox_7";
    private final String submitButtonLocator = "/html/body/div/div/div[3]/form/button";
    private final String logInLinkLocator = "/html/body/div/div/div[5]/p/a";
    private final String checkYourEmailToVerifyAccountTextLocator = "/html/body/div/div/div[4]/span";
    private final String signupWithFacebookButtonLocator = "/html/body/div/div/button";
    private final String thisFieldIsRequiredNameErrorTextLocator = "/html/body/div/div/div[3]/form/div[1]/p";
    private final String thisFieldIsRequiredEmailErrorTextLocator = "/html/body/div/div/div[3]/form/div[2]/p";
    private final String thisFieldIsRequiredPasswordErrorTextLocator = "/html/body/div/div/div[3]/form/div[4]/p";
    private final String thisFieldIsRequiredConfirmPasswordErrorTextLocator = "/html/body/div/div/div[3]/form/div[5]/p";
    private final String youMustAcceptTheTermsOfServiceAndConditionsErrorTextLocator = "/html/body/div/div/div[3]/form/div[6]/div[1]/p";
    private final String confirmPasswordDoesNotMatchPasswordErrorTextLocator = "//*[@id=\"root\"]/div/div[3]/form/div[5]/p";
    private final String shouldBeAValidEmailErrorTextLocator = "/html/body/div/div/div[3]/form/div[2]/p";
    private final String shouldBeAValidPasswordErrorTextLocator = "/html/body/div/div/div[3]/form/div[4]/p";
    private final String shouldBeAValidConfirmPasswordErrorTextLocator = "//*[@id=\"root\"]/div/div[3]/form/div[5]/p";
    private final String badInputPhoneNumberErrorTextLocator = "/html/body/div/div/div[3]/form/div[3]/p";

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = fullNameLocator)
    private WebElement fullName;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = emailLocator)
    private WebElement email;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = phoneNumberLocator)
    private WebElement phoneNumber;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = passwordLocator)
    private WebElement password;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = eyeIconPasswordLocator)
    private WebElement eyeIconPassword;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = confirmPasswordLocator)
    private WebElement confirmPassword;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = eyeIconConfirmPasswordLocator)
    private WebElement eyeIconConfirmPassword;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.CLASS_NAME, using = validPasswordTextLocator)
    private WebElement validPasswordText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.CLASS_NAME, using = validConfirmPasswordTextLocator)
    private WebElement validConfirmPasswordText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.ID, using = agreeTCandPrivacyPolicyCheckBoxLocator)
    private WebElement agreeTCandPrivacyPolicyCheckBox;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.ID, using = notifyOffersCheckBoxLocator)
    private WebElement notifyOffersCheckBox;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = submitButtonLocator)
    private WebElement submitButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = logInLinkLocator)
    private WebElement logInLink;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = checkYourEmailToVerifyAccountTextLocator)
    private WebElement checkYourEmailToVerifyAccountText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = signupWithFacebookButtonLocator)
    private WebElement signupWithFacebookButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredNameErrorTextLocator)
    private WebElement thisFieldIsRequiredNameErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredEmailErrorTextLocator)
    private WebElement thisFieldIsRequiredEmailErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredPasswordErrorTextLocator)
    private WebElement thisFieldIsRequiredPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = thisFieldIsRequiredConfirmPasswordErrorTextLocator)
    private WebElement thisFieldIsRequiredConfirmPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = youMustAcceptTheTermsOfServiceAndConditionsErrorTextLocator)
    private WebElement youMustAcceptTheTermsOfServiceAndConditionsErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = confirmPasswordDoesNotMatchPasswordErrorTextLocator)
    private WebElement confirmPasswordDoesNotMatchPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = shouldBeAValidEmailErrorTextLocator)
    private WebElement shouldBeAValidEmailErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = shouldBeAValidPasswordErrorTextLocator)
    private WebElement shouldBeAValidPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = shouldBeAValidConfirmPasswordErrorTextLocator)
    private WebElement shouldBeAValidConfirmPasswordErrorText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = badInputPhoneNumberErrorTextLocator)
    private WebElement badInputPhoneNumberErrorText;

    //--------------------- Actions Model

    public void setFullName(String str) {
        this.fullName.sendKeys(str);
    }

    public void setEmail(String str) {
        this.email.sendKeys(str);
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber.sendKeys(str);
    }

    public void setPassword(String str) {
        this.password.sendKeys(str);
    }

    public void clickOnEyeIconPassword() {
        this.eyeIconPassword.click();
    }

    public String checkValidPasswordText() {
        return this.validPasswordText.getText();
    }

    public String checkValidConfirmPasswordText() {
        return this.validConfirmPasswordText.getText();
    }

    public void setConfirmPassword(String str) {
        this.confirmPassword.sendKeys(str);
    }

    public void clickOnEyeIconConfirmPassword() {
        this.eyeIconConfirmPassword.click();
    }

    public void tickAgreeTCandPrivacyPolicyCheckBox() {
        this.agreeTCandPrivacyPolicyCheckBox.click();
    }

    public void tickNotifyByEmailCheckBox() {
        this.notifyOffersCheckBox.click();
    }

    public void clickOnSubmitButton() {
        this.submitButton.click();
    }

    public void clickOnSigninButton() {
        this.logInLink.click();
    }

    public String checkYourEmailToVerifyAccountText() {
        return this.checkYourEmailToVerifyAccountText.getText();
    }

    public void clickOnSignupWithFacebookButton() {
        this.signupWithFacebookButton.click();
    }

    //--------------------- Error Labels

    public String checkThisFieldIsRequiredNameErrorText() {
        return this.thisFieldIsRequiredNameErrorText.getText();
    }

    public String checkThisFieldIsRequiredEmailErrorText() {
        return this.thisFieldIsRequiredEmailErrorText.getText();
    }

    public String checkThisFieldIsRequiredPasswordErrorText() {
        return this.thisFieldIsRequiredPasswordErrorText.getText();
    }

    public String checkThisFieldIsRequiredConfirmPasswordErrorText() {
        return this.thisFieldIsRequiredConfirmPasswordErrorText.getText();
    }

    public String checkYouMustAcceptTheTermsOfServiceAndConditionsErrorText() {
        return this.youMustAcceptTheTermsOfServiceAndConditionsErrorText.getText();
    }

    public String checkConfirmPasswordDoesNotMatchPasswordErrorText() {
        return this.confirmPasswordDoesNotMatchPasswordErrorText.getText();
    }

    public String checkShouldBeAValidPasswordErrorText() {
        return this.shouldBeAValidPasswordErrorText.getText();
    }

    public String checkShouldBeAValidConfirmPasswordErrorText() {
        return this.shouldBeAValidConfirmPasswordErrorText.getText();
    }

    public String checkBadInputPhoneNumberErrorText() {
        return this.badInputPhoneNumberErrorText.getText();
    }

    //-------------------- Get Attributes

    public String getPasswordFieldAttribute(String attribute) {
        return this.password.getAttribute(attribute);
    }

    public String getConfirmPasswordFieldAttribute(String attribute) {
        return this.confirmPassword.getAttribute(attribute);
    }
}
