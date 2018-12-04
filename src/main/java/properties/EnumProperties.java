package properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumProperties {

    ENVIRONMENT_URL("environments.test.url"),
    WINDOW_DIMENSION_WIDTH("windows.dimension.width"),
    WINDOW_DIMENSION_HEIGHT("windows.dimension.height"),
    SCREENSHOTS_PATHNAME("screenshots.pathname");

    private String value;

}
