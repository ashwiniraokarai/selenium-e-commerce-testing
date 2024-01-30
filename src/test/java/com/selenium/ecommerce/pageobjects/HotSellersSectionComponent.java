package com.selenium.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class HotSellersSectionComponent extends  PageComponent {
/* Not adopting the FindBy annotation for this selector.
     Using a regular method instead so  I can vary the alt text based on input
    @FindBy(css = "img[alt='Breathe-Easy Tank']")
    WebElementFacade hotSellerItem;
    */
    public WebElementFacade hotSellerItemImageWith(String altText){
        return find(By.cssSelector("img[alt='" + altText +"']"));
    }

    public void selectHotSellerItemImageWith(String altText) {
        hotSellerItemImageWith(altText).click();
    }
}
