package web.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ProductModel;
import org.junit.Assert;
import util.PageHelper;
import web.pages.InventoryPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryPageSteps {

    private final List<ProductModel> listaDeProdutos = new ArrayList<>();
    private final List<ProductModel> listaDeRemocao = new ArrayList<>();

    private final InventoryPage inventoryPage = new InventoryPage();

    @Quando("adicionar um produto no meu carrinho")
    public void adicionarUmProdutoNoMeuCarrinho(io.cucumber.datatable.DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            ProductModel productModel = new ProductModel(map.get("nomeProduto"));
            listaDeProdutos.add(productModel);
        }
        for (ProductModel productModel : listaDeProdutos) {
            Assert.assertTrue(inventoryPage.addProductToCart(productModel));
            Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
        }
    }

    @Entao("removo um produto no meu Carrinho")
    public void removoUmProdutoNoMeuCarrinho(io.cucumber.datatable.DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            ProductModel productModel = new ProductModel(map.get("nomeProduto"));
            listaDeRemocao.add(productModel);
        }
        for (ProductModel productModel : listaDeRemocao) {
            inventoryPage.removeProductFromCart(productModel);
            listaDeProdutos.remove(productModel);
            Hooks.currentScenario.attach(PageHelper.Takescreenshot(), "image/png", Hooks.currentScenario.getName());
        }
        Assert.assertEquals(false, listaDeProdutos.contains(listaDeRemocao));
    }
}