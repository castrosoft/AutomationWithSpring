package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author pcastro
 *
 * La clase Base contiene los metodos "Wrappers" de los comandos de Selenium.
 * Aqui deberian ir todos los que voy a usar. Por ejemplo si Selenium modifica el nombre del
 * metodo findElement() por findTheElement() solamente lo modifico en el metodo que lo wrappea
 *
 */

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Conexion al  navegador Chrome
     *
     * @return WebDriver
     */
    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/driver/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }


    //Se deben incluir todos los metodos que se van a usar en el proyecto.

}
