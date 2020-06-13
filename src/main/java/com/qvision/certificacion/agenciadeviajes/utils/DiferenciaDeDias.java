package com.qvision.certificacion.agenciadeviajes.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiferenciaDeDias {
private String dia;
private String mes;
private String ano;
private String diaFin;
private String mesFin;
private String anoFin;

	public DiferenciaDeDias(String dia, String mes, String ano, String diaFin, String mesFin, String anoFin) {
	this.dia = dia;
	this.mes = mes;
	this.ano = ano;
	this.diaFin = diaFin;
	this.mesFin = mesFin;
	this.anoFin = anoFin;
}

	public Integer retornarDiferenciaDias() throws ParseException {
 
		ObtenerNumeroMes obtenerNumeroMes=new ObtenerNumeroMes(mes);
		mes=obtenerNumeroMes.getMes();
		ObtenerNumeroMes obtenerNumeroMesFin=new ObtenerNumeroMes(mesFin);
		mesFin=obtenerNumeroMesFin.getMes();
		String fechaInicio=ano+"-"+mes+"-"+dia;
		String fechaFin=anoFin+"-"+mesFin+"-"+diaFin;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
		Date fechaInicial=dateFormat.parse(fechaInicio);
		Date fechaFinal=dateFormat.parse(fechaFin);
 
		int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
		return dias;
	}
}
