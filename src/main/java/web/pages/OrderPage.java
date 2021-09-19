package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;
import web.factory.DriverFactory;

public class OrderPage {

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement txtThankYou;

    @FindBy(xpath = "//div[@class='complete-text']")
    public WebElement txtDisPatched;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    public WebElement imgPony;

    public OrderPage(){
        PageFactory.initElements(DriverFactory.getInstancia().getDriver(), this);
    }

    public boolean isOrderCompleted(){
        PageHelper.waitUntilVisibility(txtThankYou, "txtThankYou");
        PageHelper.waitUntilVisibility(txtDisPatched, "txtThankYou");
        PageHelper.waitUntilVisibility(imgPony, "txtThankYou");
        return true;
    }

}
