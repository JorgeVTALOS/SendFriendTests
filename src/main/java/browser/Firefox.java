package browser;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import properties.ApplicationPropertiesSingleton;
import properties.EnumProperties;

public class Firefox implements Driver {

    private final ApplicationPropertiesSingleton properties;

    public Firefox() {
        this.properties = ApplicationPropertiesSingleton.getInstance();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_WIDTH)), Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_HEIGHT))));
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL));
        return driver;
    }

}
