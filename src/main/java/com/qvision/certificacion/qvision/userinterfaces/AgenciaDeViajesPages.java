package com.qvision.certificacion.qvision.userinterfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qvision.certificacion.agenciadeviajes.utils.BuscarFecha;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#home")
public class AgenciaDeViajesPages extends PageObject {


	@FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div")
	WebElement selUbicacion;

	@FindBy(xpath = "//div[@class='dx-first-col dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align']//div[contains(@class, 'datebox ')]/div/div/div[2]")
	WebElement calendario;

	@FindBy(xpath = "//div[@class=\"dx-calendar-views-wrapper\"]/div[1]/table//td/span")
	List<WebElement> ltDias;

	@FindBy(xpath = "//div[@class=\"dx-popup-content\"]/div/div[2]/a[3]/div/i")
	WebElement btnNext;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-resizable']/div//div/div[2]/a[3]/div/i")
	WebElement btnNextDos;

	@FindBy(xpath = "//*[@class=\"dx-popup-content\"]/div/div[2]/a[2]")
	WebElement btnmesinicial;

	@FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div")
	WebElement calendarioDos;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div/div[1]//td")
	List<WebElement> ltDiasDos;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[2]/a[2]")
	WebElement btnmesinicialdos;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[1]/div/div/div/div/div[1]/div/input")
	WebElement ltRoom;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div")
	WebElement ltAdults;

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div")
	WebElement ltChildren;

	@FindBy(xpath = "//span[.='SEARCH']")
	WebElement btnSearch;

	public void abrirUbicaciones(String ubicacion) {
		selUbicacion.click();
		waitABit(2000);
		find(By.xpath("//*[@class=\"dx-scrollview-content\"]/div/div[contains(text(),'" + ubicacion + "')]")).click();
	}

	public void abrirCalendario() {
		calendario.click();
	}

	public void seleccionarFecha(String mes, String ano, String dia) throws InterruptedException {
		BuscarFecha buscarFecha = new BuscarFecha(btnmesinicial, btnNext, ltDias, mes, ano, dia);
		buscarFecha.seleccionarFecha();
	}

	public void abrirSegundoCalendario() {
		calendarioDos.click();
	}

	public void seleccionarFechaDos(String mes, String ano, String dia) throws InterruptedException {
		BuscarFecha buscarFecha = new BuscarFecha(btnmesinicialdos, btnNextDos, ltDiasDos, mes, ano, dia);
		buscarFecha.seleccionarFecha();
	}

	public void seleccionarRooms(String cantidadHabitaciones)  {
		waitABit(2000);
		System.out.println("hola1");
		try {
			ltRoom.click();
		} catch (Exception e) {
			System.out.println("NO ENCONTRO");
		}

		System.out.println("hola");
		find(By.xpath("//div[@class=\"dx-item-content dx-list-item-content\"][contains(text(),'" + cantidadHabitaciones
				+ "')]")).click();
		System.out.println("hola1");
	}

	public void seleccionarAdultos(String cantidadAdultos)  {
		ltAdults.click();
		waitABit(2000);
		find(By.xpath("/html/body/div/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[contains(text(),'"
				+ cantidadAdultos + "')]")).click();
	}

	public void seleccionarChildren(String cantidadChildren)  {
		ltChildren.click();
		waitABit(2000);
		find(By.xpath("/html/body/div/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[contains(text(),'"
				+ cantidadChildren + "')]")).click();
	}

	public void buscarHotel() {
		btnSearch.click();
	}
}
