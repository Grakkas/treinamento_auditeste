package web.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import util.PageHelper;
import web.factory.DriverFactory;
import web.pages.BasePage;

import java.util.Map;

public class BasePageSteps {

    private final BasePage basePage = new BasePage();

    @Dado("que estou navegando na pagina principal")
    public void queEstouNavegandoNaPaginaPrincipal() {
        Assert.assertEquals("Swag Labs", DriverFactory.getInstancia().getDriver().getTitle());
    }

    @Dado("realizar o preenchimento das informacoes de login")
    public void realizarOPreenchimentoDasInformacoesDeLogin(io.cucumber.datatable.DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            basePage.realizarLogin(map.get("usuario"), map.get("senha"));
        }
    }

    @Então("verifico meu login")
    public void verificoMeuLogin() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", DriverFactory.getInstancia().getDriver().getCurrentUrl());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }

    @Dado("que sou cliente da sauce demo")
    public void queSouClienteDaSauceDemo(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertEquals("Swag Labs", DriverFactory.getInstancia().getDriver().getTitle());
        for (Map<String, String> map : dataTable.asMaps()) {
            basePage.realizarLogin(map.get("usuario"), map.get("senha"));
        }
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", DriverFactory.getInstancia().getDriver().getCurrentUrl());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }
}