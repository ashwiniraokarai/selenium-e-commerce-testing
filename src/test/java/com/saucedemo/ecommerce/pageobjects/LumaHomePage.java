package com.saucedemo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.PageObjects;

public class LumaHomePage extends PageObject {
    public void openPage() {
        openUrl("https://magento.softwaretestingboard.com/");
    }
}
