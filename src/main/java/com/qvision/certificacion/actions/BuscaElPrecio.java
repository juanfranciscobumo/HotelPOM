package com.qvision.certificacion.actions;

import com.qvision.certificacion.models.IngresaLosDatosModel;
import com.qvision.certificacion.userinterfaces.AgenciaDeViajesPages;
import com.qvision.certificacion.userinterfaces.PreciosHotelPages;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

import static com.qvision.certificacion.userinterfaces.PreciosHotelPages.precio;
import static com.qvision.certificacion.utils.CalcularTarifa.laTarifa;
import static com.qvision.certificacion.utils.Constantes.NUMERO_DIAS;
import static com.qvision.certificacion.utils.Constantes.TARIFA_MAS_ECONOMICA;
import static com.qvision.certificacion.utils.DiferenciaDeDias.diferenciaDeDias;
import static com.qvision.certificacion.utils.ManipularExcel.grabarDatos;
import static com.qvision.certificacion.utils.PrecioMasBajo.obtenerPrecioMasBajo;

public class BuscaElPrecio extends PageObject {
    private String mesInicio;
    private String diaInicio;
    private String annoInicio;
    private String mesFin;
    private String diaFin;
    private String annoFin;
    private PreciosHotelPages precios;

    public BuscaElPrecio(List<IngresaLosDatosModel> datos, PreciosHotelPages precios) {
        this.mesInicio = datos.get(0).getMesInicio();
        this.diaInicio = datos.get(0).getDiaInicio();
        this.annoInicio = datos.get(0).getAnoInicio();
        this.mesFin = datos.get(0).getMesFin();
        this.diaFin = datos.get(0).getDiaFin();
        this.annoFin = datos.get(0).getAnoFin();
        this.precios = precios;
    }

    public void action() {
        waitABit(2000);
        precios.buscarPrecioMasBajo();
        grabarDatos(NUMERO_DIAS, diferenciaDeDias(diaInicio, mesInicio, annoInicio, diaFin, mesFin, annoFin));
        laTarifa();
    }

    public static void conLosDatos(List<IngresaLosDatosModel> datos,PreciosHotelPages precios) {
        new BuscaElPrecio(datos,precios).action();
    }
}
