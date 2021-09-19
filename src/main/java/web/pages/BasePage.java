package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.factory.DriverFactory;

public class BasePage {

    @FindBy(id = "user-name")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login-button")
    public WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement msgErro;

    protected WebDriver driver = DriverFactory.getInstancia().getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void realizarLogin(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnLogin.click();
    }
}
