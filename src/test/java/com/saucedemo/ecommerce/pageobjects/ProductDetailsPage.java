package com.saucedemo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageObject {
    @FindBy(css = ".page-title")
    WebElementFacade productTitle;

    @FindBy(css = "#product-addtocart-button")
    WebElementFacade addToCartButton;

    /* //Refactored: Moved selector to a method instead, to open up parameter options
 @FindBy(css = "[option-label='S']")
 WebElementFacade productSize;
  */

    /*//Refactored: Moved selector to a method instead, to open up parameter options
    @FindBy(css = "[option-label='Yellow']")
     WebElementFacade productColor;
    * */

    public WebElementFacade productSize(String size){
        return find(By.cssSelector("[option-label='"+size+"']"));
    }

    public WebElementFacade productColor(String color){
        return  find(By.cssSelector("[option-label='"+color+"']"));
    }
    public String textOfProductTitle(){
        return productTitle.getText();
    }

    public void chooseProductFeatures(String size, String color) {
        productSize(size).click();
        productColor(color).click();
    }

    public void addProductToCart() {
        addToCartButton.click();
        //System.out.println("Just so I can get a breakpoint here");
    }
}
