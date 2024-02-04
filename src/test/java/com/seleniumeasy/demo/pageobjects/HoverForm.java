package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HoverForm extends PageObject {
    public WebElementFacade personImage(Integer position){
        return find(By.xpath("//*[@class='figure']["+position+"]"));
        //Example: return find(By.xpath("//*[@class='figure'][1]"));
    }

    public WebElementFacade captionForImage(Integer position) {
        return find(By.xpath("(//*[@class='figcaption'])["+position+"]"));
        //Example: return find(By.xpath("(//*[@class='figcaption'])[1]"));
    }

    public void openHoverFormPage() {
        openUrl("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverOverElement(Integer position) {
        new Actions(getDriver()).moveToElement(personImage(1)).perform();
    }
}
