package com.saucedemo.ecommerce.acceptancetests.footer;

import com.saucedemo.ecommerce.actions.FooterActions;
import com.saucedemo.ecommerce.actions.SubscribeActions;
import com.saucedemo.ecommerce.actions.NavigationActions;
import com.saucedemo.ecommerce.actions.PageHeadActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class SubscribeToMailingListTest {
    private NavigationActions navigationAction;
    private FooterActions footerActions;
    private PageHeadActions pageHeadActions;
    private SubscribeActions subscribeActions;

    @Test
    public void subscribeToMailingList() throws InterruptedException {
        /*open the landing page
         * click on subscribe in the footer to reveal the subscription form
         * enter email in the form
         * */
        navigationAction.openTheLumaLandingPage();
        footerActions.clickOnMailingListSubscription();
        Assertions.assertThat(pageHeadActions.pageTitle()).isEqualTo("Subscribe - Software Testing Board");

        subscribeActions.fillOutAndSubmitSubscriptionForm();
    }
}
