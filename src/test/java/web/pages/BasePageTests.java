package web.pages;

import org.junit.Assert;
import org.junit.Test;
import util.PageHelper;
import web.factory.DriverFactory;

public class BasePageTests {

    public final String PASSWORD = "secret_sauce";

    @Test
    public void deveAbrirPaginaBase() {
        Assert.assertEquals("Swag Labs", DriverFactory.getInstancia().getDriver().getTitle());
    }

    @Test
    public void realizarLoginComSucesso() {
        BasePage basePage = new BasePage();
        basePage.realizarLogin("standard_user", PASSWORD);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", DriverFactory.getInstancia().getDriver().getCurrentUrl());
    }

    @Test
    public void realizarLoginComUsuarioInexistente() {
        BasePage basePage = new BasePage();
        basePage.realizarLogin("usuario_inexistente", PASSWORD);
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", PageHelper.waitUntilVisibility(basePage.msgErro, "basePage.msgErro").getText());
    }

    @Test
    public void realizarLoginComUsuarioBloqueado() {
        BasePage basePage = new BasePage();
        basePage.realizarLogin("locked_out_user", PASSWORD);
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", PageHelper.waitUntilVisibility(basePage.msgErro, "Mensagem de Erro do Login").getText());
    }
}
