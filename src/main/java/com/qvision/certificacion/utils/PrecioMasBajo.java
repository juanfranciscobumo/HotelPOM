package com.qvision.certificacion.utils;

import java.util.stream.Collectors;

import static com.qvision.certificacion.userinterfaces.PreciosHotelPages.ltPrecios;
import static com.qvision.certificacion.utils.Constantes.TARIFA_MAS_ECONOMICA;
import static com.qvision.certificacion.utils.ManipularExcel.grabarDatos;

public class PrecioMasBajo {

    public static Integer obtenerPrecioMasBajo() {
        int aux = ltPrecios.stream().map(value -> value.getText().replace("$", "")).collect(Collectors.toList()).stream().mapToInt(Integer::parseInt).min().getAsInt();
        grabarDatos(TARIFA_MAS_ECONOMICA, aux);
        return aux;
    }

}
