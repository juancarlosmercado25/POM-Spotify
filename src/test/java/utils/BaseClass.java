package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//la clase base define las acciones de selenium (Wrapper)
public class BaseClass {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public void cargarPagina(String url){
        driver.get(url);
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public void click(By localizador){
        driver.findElement(localizador).click();
    }

    public void scrollElementoWeb(WebElement elemento) {
        js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments[0], scrollIntoViews();", elemento);
    }

    public void esperarXsegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        }catch (Exception ex){
            System.out.println("Fallo la espera en milisegundos definida.");
        }
    }

    public WebElement esperarAElementoWeb(By localizador){
        wait= new WebDriverWait(this.driver, 20);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

}
