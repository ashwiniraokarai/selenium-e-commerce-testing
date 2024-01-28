package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class RegisterAccountActions extends UIInteractions {
    @Step("Register account for {0} {1} with email {2} and password {3}")
    public void registerAccountFor(String firstName, String lastName, String email, String password){
        openUrl("https://magento.softwaretestingboard.com/");
        find(By.linkText("Create an Account")).click();

        String newAccountPageTitle = getTitle();
        Assertions.assertThat(newAccountPageTitle).isEqualTo("Create New Customer Account");

        find(By.cssSelector("#firstname")).type(firstName);
        find(By.cssSelector("#lastname")).type(lastName);
        find(By.cssSelector("#email_address")).type(email);
        find(By.cssSelector("#password")).type(password);
        find(By.cssSelector("#password-confirmation")).type(password);

        find(By.cssSelector("button.submit[type='submit']")).click();
    }
}
