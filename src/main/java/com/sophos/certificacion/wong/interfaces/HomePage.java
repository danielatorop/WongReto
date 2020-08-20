package com.sophos.certificacion.wong.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target SEARCH_PRODUCT = Target.the("Search product").locatedBy("//*[@id='search-autocomplete-input']");
    public static final Target ClOSE_ALERT_TOP = Target.the("Alerts").locatedBy("//*[@id='onesignal-slidedown-cancel-button']");
    public static final Target RESULTS_PRODUCT = Target.the("Result product").locatedBy("//span[contains(text(),'Ver todos los resultados')]");
    public static final Target NAME_PRODUCT = Target.the("Name product").locatedBy("//*[@title='{0}']");
}
