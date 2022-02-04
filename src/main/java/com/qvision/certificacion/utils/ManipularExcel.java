package com.qvision.certificacion.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.qvision.certificacion.utils.Constantes.*;

public class ManipularExcel {
    private static Logger logger = LoggerFactory.getLogger(ManipularExcel.class);
    private static Fillo fillo = new Fillo();
    private static Connection connection = null;
    private static String dias = null;
    private static Recordset recordset;
    private static String tarifa = null;

    public static void grabarDatos(String nombre, int dato) {
        try {
            connection = fillo.getConnection(RUTA_EXCEL);
            connection.executeUpdate(String.format(QUERY_GUARDAR, TARIFA, nombre, dato));
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        connection.close();
    }

    public static String getNumeroDias() {

        try {
            connection = fillo.getConnection(RUTA_EXCEL);
            recordset = connection.executeQuery(QUERY_CONSULTA);
            while (recordset.next()) {
                dias = recordset.getField(NUMERO_DIAS);
            }
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        recordset.close();
        connection.close();
        return dias;
    }

    public static String getTarifa() {
        try {
            connection = fillo.getConnection(RUTA_EXCEL);
            recordset = connection.executeQuery(QUERY_CONSULTA);
            while (recordset.next()) {
                tarifa = recordset.getField(TARIFA_MAS_ECONOMICA);
            }
        } catch (FilloException e) {
            e.printStackTrace();
        }
        recordset.close();
        connection.close();
        return tarifa;
    }
}
