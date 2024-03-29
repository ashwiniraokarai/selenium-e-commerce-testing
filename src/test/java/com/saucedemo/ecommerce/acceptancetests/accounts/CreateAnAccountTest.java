package com.saucedemo.ecommerce.acceptancetests.accounts;

import com.saucedemo.ecommerce.actions.RegisterAccountActions;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreateAnAccountTest extends UIInteractions {
    private RegisterAccountActions registerAccount;
    private LoginActions login;

    @Test
    public void shouldCreateANewAccount(){
        registerAccount.registerAccountFor("Successful Account", "User", generateUniqueEmail(), "Complex143@password");

        String expectedSuccessMessage = "Thank you for registering with Main Website Store.";
        waitForTextToAppear(expectedSuccessMessage);
        //   String successMessage = find(By.cssSelector(".message-success")).getText();
        //   Assertions.assertThat(successMessage).isEqualTo(expectedSuccessMessage);
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

    @AfterEach
    public void tearDown(){
        login.logout();
    }
}
