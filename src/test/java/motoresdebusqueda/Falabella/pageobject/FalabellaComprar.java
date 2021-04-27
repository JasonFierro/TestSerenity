package motoresdebusqueda.Falabella.pageobject;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class FalabellaComprar extends PageObject {

    Logger log = Logger.getLogger(String.valueOf(FalabellaComprar.class));

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    WebDriver driver;

    @FindBy(xpath = "//a[@id='linkButton']")
    WebElementFacade verBolsaCompras;

    @FindBy(xpath = "//span[@class='fb-inline-dropdown__link__title js-inline-dropdown__link__title']")
    WebElementFacade listaAsegurarProducto;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/section/section/div/div/div/form/div/div/ul/li[2]/a")
    WebElementFacade asegurarProducto;

    @FindBy(xpath = "//div[@class='fb-order-status__cta']")
    WebElementFacade comprar;

    public void FalabellaBolsa(){
        try {
            waitFor(verBolsaCompras);
            log.info("Esperando al objeto: "+verBolsaCompras);
            verBolsaCompras.click();
            log.info("Clic al objeto: "+verBolsaCompras);
            waitFor(listaAsegurarProducto);
            log.info("Esperando al objeto: "+listaAsegurarProducto);
            listaAsegurarProducto.click();
            log.info("Clic al objeto: "+listaAsegurarProducto);
            Thread.sleep(3000);
            String result = asegurarProducto.getText();
            String seguro1 = result.replace("Gold Protection","");
            String seguro = seguro1.replace(" ","");
            log.info("El valor del seguro es: "+seguro);
            asegurarProducto.click();
            log.info("Clic al objeto: "+asegurarProducto);
            Thread.sleep(2000);
            comprar.click();
            log.info("Clic al objeto: "+comprar);
            Thread.sleep(5000);
        } catch (NoSuchElementException ne){
            System.out.println("WebElement no encontrado: " + ne.getMessage());
        } catch (WebDriverException we){
            System.out.println("WebElement fallo: " + we.getAdditionalInformation());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
