package web.factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory {

    protected ChromeDriver chromeDriver = null;

    public ChromeDriver abrirGoogleChrome() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(setChromeOptions());
        }
        return chromeDriver;
    }

    private ChromeOptions setChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "start-maximized"
        );
        return chromeOptions;
    }
}
