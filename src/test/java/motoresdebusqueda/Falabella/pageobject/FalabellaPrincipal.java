package motoresdebusqueda.Falabella.pageobject;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class FalabellaPrincipal extends PageObject {

    Logger log = Logger.getLogger(String.valueOf(FalabellaPrincipal.class));

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    @FindBy(id = "fake-close")
    WebElementFacade avisoImportante;

    @FindBy(xpath = "//*[@id=\"acc-alert-close\"]")
    WebElementFacade avisoadvertencia;

    @FindBy(xpath = "//div[@class='flex-grow-1']//input[@class='DesktopSearchBar-module_searchbox-input__HXYgR']")
    public WebElementFacade buscar;

    public void paginaPrincipalFalabella(){
        try {
            waitFor(avisoImportante);
            log.info("Esperando al objeto: "+avisoImportante);
            avisoImportante.click();
            log.info("Clic al objeto: "+avisoImportante);
            Thread.sleep(2000);
            avisoadvertencia.click();
            log.info("Clic al objeto: "+avisoadvertencia);
            Thread.sleep(2000);
            log.info("Tiempo de espera 2 segundos");
            buscar.type("celulares");
            log.info("Se busca el objeto: celulares");
            buscar.sendKeys(Keys.ENTER);
            log.info("Clic al objeto: "+buscar);
            Thread.sleep(5000);
            log.info("Tiempo de espera 5 segundos");
        } catch (NoSuchElementException ne){
            System.out.println("WebElement no encontrado: " + ne.getMessage());
        } catch (WebDriverException we){
            System.out.println("WebElement fallo: " + we.getAdditionalInformation());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
