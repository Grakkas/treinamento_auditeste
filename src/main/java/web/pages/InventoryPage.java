package web.pages;

import model.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;
import web.factory.DriverFactory;

import java.util.List;

public class InventoryPage {

    @FindBy(id = "shopping_cart_container")
    public WebElement btnCarrinho;

    @FindBy(className = "inventory_item")
    public List<WebElement> productList;

    public InventoryPage() {
        PageFactory.initElements(DriverFactory.getInstancia().getDriver(), this);
    }

    public boolean addProductToCart(ProductModel productModel) {
        PageHelper.waitUntilVisibility(btnCarrinho, "txtProdutos");
        for (WebElement product : productList)
            if (product.findElement(By.className("inventory_item_name")).getText().contains(productModel.getNome())) {
                product.findElement(By.xpath(".//button[contains(.,'Add to cart')]")).click();
                product.findElement(By.xpath(".//button[contains(.,'Remove')]"));
                return true;
            }
        throw new InvalidArgumentException("Houve um erro ao tentar adicionar o produto no carrinho: " + productModel.getNome());
    }

    public boolean removeProductFromCart(ProductModel productModel) {
        PageHelper.waitUntilVisibility(btnCarrinho, "txtProdutos");
        for (WebElement product : productList)
            if (product.findElement(By.className("inventory_item_name")).getText().contains(productModel.getNome())) {
                product.findElement(By.xpath(".//button[contains(.,'Remove')]")).click();
                product.findElement(By.xpath(".//button[contains(.,'Add to cart')]"));
                return true;
            }
        throw new InvalidArgumentException("Houve um erro ao tentar remover o produto no carrinho: " + productModel.getNome());
    }

    public boolean goToCheckout(){
        PageHelper.waitUntilVisibility(btnCarrinho, "btnCarrinho").click();
        return true;
    }
}
