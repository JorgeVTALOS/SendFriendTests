package pages;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class ProfilePage {

    private final String myProfileTitleLocator = "//*[@id=\"root\"]/div[2]/div/header/div[2]/h6";
    private final String pencilIconFullNameLocator = "//*[@id=\"root\"]/div[2]/div/div/div/div/div/button";
    private final String fullNameInputLocator = "//*[@id=\"root\"]/div[2]/div/div/div/div/input";
    private final String fullNameLabelLocator = "//*[@id=\"root\"]/div[2]/div/div/div/div/h4";
    private final String emailLocator = "//*[@id=\"root\"]/div[2]/div/div/div/p";
    private final String birthdayLocator = "birthday";
    private final String streetAddressLocator = "address";
    private final String cityLocator = "city";
    private final String stateLocator = "state";
    private final String zipCodeLocator = "zip";
    private final String mobilePhoneLocator = "phoneNumber";
    private final String notifyOffersCheckBoxLocatorLocator = "checkbox_6";
    private final String saveChangesButtonLocator = "//*[@id=\"root\"]/div[2]/div/div/form/button";
    private final String successChangesSavedDialogInnerTextLocator = "//*[@id=\"alert-dialog-description\"]";
    private final String successChangesSavedDialogButtonLocator = "/html/body/div[2]/div[2]/div[3]/button/span[1]";

    @Getter(AccessLevel.NONE)
    @Setter
    private Actions actions;

    @Getter(AccessLevel.NONE)
    @Setter
    private JavascriptExecutor javascriptExecutor;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = myProfileTitleLocator)
    private WebElement myProfileTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = pencilIconFullNameLocator)
    private WebElement pencilIconFullName;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = fullNameInputLocator)
    private WebElement fullNameInput;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = fullNameLabelLocator)
    private WebElement fullNameLabel;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = emailLocator)
    private WebElement email;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = birthdayLocator)
    private WebElement birthday;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = streetAddressLocator)
    private WebElement streetAddress;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = cityLocator)
    private WebElement city;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = stateLocator)
    private WebElement state;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = zipCodeLocator)
    private WebElement zipCode;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = mobilePhoneLocator)
    private WebElement mobilePhone;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.NAME, using = notifyOffersCheckBoxLocatorLocator)
    private WebElement notifyOffersCheckBoxLocator;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = saveChangesButtonLocator)
    private WebElement saveChangesButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = successChangesSavedDialogInnerTextLocator)
    private WebElement successChangesSavedDialogText;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = successChangesSavedDialogButtonLocator)
    private WebElement successChangesSavedDialogButton;

    public void clickOnPencilIcon() {
        pencilIconFullName.click();
    }

    public void clearFullName() {
        fullNameInput.clear();
    }

    public void setFullNameInput(String str) {
        fullNameInput.sendKeys(str);
    }

    public String getFullNameLabel() {
        return fullNameLabel.getText();
    }

    public String getBirthday() {
        return birthday.getAttribute("value");
    }

    public void setBirthday(String str) {
        birthday.sendKeys(str);
    }

    public void clearBirthday() {
        scrollIntoView(birthday);
        clearFieldHelper(
                birthday,
                getBirthday().length()
        );
    }

    public String getStreetAddress() {
        return streetAddress.getAttribute("value");
    }

    public void setStreetAddress(String str) {
        streetAddress.sendKeys(str);
    }

    public void clearStreetAddress() {
        scrollIntoView(streetAddress);
        clearFieldHelper(
                streetAddress,
                getStreetAddress().length()
        );
    }

    public String getCity() {
        return city.getAttribute("value");
    }

    public void setCity(String str) {
        city.sendKeys(str);
    }

    public void clearCity() {
        scrollIntoView(city);
        clearFieldHelper(
                city,
                getCity().length()
        );
    }

    public String getState() {
        return state.getAttribute("value");
    }

    public void setState(String str) {
        state.sendKeys(str);
    }

    public void clearState() {
        scrollIntoView(state);
        clearFieldHelper(
                state,
                getState().length()
        );
    }

    public String getZipCode() {
        return zipCode.getAttribute("value");
    }

    public void setZipCode(String str) {
        zipCode.sendKeys(str);
    }

    public void clearZipCode() {
        scrollIntoView(zipCode);
        clearFieldHelper(
                zipCode,
                getZipCode().length()
        );
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String str) {
        email.sendKeys(str);
    }

    public void clearEmail() {
        scrollIntoView(email);
        clearFieldHelper(
                email,
                getEmail().length()
        );
    }

    public String getMobilePhone() {
        return mobilePhone.getAttribute("value");
    }

    public void setMobilePhoneNumber(String str) {
        mobilePhone.sendKeys(str);
    }

    public void clearMobilePhoneNumber() {
        mobilePhone.click();
        clearFieldHelper(mobilePhone, getMobilePhone().length());

    }

    public void tickNotifyByEmailCheckBox() {
        notifyOffersCheckBoxLocator.click();
    }

    public boolean checkStatusNotifyByEmailCheckBox() {
        return notifyOffersCheckBoxLocator.isSelected();
    }

    public void clickOnSaveChangesButton() {
        saveChangesButton.click();
    }

    public String getSuccessChangesSavedDialogInnerText() {
        return successChangesSavedDialogText.getText();
    }

    public void clickOnChangesSavedDialogButton() {
        successChangesSavedDialogButton.click();
    }

    private void clearFieldHelper(WebElement element, int length) {
        element.sendKeys(Keys.ARROW_UP);
        for (int i = 0; i < length; i++) {
            actions.moveToElement(element).sendKeys(Keys.DELETE).perform();
        }

    }

    public void scrollIntoView(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
