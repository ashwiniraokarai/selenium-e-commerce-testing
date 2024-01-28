package com.selenium.ecommerce.acceptancetests.accounts;

import com.selenium.ecommerce.actions.RegisterAccountActions;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAnAccountTest extends UIInteractions {
    private RegisterAccountActions registerAccount;
    private LoginActions login;

    @Test
    public void shouldCreateANewAccount(){
        registerAccount.registerAccountFor("Successful Account", "User", generateUniqueEmail(), "Complex143@password");

        //        String successMessage = find(By.cssSelector(".message-success")).getText();
        //        Assertions.assertThat(successMessage).isEqualTo(expectedSuccessMessage);
        String expectedSuccessMessage = "Thank you for registering with Main Website Store.";
        waitForTextToAppear(expectedSuccessMessage);
    }

    @Test
    public void canLoginIntoRegisteredAccount(){
        String firstName = "Successful Account";
        String lastName = "User";
         String email = generateUniqueEmail();
         String password = "Complex143@password";

         registerAccount.registerAccountFor(firstName, lastName, email, password);

         login.logout();
         login.loginAsUserWith(email, password);
        waitForTextToAppear("Welcome, " + firstName + " " + lastName + "!");
    }
    public String generateUniqueEmail(){
       return "test.user+" +System.currentTimeMillis() +"@popularEmailService.com";
    }
}
