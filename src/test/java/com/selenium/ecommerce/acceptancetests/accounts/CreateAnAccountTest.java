package com.selenium.ecommerce.acceptancetests.accounts;

import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateAnAccountTest extends UIInteractions {
    @Test
    public void shouldCreateANewAccount(){
        openUrl("https://magento.softwaretestingboard.com/");
        find(By.linkText("Create an Account")).click();

        String newAccountPageTitle = getTitle();
        Assertions.assertThat(newAccountPageTitle).isEqualTo("Create New Customer Account");

        String firstName = "Successful Account";
        String lastName = "User";
        find(By.cssSelector("#firstname")).type(firstName);
        find(By.cssSelector("#lastname")).type(lastName);

        String email = generateUniqueEmail();
        find(By.cssSelector("#email_address")).type(email);

        String password = "Complex143@password";
        find(By.cssSelector("#password")).type(password);
        find(By.cssSelector("#password-confirmation")).type(password);

        find(By.cssSelector("button.submit[type='submit']")).click();

        String successMessage = find(By.cssSelector(".message-success")).getText();
        String expectedSuccessMessage = "Thank you for registering with Main Website Store.";
        Assertions.assertThat(successMessage).isEqualTo(expectedSuccessMessage);
        waitForTextToAppear(successMessage);
    }

    /*Refactor: Model the above test after Action Objects and Page Objects
    * */
    public String generateUniqueEmail(){
       return "test.user+" +System.currentTimeMillis() +"@popularEmailService.com";
    }
}
