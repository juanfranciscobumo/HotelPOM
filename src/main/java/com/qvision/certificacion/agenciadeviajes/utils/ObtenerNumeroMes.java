package com.qvision.certificacion.agenciadeviajes.utils;

public class ObtenerNumeroMes {
private String mes;
    public ObtenerNumeroMes(String mes) {
	this.mes = mes;
}
    public String getMes() {
    String num="";
	String meses [] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", 
    		"SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
   for(int i=0;i<meses.length;i++) {
	   if(meses[i].equals(mes)) {
		   num=String.valueOf(i+1);
	   }
   }
return num;
}
}
