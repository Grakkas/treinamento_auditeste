package web.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import web.factory.DriverFactory;
import web.factory.DriverType;

public class Hooks {

    public static Scenario currentScenario;

    @Before
    public void abrirNavegador() {
        DriverFactory.getInstancia().setDriver(DriverType.CHROME);
        DriverFactory.getInstancia().getDriver().get("https://saucedemo.com");
    }

    @After
    public void fecharNavegador() {
        DriverFactory.getInstancia().quitDriver();
    }

    @BeforeStep
    public Scenario currentScenario(Scenario scenario) {
        currentScenario = scenario;
        return scenario;
    }
}
