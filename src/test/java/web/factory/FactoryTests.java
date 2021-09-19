package web.factory;

import org.junit.Test;

public class FactoryTests {

    @Test
    public void deveAbrirChrome() {
        ChromeFactory chromeFactory = new ChromeFactory();
        chromeFactory.abrirGoogleChrome();
    }

    @Test
    public void deveAbrirFirefox() {
        FirefoxFactory firefoxFactory = new FirefoxFactory();
        firefoxFactory.abrirFirefox();
    }
}
