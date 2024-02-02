package com.saucedemo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/*
*Extends PageComponents as opposed to PageObjects
* This is because ShoppingCart is part of a Page, not an entire Page by itself
 */
public class ShoppingCartComponent extends PageComponent {
    @FindBy(css = ".showcart")
    WebElementFacade showCartLink;

/*    Refactored: Scaled to collect multiple items in the minicart
    @FindBy(css = "#mini-cart li.product-item .product-item-name")
    WebElementFacade miniCartContent;
 */

    //Grabbing all elements that match this selector in order to collect all items in the minicart
    @FindBy(css = "#mini-cart li.product-item .product-item-name")
    List<WebElementFacade> miniCartContents;

    @FindBy(css = ".loader")
    WebElementFacade spinnerAnimation;

    public void showCartSummary() {
        showCartLink.click();
    }

    public void waitForCartIconToUpdateCount(){
        spinnerAnimation.waitUntilVisible();
        spinnerAnimation.waitUntilNotVisible();
    }

/*    //Refactored: Scaled  to return text of each item when there could be multiple items in the minicart
        public String itemInMiniCart() {
        return miniCartContent.getText()
    }
*/

    public List<String> itemsInMiniCart(){
        return miniCartContents.stream()
                                                                .map(miniCartItem -> miniCartItem.getText())
                                                                .collect(Collectors.toList());
    }

/*    //Alternative using Serenity BDD's findAll method
    public List<String> itemsInMiniCart(){
        return findAll(By.cssSelector("#mini-cart li.product-item .product-item-name")).texts();
 }*/
}
