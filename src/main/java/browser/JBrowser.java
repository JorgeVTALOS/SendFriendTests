package browser;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import properties.ApplicationPropertiesSingleton;
import properties.EnumProperties;


public class JBrowser implements Driver {


    private final ApplicationPropertiesSingleton properties;

    public JBrowser() {
        this.properties = ApplicationPropertiesSingleton.getInstance();
    }

    @Override
    public WebDriver getDriver() {
        WebDriver driver = new JBrowserDriver(Settings.builder().ajaxWait(20000).build());
        driver.manage().window().setSize(new Dimension(Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_WIDTH)), Integer.parseInt(properties.getProperty(EnumProperties.WINDOW_DIMENSION_HEIGHT))));
        driver.get(properties.getProperty(EnumProperties.ENVIRONMENT_URL));
        return driver;
    }

}
