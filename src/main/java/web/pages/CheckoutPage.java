package web.pages;

import model.ClientModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;
import web.factory.DriverFactory;

public class CheckoutPage {

    @FindBy(id = "checkout")
    public WebElement btnCheckout;

    @FindBy(id = "first-name")
    public WebElement inputNome;

    @FindBy(id = "last-name")
    public WebElement inputSobrenome;

    @FindBy(id = "postal-code")
    public WebElement inputCep;

    @FindBy(id = "continue")
    public WebElement btnContinue;

    @FindBy(id = "finish")
    public WebElement btnFinish;

    public CheckoutPage(){
        PageFactory.initElements(DriverFactory.getInstancia().getDriver(), this);
    }

    public boolean fillClientForm(ClientModel clientModel){
        PageHelper.waitUntilVisibility(btnCheckout, "btnCheckout").click();
        PageHelper.waitUntilVisibility(inputNome, "inputNome").sendKeys(clientModel.getNome());
        PageHelper.waitUntilVisibility(inputSobrenome, "inputSobrenome").sendKeys(clientModel.getSobrenome());
        PageHelper.waitUntilVisibility(inputCep, "inputCep").sendKeys(clientModel.getCep());
        PageHelper.waitUntilVisibility(btnContinue, "btnContinue").click();
        return true;
    }

    public boolean finishOrder(){
        PageHelper.waitUntilVisibility(btnFinish,"btnFinish").click();
        return true;
    }



}
