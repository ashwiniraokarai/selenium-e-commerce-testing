package com.selenium.ecommerce.acceptancetests.productcatalog;

import com.selenium.ecommerce.actions.NavigationActions;
import com.selenium.ecommerce.actions.PageHeadActions;
import com.selenium.ecommerce.actions.ProductCollectionsActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class ViewCollectionsTest {
    private NavigationActions navigationActions;
    private PageHeadActions pageHeadActions;
    private ProductCollectionsActions productCollectionsAction;

    @Test
    public void shouldOpenTheProductCollectionsPage(){
        String productCollectionText = "New Luma Yoga Collection";

        navigationActions.openTheLumaLandingPage();
        productCollectionsAction.clickOnProductCollection(productCollectionText);

        Assertions.assertThat(pageHeadActions.pageTitle()).isEqualTo(productCollectionText);
    }
}
