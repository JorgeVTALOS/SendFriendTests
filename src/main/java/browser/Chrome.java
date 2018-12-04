package browser;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.ApplicationPropertiesSingleton;
import properties.EnumProperties;


public class Chrome implements Driver {


    private final ApplicationPropertiesSingleton properties;

    public Chrome() {
        this.properties = ApplicationPropertiesSingleton.getInstance();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_WIDTH)),
                Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_HEIGHT))));
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL));
        return driver;
    }

}
