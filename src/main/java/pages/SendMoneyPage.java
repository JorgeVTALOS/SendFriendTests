package pages;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class SendMoneyPage {

    private final String sendMoneyTitleLocator = "/html/body/div[1]/div/div/h1";
    private final String closeButtonLocator = "//*[@id=\"root\"]/div/header/div/button";
    private final String recipientNameFieldLocator = "//*[@id=\"downshift-0-input\"]";
    private final String yourBackAccountSelectorLocator = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div";
    private final String youSendFieldLocator = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/input";
    private final String recipientGetsFieldLocator = "/html/body/div[1]/div/div/div[2]/div[2]/div[1]/div/input";
    private final String rateLabelLocator = "/html/body/div[1]/div/div/div[3]/div[1]/span";
    private final String transactionFeeLabelLocator = "/html/body/div[1]/div/div/div[3]/div[2]/span";
    private final String totalYouPayLabelLocator = "//*[@id=\"root\"]/div/div/div[3]/div[3]/span";
    private final String continueButtonLocator = "//*[@id=\"root\"]/div/div/div[4]/button";

    @Getter(AccessLevel.NONE)
    @Setter
    private Actions actions;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = closeButtonLocator)
    private WebElement closeButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = recipientNameFieldLocator)
    private WebElement recipientNameField;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = yourBackAccountSelectorLocator)
    private WebElement yourBackAccountSelector;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = youSendFieldLocator)
    private WebElement youSendField;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = recipientGetsFieldLocator)
    private WebElement recipientGetsField;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = rateLabelLocator)
    private WebElement rateLabel;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = transactionFeeLabelLocator)
    private WebElement transactionFeeLabel;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = totalYouPayLabelLocator)
    private WebElement totalYouPayLabel;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = continueButtonLocator)
    private WebElement continueButton;

    public void clickOnCloseButton() {
        closeButton.click();
    }

    public void setRecipientNameField(String str) {
        recipientNameField.sendKeys(str);
    }

    public void setYourBackAccountSelectorLocator() {
//        return yourBackAccountSelector.();
    }

    public String getYouSendField() {
        return youSendField.getText();
    }

    public void setYouSendField(Double value) {
        actions.moveToElement(youSendField).click().sendKeys(String.valueOf(value)).perform();
    }

    public void clearYouSendField() {
        youSendField.clear();
    }

    public String getRecipientGetsField() {
        return recipientGetsField.getAttribute("value");
    }

    public String getRateLabel() {
        String val = rateLabel.getText();
        return val.substring(val.indexOf("=") + 2, val.indexOf("PHP") - 1);
    }

    public String getTransactionFee() {
        String val = transactionFeeLabel.getText();
        return val.substring(0, val.indexOf("USD") - 1);
    }

    public String getTotalYouPayLabel() {
        String val = totalYouPayLabel.getText();
        return val.substring(0, val.indexOf("USD") - 1);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

}
