package com.qvision.certificacion.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.qvision.certificacion.utils.Constantes.*;

public class ManipularExcel {
    private static final Logger logger = LoggerFactory.getLogger(ManipularExcel.class);
    private static final Fillo fillo = new Fillo();
    private static Connection connection = null;
    private static String respuesta = null;
    private static Recordset recordset;

    public static void grabarDatos(String nombre, int dato) {
        try {
            crearConexion().executeUpdate(String.format(QUERY_GUARDAR, TARIFA, nombre, dato));
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        crearConexion().close();
    }

    public static String getNumeroDias() {

        try {
            recordset = crearConexion().executeQuery(QUERY_CONSULTA);
            while (recordset.next()) {
                respuesta = recordset.getField(NUMERO_DIAS);
            }
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        recordset.close();
        crearConexion().close();
        return respuesta;
    }

    public static String getTarifa() {
        try {
            recordset = crearConexion().executeQuery(QUERY_CONSULTA);
            while (recordset.next()) {
                respuesta = recordset.getField(TARIFA_MAS_ECONOMICA);
            }
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        recordset.close();
        crearConexion().close();
        return respuesta;
    }

    public static Connection crearConexion() {
        try {
            connection = fillo.getConnection(RUTA_EXCEL);
        } catch (FilloException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}
