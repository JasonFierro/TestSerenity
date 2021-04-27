package motoresdebusqueda.Falabella.pageobject;


import net.serenitybdd.core.pages.PageObject;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class FalabellaResultado extends PageObject {

    Logger log = Logger.getLogger(String.valueOf(FalabellaResultado.class));

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    WebDriver driver;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//button[@id='testId-pagination-top-arrow-right']/i[@class='jsx-1738323148 jsx-2760063687 csicon-arrow_right']")
    WebElement paginacion;

    @FindBy(xpath = "//b[.='iPhone 12 Mini 64GB']")
    public WebElement celular1;

    @FindBy(xpath = "//b[.='iPhone 12 Pro 128GB']")
    public WebElement celular2;

    @FindBy(xpath = "//button[@class='jsx-1816208196 button button-primary button-primary-xtra-large']")
    WebElement agregarBolsa;

    public void FalabellaResultado(){
        try {
            waitFor(paginacion);
            log.info("Esperando al objeto: "+paginacion);
            paginacion.click();
            log.info("Clic al objeto: "+paginacion);
            waitFor(celular2);
            log.info("Esperando al objeto: "+celular2);
            celular2.click();
            log.info("Clic al objeto: "+celular2);
            Thread.sleep(2000);
            waitFor(agregarBolsa);
            agregarBolsa.click();
        } catch (NoSuchElementException ne){
            System.out.println("WebElement no encontrado: " + ne.getMessage());
        } catch (WebDriverException we){
            System.out.println("WebElement fallo: " + we.getAdditionalInformation());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
