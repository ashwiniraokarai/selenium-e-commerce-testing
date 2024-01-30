package com.selenium.ecommerce.acceptancetests.accounts;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class LoginActions extends UIInteractions {
    @Step("Login with email {0} and password {1}")
    public void loginAsUserWith(String email, String password){
        openUrl("https://magento.softwaretestingboard.com");
        find(By.linkText("Sign In")).click();
        String loginPageTitle = getTitle();
        Assertions.assertThat(loginPageTitle).isEqualTo("Customer Login");

        find(By.cssSelector("#email")).type(email);
        find(By.cssSelector("#pass")).type(password);
        find(By.cssSelector("button#send2")).click();
    }

    @Step("Sign out")
    public void logout(){
        find(By.cssSelector("button[data-action='customer-menu-toggle']")).click();
        find(By.linkText("Sign Out")).click();
    }
}
