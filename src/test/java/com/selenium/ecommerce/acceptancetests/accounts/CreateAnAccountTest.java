package com.selenium.ecommerce.acceptancetests.accounts;

import com.selenium.ecommerce.actions.RegisterAccountActions;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateAnAccountTest extends UIInteractions {
    private RegisterAccountActions registerAccount;

    @Test
    public void shouldCreateANewAccount(){
        registerAccount.registerAccountAs("Successful Account", "User", generateUniqueEmail(), "Complex143@password");

        //        String successMessage = find(By.cssSelector(".message-success")).getText();
        //        Assertions.assertThat(successMessage).isEqualTo(expectedSuccessMessage);
        String expectedSuccessMessage = "Thank you for registering with Main Website Store.";
        waitForTextToAppear(expectedSuccessMessage);
    }

    public String generateUniqueEmail(){
       return "test.user+" +System.currentTimeMillis() +"@popularEmailService.com";
    }
}
