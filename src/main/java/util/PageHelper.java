package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import web.factory.DriverFactory;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PageHelper {

    public static byte[] Takescreenshot() {
        TakesScreenshot screenshot = ((TakesScreenshot) DriverFactory.getInstancia().getDriver());
        File printscreen = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            String caminhoProjeto = "./target/evidencias/";
            String nomeDinamico = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss")) + ".jpeg";
            FileUtils.copyFile(printscreen, new File(caminhoProjeto + nomeDinamico));
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possivel criar a evidencia");
        }
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }


    public static WebElement waitUntilVisibility(WebElement element, String descricao) {
        try {
            getFluentWait().until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception e) {
            throw new ElementNotVisibleException("Erro ao tentar manipular o elemento: " + descricao + " ----- Foi apresentado o seguinte erro: " + e.getMessage());
        }
    }

    private static FluentWait getFluentWait() {
        return new FluentWait(DriverFactory.getInstancia().getDriver())
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotSelectableException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class);
    }

}
