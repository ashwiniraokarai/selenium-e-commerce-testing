package com.selenium.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageObject {
    @FindBy(css = ".page-title")
    WebElementFacade productTitle;

    @FindBy(css = "div#option-label-size-143-item-167.swatch-option.text")
    WebElementFacade productSize;

    @FindBy(css = "div#option-label-color-93-item-57.swatch-option.color")
    WebElementFacade productColor;

    @FindBy(css = "#product-addtocart-button")
    WebElementFacade addToCartButton;

    public String textOfProductTitle(){
        return productTitle.getText();
    }

    public void addProductToCart() {
        productSize.click();
        productColor.click();
        addToCartButton.click();
        //System.out.println("Just so I can get a breakpoint here");
    }
}
