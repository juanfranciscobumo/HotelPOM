package com.co.qvision.certificacion.steps;

import static com.qvision.certificacion.utils.CalcularTarifa.laTarifa;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import com.codoid.products.exception.FilloException;

import com.qvision.certificacion.actions.BuscaElPrecio;
import com.qvision.certificacion.actions.IngresaLosDatos;
import com.qvision.certificacion.models.IngresaLosDatosModel;
import com.qvision.certificacion.utils.CalcularTarifa;
import com.qvision.certificacion.userinterfaces.AgenciaDeViajesPages;
import com.qvision.certificacion.userinterfaces.PreciosHotelPages;
import com.qvision.certificacion.userinterfaces.TarifaNetaPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AgenciaDeViajesStepDefinitions {

    AgenciaDeViajesPages agenciaDeViajes;
    PreciosHotelPages preciosHotelPages;
    TarifaNetaPages tarifaNetaPages;

    @Given("que el usuario se encuentre en la pagina web")
    public void queElUsuarioSeEncuentreEnLaPaginaWeb() {
        agenciaDeViajes.open();
    }

    @When("realice la busqueda con los datos solicitados")
    public void realiceLaBusquedaConLosDatosSolicitados(List<IngresaLosDatosModel> datos) {
        IngresaLosDatos.aLaPagina(datos, agenciaDeViajes);
    }

    @When("buscara el precio mas economico")
    public void buscaraElPrecioMasEconomico(List<IngresaLosDatosModel> datos) {
        BuscaElPrecio.conLosDatos(datos, preciosHotelPages);
    }

    @Then("valide el precio Total")
    public void valideElPrecioTotal() {
        assertEquals(laTarifa(), tarifaNetaPages.tarifaNeta());
    }

}
