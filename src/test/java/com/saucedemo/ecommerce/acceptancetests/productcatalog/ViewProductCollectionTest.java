package com.saucedemo.ecommerce.acceptancetests.productcatalog;

import com.saucedemo.ecommerce.actions.NavigationActions;
import com.saucedemo.ecommerce.actions.PageHeadActions;
import com.saucedemo.ecommerce.actions.ProductCollectionActions;
import com.saucedemo.ecommerce.selectors.ProductCollectionPromptFauxButton;
import com.saucedemo.ecommerce.actions.ProductCollectionPromptActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class ViewProductCollectionTest{
    private NavigationActions navigationActions;
    private PageHeadActions pageHeadActions;
    private ProductCollectionPromptActions productCollectionsAction;
    private ProductCollectionActions productCollectionsListingsActions;
    private ProductCollectionPromptFauxButton productCollectionPromptFauxButton;

    // By Partial Link
    @Test
    public void shouldOpenTheProductCollectionsPage(){
        String productCollectionText = "New Luma Yoga Collection";

        navigationActions.openTheLumaLandingPage();
        productCollectionsAction.clickOnProductCollection(productCollectionText);

        Assertions.assertThat(pageHeadActions.pageTitle()).isEqualTo(productCollectionText);
    }

    //Same logic as previous test except:
    // the trigger is the Shop New Yoga element specifically (as opposed to the link)
    // and selector is XPath
    @Test
    public void shouldDisplayTheProductCollectionPage(){
        String expectedCollectionsHeadingOnListingsPage = "New Luma Yoga Collection";

        navigationActions.openTheLumaLandingPage();

        //A more generalized selector achieved through regular method parameterization
        productCollectionPromptFauxButton.withExactText("Shop New Yoga").click();

        /* //Any of these selectors would have worked too - each shows a different XPath technique
         * shopNewYogaFauxButtonUsingClassNamesEquality().click();
         * shopNewYogaFauxButtonUsingClassNamesContains().click();
         * shopNewYogaFauxButtonUsingTextEquality().click();
         */
        Assertions.assertThat(productCollectionsListingsActions.collectionsHeadingOnPage()).isEqualTo(expectedCollectionsHeadingOnListingsPage);
    }
}
