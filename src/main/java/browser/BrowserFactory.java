package browser;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NotFoundException;

@Slf4j
public class BrowserFactory {

    public static Driver getDriver(final String browser) {
        switch (browser) {
            case "firefox":
                return new Firefox();
            case "chrome":
                return new Chrome();
            case "jbrowser":
                return new JBrowser();
            default:
                throw new NotFoundException(String.format("There is not configuration for '%s' browser", browser));
        }
    }

}
