package motoresdebusqueda.Falabella.steps;

import motoresdebusqueda.Falabella.pageobject.*;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.logging.Logger;

public class UsuarioFalabella {
    Logger log = Logger.getLogger(String.valueOf(UsuarioFalabella.class));
    String actor;

    Google paginaGoogle;
    FalabellaPrincipal paginaPrincipal;
    FalabellaResultado paginaResultado;
    FalabellaComprar paginaComprar;
    FalabellaProducto paginaProducto;

    @Step("#actor ingresa a la pagina principal de Google")
    public void ingresarGoogle() {
        paginaGoogle.initializeComponent();
        paginaGoogle.open();
        log.info("Abrio el Navegador con la URL: "+paginaGoogle.baseUrl);
    }

    @Step("#actor realiza el ingreso a Google y busca la palabra Falabella")
    public void ingresarbusqueda() throws InterruptedException, IOException {
        paginaGoogle.google();
    }

    @Step("#actor realiza el cierre del PopUp y genera la busqueda de Celulares")
    public void ingresarbusquedaFalabella() throws InterruptedException, IOException {
        paginaPrincipal.paginaPrincipalFalabella();
    }

    @Step("#actor busca en la siguiente pagina y busca un celular a comprar")
    public void ingresarbusquedaMobil() throws InterruptedException, IOException {
        paginaResultado.FalabellaResultado();
    }

    @Step("#actor realiza la compra del producto y se le asigna un seguro")
    public void comprarProducto() throws InterruptedException, IOException {
        paginaComprar.FalabellaBolsa();
    }

    @Step("#actor realiza la confirmación de los datos a comprar")
    public void verificarProducto() throws InterruptedException, IOException {
        paginaProducto.paginaProducto();
    }
}
