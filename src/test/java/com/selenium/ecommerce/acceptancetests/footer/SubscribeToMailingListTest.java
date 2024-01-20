package com.selenium.ecommerce.acceptancetests.footer;

import com.selenium.ecommerce.actions.FooterActions;
import com.selenium.ecommerce.actions.NavigationActions;
import com.selenium.ecommerce.actions.PageHeadActions;
import com.selenium.ecommerce.actions.SubscribeActions;
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

/*   //Revisit and get the assertion to work with appropriate waiting startegy
        String expectedAfterSubscriptionText = "Almost finished... We need to confirm your email address. To complete the subscription process, please click the link in the email we just sent you.";
        Assertions.assertThat(subscribeActions.afterSubscriptionText()).isEqualTo(expectedAfterSubscriptionText);*/
    }
}
