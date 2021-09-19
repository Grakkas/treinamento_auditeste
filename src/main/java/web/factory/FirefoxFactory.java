package web.factory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory {

    FirefoxDriver firefoxDriver = null;

    public FirefoxDriver abrirFirefox() {
        firefoxDriver = new FirefoxDriver(setFirefoxOptions());
        return firefoxDriver;
    }

    private FirefoxOptions setFirefoxOptions() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(
                "--start-maximized"
        );
        return firefoxOptions;
    }
}
