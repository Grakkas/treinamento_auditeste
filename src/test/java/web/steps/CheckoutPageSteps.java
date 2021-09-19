package web.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ClientModel;
import org.junit.Assert;
import util.PageHelper;
import web.pages.CheckoutPage;
import web.pages.InventoryPage;

import java.util.Map;

public class CheckoutPageSteps {

    private InventoryPage inventoryPage = new InventoryPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private ClientModel clientModel;

    @Quando("seguir para o checkout")
    public void seguir_para_o_checkout() {
        Assert.assertTrue(inventoryPage.goToCheckout());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }

    @Quando("preencher o formulario com as informacoes do cliente")
    public void preencher_o_formulario_com_as_informacoes_do_cliente(io.cucumber.datatable.DataTable dataTable) {
        for(Map<String, String> map : dataTable.asMaps()){
             clientModel = new ClientModel(
                    map.get("nome"),
                    map.get("sobrenome"),
                    map.get("cep"));
        }
        Assert.assertTrue(checkoutPage.fillClientForm(clientModel));
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }

    @Entao("visualizo a excecao de preenchimento incorreto do formulario")
    public void visualizoAExcecaoDePreenchimentoIncorretoDoFormulario() {
        Assert.assertTrue(checkoutPage.isErrorFound());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }

    @Quando("finalizar a compra")
    public void finalizar_a_compra() {
        Assert.assertTrue(checkoutPage.finishOrder());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }

}
