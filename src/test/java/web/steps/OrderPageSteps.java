package web.steps;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import util.PageHelper;
import web.pages.OrderPage;

public class OrderPageSteps {

    private OrderPage orderPage = new OrderPage();

    @Entao("vejo a tela de confirmacao do pedido")
    public void vejo_a_tela_de_confirmacao_do_pedido() {
        Assert.assertTrue(orderPage.isOrderCompleted());
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", orderPage.txtThankYou.getText());
        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", orderPage.txtDisPatched.getText());
        Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
    }
}
