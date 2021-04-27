package motoresdebusqueda.Falabella;

import motoresdebusqueda.Falabella.steps.UsuarioFalabella;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.PropertyConfigurator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Falabella {

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log.properties");
    }

    @Steps
    UsuarioFalabella Jason;

    @Managed
    WebDriver driver;

    @Test
    public void Test1_CompraFalabella() throws InterruptedException, IOException {
        Jason.ingresarGoogle();
        Jason.ingresarbusqueda();
        Jason.ingresarbusquedaFalabella();
        Jason.ingresarbusquedaMobil();
        Jason.comprarProducto();
        Jason.verificarProducto();
    }

}
