package properties;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ApplicationPropertiesSingleton {

    private static final Properties properties = new Properties();
    private static ApplicationPropertiesSingleton applicationPropertiesSingleton = null;

    private ApplicationPropertiesSingleton() {
    }

    public static synchronized ApplicationPropertiesSingleton getInstance() {
        if (applicationPropertiesSingleton == null) {
            applicationPropertiesSingleton = new ApplicationPropertiesSingleton();
            try (InputStream input = new FileInputStream("./src/main/resources/application.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return applicationPropertiesSingleton;
    }

    public String getProperty(EnumProperties property) {
        return properties.getProperty(property.getValue());
    }

}
