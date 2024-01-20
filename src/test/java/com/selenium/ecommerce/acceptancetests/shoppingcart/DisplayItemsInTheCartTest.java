package com.selenium.ecommerce.acceptancetests.shoppingcart;

import com.selenium.ecommerce.actions.NavigationActions;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(SerenityJUnit5Extension.class)
public class DisplayItemsInTheCartTest extends UIInteractions {
    private NavigationActions navigationActions;

    @Test
    public void showItemsInTheCart(){
        navigationActions.openTheLumaLandingPage();
        find(By.className("showcart")).click();
        waitForTextToAppear("You have no items in your shopping cart.");
    }
}
