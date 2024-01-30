package com.selenium.ecommerce.acceptancetests.shoppingcart;

import com.selenium.ecommerce.actions.NavigationActions;
import com.selenium.ecommerce.pageobjects.HotSellersSectionComponent;
import com.selenium.ecommerce.pageobjects.LumaHomePage;
import com.selenium.ecommerce.pageobjects.ProductDetailsPage;
import com.selenium.ecommerce.pageobjects.ShoppingCartComponent;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(SerenityJUnit5Extension.class)
public class DisplayItemsInTheCartTest extends UIInteractions {
    private NavigationActions navigationActions;
    LumaHomePage lumaHomePage;
    ShoppingCartComponent shoppingCartComponent;
    HotSellersSectionComponent hotSellersSectionComponent;
    private ProductDetailsPage productDetailsPage;

    //Without Page Objects
    @Test
    public void showItemsInTheCart(){
        navigationActions.openTheLumaLandingPage();
        find(By.className("showcart")).click();
        waitForTextToAppear("You have no items in your shopping cart.");
    }

    //Same test as above but With Page Objects
    @Test
    public void showItemsInTheCartUsingPageObjects(){
        lumaHomePage.openPage();

     /*   //does not show intent:
        shoppingCartComponent.shoppingCartIconWithLink().click();
      */

        //shows intent:
        shoppingCartComponent.showCartSummary();
        waitForTextToAppear("You have no items in your shopping cart.");
    }

    //Page Object Model
    @Test
    public void canAddSingleItemToShoppingCart(){
        String productTitle = "Breathe-Easy Tank";

        lumaHomePage.openPage();
        hotSellersSectionComponent.selectHotSellerItemImageWith(productTitle);
        Assertions.assertThat(productDetailsPage.textOfProductTitle()).isEqualTo(productTitle);

        productDetailsPage.addProductToCart();
        shoppingCartComponent.waitForCartIconToUpdateCount();
        shoppingCartComponent.showCartSummary();

        Assertions.assertThat(shoppingCartComponent.productTitleInMiniCart()).isEqualTo(productTitle);
    }

    //"Scaled" version of the above Test
    @Test
    public void canAddMultipleItemsToShoppingCart(){

    }
}
