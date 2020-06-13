package com.qvision.certificacion.qvision.userinterfaces;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import com.qvision.certificacion.agenciadeviajes.utils.CalcularTarifa;
import com.qvision.certificacion.agenciadeviajes.utils.DiferenciaDeDias;
import com.qvision.certificacion.agenciadeviajes.utils.ManipularExcel;
import com.qvision.certificacion.agenciadeviajes.utils.PrecioMasBajo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PreciosHotelPages extends PageObject{
	
	@FindBy(xpath="//div[@class='current-hotels']/div/div/div[2]/div[1]")
	List<WebElement> ltPrecios;

	public void buscarPrecioMasBajo(String dia, String mes, String ano, String diaFin, String mesFin, String anoFin) throws InterruptedException, ParseException, FilloException {
		PrecioMasBajo precioMasBajo=new PrecioMasBajo(ltPrecios);
	    find(By.xpath("//div[@class='current-hotels']/div/div/div[2]/div[1]/p[contains(text(),'"+ precioMasBajo.obtenerPrecioMasBajo() +"')]/parent::div/following-sibling::div[2]")).click();
	    DiferenciaDeDias diferenciaDeDias=new DiferenciaDeDias(dia, mes, ano, diaFin, mesFin, anoFin);
        ManipularExcel guardarEnExcel=new ManipularExcel("NUMERODEDIAS",diferenciaDeDias.retornarDiferenciaDias(),"Tarifa");
	    guardarEnExcel.grabarDatos();
	    CalcularTarifa calcularTarifa=new CalcularTarifa();
	    calcularTarifa.laTarifa();
	}

}
