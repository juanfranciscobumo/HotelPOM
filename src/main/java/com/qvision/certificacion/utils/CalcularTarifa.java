package com.qvision.certificacion.utils;

import static com.qvision.certificacion.utils.ManipularExcel.getNumeroDias;
import static com.qvision.certificacion.utils.ManipularExcel.getTarifa;

public class CalcularTarifa {

    public static String laTarifa() {
        return String.valueOf((Integer.parseInt(getNumeroDias()) + 1) * Integer.parseInt(getTarifa()));
    }
}
