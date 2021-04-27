package motoresdebusqueda.Falabella.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

@DefaultUrl("https://www.google.com")
public class Google extends PageObject {
    Logger log = Logger.getLogger(String.valueOf(Google.class));
    public String baseUrl = "https://www.google.com";
    WebDriver driver;

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    @FindBy(name = "q")
    WebElementFacade buscarGoogle;

    @FindBy(xpath = "//div[@id='rso']//a[@href='https://www.falabella.com.co/falabella-co/']//cite[@class='iUh30 Zu0yb qLRx3b tjvcx']")
    WebElementFacade buscarFalabella;

    public void google(){
        try {
            buscarGoogle.type("falabella").sendKeys(Keys.ENTER);
            log.info("Buscando desde Google: "+ buscarFalabella.getText());
            waitFor(buscarFalabella);
            log.info("Esperando el objeto: "+ buscarFalabella.getText());
            buscarFalabella.click();
            log.info("Se da clic en el objeto: "+ buscarFalabella);
            Thread.sleep(3000);
            log.info("Tiempo de espera 3 segundos");
        } catch (NoSuchElementException ne){
            System.out.println("WebElement no encontrado: " + ne.getMessage());
        } catch (WebDriverException we){
            System.out.println("WebElement fallo: " + we.getAdditionalInformation());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
