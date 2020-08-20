package com.sophos.certificacion.wong.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageProduct {
    public static final Target ADD_TO_CART = Target.the("Add to cart").locatedBy("//span[contains(text(),'Agregar al carrito')]");
    public static final Target CLOSE_ALERT = Target.the("Alerts").locatedBy("//*[@class='modal-address__close font-icn cross']");
    public static final Target VALIDATE_CART = Target.the("Validate cart").locatedBy(".minicart__body:nth-child(1) .minicart__totalizer--amount");
    public static final Target SEE_MY_CART = Target.the("See my cart").locatedBy(".minicart__body:nth-child(1) > .minicart__items-wrapper > .btn > .text");
    public static final Target GET_NAME_PRODUCT = Target.the("Get name product ").locatedBy("//*[@id='cart-page']/div[9]/div/div[3]/div[1]/div[5]/div[2]/div/div[3]/a");
}
