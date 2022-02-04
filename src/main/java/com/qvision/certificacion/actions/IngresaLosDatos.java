package com.qvision.certificacion.actions;

import com.qvision.certificacion.interactions.BuscarFecha;
import com.qvision.certificacion.models.IngresaLosDatosModel;
import com.qvision.certificacion.userinterfaces.AgenciaDeViajesPages;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static com.qvision.certificacion.userinterfaces.AgenciaDeViajesPages.*;

public class IngresaLosDatos extends PageObject {
    private List<IngresaLosDatosModel> datos;
    private AgenciaDeViajesPages agenciaDeViajes;

    public IngresaLosDatos(List<IngresaLosDatosModel> datos, AgenciaDeViajesPages agenciaDeViajes) {
        this.datos = datos;
        this.agenciaDeViajes = agenciaDeViajes;
    }

    public void action()  {
        selUbicacion.click();
        waitABit(2000);
        agenciaDeViajes.abrirUbicaciones(datos.get(0).getLocation());
        calendario.click();
        BuscarFecha.seleccionaLaFecha(btnmesinicial, btnNext, ltDias, datos.get(0).getMesInicio(),
                datos.get(0).getAnoInicio(), datos.get(0).getDiaInicio());
        calendarioDos.click();
        BuscarFecha.seleccionaLaFecha(btnmesinicialdos, btnNextDos, ltDiasDos, datos.get(0).getMesFin(),
                datos.get(0).getAnoFin(), datos.get(0).getDiaFin());
        waitABit(2000);
        ltRoom.click();
        agenciaDeViajes.seleccionarRooms(datos.get(0).getRooms());
        ltAdults.click();
        waitABit(2000);
        agenciaDeViajes.seleccionarAdultos(datos.get(0).getAdults());
        ltChildren.click();
        waitABit(2000);
        agenciaDeViajes.seleccionarChildren(datos.get(0).getChildren());
        btnSearch.click();

    }

    public static void aLaPagina(List<IngresaLosDatosModel> datos, AgenciaDeViajesPages agenciaDeViajes) {
        new IngresaLosDatos(datos, agenciaDeViajes).action();
    }
}
