package motoresdebusqueda.Falabella.pageobject;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class FalabellaProducto extends PageObject {

    Logger log = Logger.getLogger(String.valueOf(FalabellaProducto.class));

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    @FindBy(xpath = "//span[@class='fbra_text fbra_test_orderSummary__itemProperty fbra_orderSummary__itemProperty__name']")
    WebElementFacade nombreProducto;

    @FindBy(xpath = "//span[.='$5.349.900']")
    WebElementFacade valorProducto;

    @FindBy(xpath = "//span[.='$890.900']")
    public WebElementFacade valorSeguro;

    public void paginaProducto(){
        try {
            waitFor(nombreProducto);
            log.info("Esperando al objeto: "+nombreProducto);
            Assert.assertEquals("iPhone 12 Pro 128GB",nombreProducto.getText());
            log.info("El texto esperado es: iPhone 12 Pro 128GB, y el producto a comprar es: "+nombreProducto.getText());
            Thread.sleep(2000);
            Assert.assertEquals("$5.349.900",valorProducto.getText());
            log.info("El valor esperado es: $5.349.900, y el valor del producto a comprar es: "+valorProducto.getText());
            Thread.sleep(2000);
            Assert.assertEquals("$890.900",valorSeguro.getText());
            log.info("El valor esperado es: $890.900, y el valor del seguro a comprar es: "+valorSeguro.getText());
        } catch (NoSuchElementException ne){
            System.out.println("WebElement no encontrado: " + ne.getMessage());
        } catch (WebDriverException we){
            System.out.println("WebElement fallo: " + we.getAdditionalInformation());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
