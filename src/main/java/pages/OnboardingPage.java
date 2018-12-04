package pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class OnboardingPage {

    private final String buttonOneTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div/div[2]/p";
    private final String buttonOneLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[1]/button";
    private final String buttonTwoTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[3]/div/div/div/div[2]/h5";
    private final String buttonTwoLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[2]/button";
    private final String buttonThreeTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[4]/div/div/div/div[2]/h5";
    private final String buttonThreeLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[3]/button";
    private final String buttonFourTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[5]/div/div/div/div[2]/h5";
    private final String buttonFourLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[4]/button";
    private final String buttonFiveTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[6]/div/div/div/div[2]/h5";
    private final String buttonFiveLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[4]/button";
    private final String buttonSixTitleLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/div[3]/div/div/div/div[2]/h5";
    private final String buttonSixLocator = "//*[@id=\"root\"]/div/div/div[1]/div/div/div/ul/li[6]/button";
    private final String signUpButtonLocator = "/html/body/div/div/div/div[3]/a[1]";
    private final String loginButtonLocator = "/html/body/div/div/div/div[3]/a[2]";
    private final String needHelpLocator = "/html/body/div/div/div/div[3]/div/a";

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonOneTitleLocator)
    private WebElement buttonOneTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonOneLocator)
    private WebElement buttonOne;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonTwoTitleLocator)
    private WebElement buttonTwoTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonTwoLocator)
    private WebElement buttonTwo;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonThreeTitleLocator)
    private WebElement buttonThreeTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonThreeLocator)
    private WebElement buttonThree;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonFourTitleLocator)
    private WebElement buttonFourTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonFourLocator)
    private WebElement buttonFour;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonFiveTitleLocator)
    private WebElement buttonFiveTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonFiveLocator)
    private WebElement buttonFive;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonSixTitleLocator)
    private WebElement buttonSixTitle;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = buttonSixLocator)
    private WebElement buttonSix;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = signUpButtonLocator)
    private WebElement signUpButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = loginButtonLocator)
    private WebElement loginButton;

    @Getter(AccessLevel.NONE)
    @FindBy(how = How.XPATH, using = needHelpLocator)
    private WebElement needHelp;

    public void clickOnButtonOne() {
        buttonOne.click();
    }

    public void clickOnButtonTwo() {
        buttonTwo.click();
    }

    public void clickOnButtonThree() {
        buttonThree.click();
    }

    public void clickOnButtonFour() {
        buttonFour.click();
    }

    public void clickOnButtonFive() {
        buttonFive.click();
    }

    public void clickOnButtonSix() {
        buttonSix.click();
    }

    public void clickOnSignUp() {
        signUpButton.click();
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public String checkNeedHelpText() {
        return needHelp.getText();
    }

}
