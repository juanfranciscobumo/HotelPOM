package com.qvision.certificacion.userinterfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://js.devexpress.com/Demos/DXHotels/#home")
public class AgenciaDeViajesPages extends PageObject {

    @FindBy(xpath = "//input[@name='location']/following-sibling::div")
    public static WebElement selUbicacion;

    @FindBy(xpath = "//div[@class='dx-first-col dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align']//div[contains(@class, 'datebox ')]/div/div/div[2]")
    public static WebElement calendario;

    @FindBy(xpath = "//div[@class='dx-calendar-views-wrapper']/div[1]/table//td/span")
    public static List<WebElement> ltDias;

    @FindBy(xpath = "//div[@class='dx-popup-content']/div/div[2]/a[3]/div/i")
    public static WebElement btnNext;

    @FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-resizable']/div//div/div[2]/a[3]/div/i")
    public static WebElement btnNextDos;

    @FindBy(xpath = "//*[@class='dx-popup-content']/div/div[2]/a[2]")
    public static WebElement btnmesinicial;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div")
    public static WebElement calendarioDos;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div/div[1]//td")
    public static List<WebElement> ltDiasDos;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[2]/a[2]")
    public static WebElement btnmesinicialdos;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[1]/div/div/div/div/div/div/input")
    public static WebElement ltRoom;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div")
    public static WebElement ltAdults;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div")
    public static WebElement ltChildren;

    @FindBy(xpath = "//span[.='SEARCH']")
    public static WebElement btnSearch;

    public static String listaUbicacion = "//*[@class='dx-scrollview-content']/div/div[contains(text(),'%s')]";
    public static String room = "//div[@class='dx-item-content dx-list-item-content'][contains(text(),'%s')]";
    public static String adultos = "/html/body/div/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[contains(text(),'%s')]";
    public static String children = "/html/body/div/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[contains(text(),'%s')]";

    public void abrirUbicaciones(String ubicacion) {
        find(By.xpath(String.format(listaUbicacion, ubicacion))).click();
    }

    public void seleccionarRooms(String cantidadHabitaciones) {
        find(By.xpath(String.format(room, cantidadHabitaciones))).click();
    }

    public void seleccionarAdultos(String cantidadAdultos) {
        find(By.xpath(String.format(adultos, cantidadAdultos))).click();
    }

    public void seleccionarChildren(String cantidadChildren) {
        find(By.xpath(String.format(children, cantidadChildren))).click();
    }
}
