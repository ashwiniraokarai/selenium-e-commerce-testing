package com.saucedemo.ecommerce.acceptancetests.productcatalog;

import com.saucedemo.ecommerce.actions.PageHeadActions;
import com.saucedemo.ecommerce.actions.ProductCatalogActions;
import com.saucedemo.ecommerce.actions.ProductDetailsActions;
import com.saucedemo.ecommerce.actions.NavigationActions;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class ViewProductDetailsTest extends UIInteractions {
    NavigationActions navigate;
    private PageHeadActions productDetail;
    private ProductCatalogActions productCatalog;
    private ProductDetailsActions productDetailsActions;
    private String productName = "Radiant Tee";

    @Test
    public void shouldOpenTheProductDetailPage(){
        navigate.openTheLumaLandingPage();
        productCatalog.clickOnProduct(productName);

        //Assert on the html header page title
        Assertions.assertThat(productDetail.pageTitle()).isEqualTo(productName);

        //Assert on the heading showing on the body of the page
        Assertions.assertThat(productDetailsActions.productHeadingOnPage()).isEqualTo(productName);
    }
}
