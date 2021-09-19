package web.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory instancia = null;
    private WebDriver driver = null;
    private ChromeFactory chromeFactory = null;
    private FirefoxFactory firefoxFactory = null;

    public static DriverFactory getInstancia() {
        if (instancia == null) {
            instancia = new DriverFactory();
        }
        return instancia;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(DriverType driverType) {
        if (driverType.equals(DriverType.CHROME)) {
            if (chromeFactory == null) {
                chromeFactory = new ChromeFactory();
            }
            driver = chromeFactory.abrirGoogleChrome();
        }
        if (driverType.equals(DriverType.FIREFOX)) {
            if (firefoxFactory == null) {
                firefoxFactory = new FirefoxFactory();
            }
            driver = firefoxFactory.abrirFirefox();
        }
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
        chromeFactory = null;
        firefoxFactory = null;
    }
}
