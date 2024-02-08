package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.InputFieldsFormWithoutSerenity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsWithVanillaSelenium {
    WebDriver driver;
    private InputFieldsFormWithoutSerenity inputFieldsFormWithoutSerenity;

    @BeforeEach
    public void setUpDriverInstance(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void closeTheScreen(){
        driver.quit();
    }

    //Still uses Serenity brought drivers I think
    @Test
    public void aTestWithoutSerenityMethods(){
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        driver.findElement(By.cssSelector("input#user-message")).sendKeys("Selenium without serenity");

        driver.findElement(By.xpath("//button[text()='Show Message']")).click();

       String displayMessage = driver.findElement(By.cssSelector("#display")).getText();

       Assertions.assertThat(displayMessage).isEqualTo("Selenium without serenity");
    }

    @Test
    public void aTestWithoutSerenityMethodsUsingPageObjects(){
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        //Establish connection with the Page Object within the test. This way we can send along an instantiated driver.
        inputFieldsFormWithoutSerenity = new InputFieldsFormWithoutSerenity(driver);

        inputFieldsFormWithoutSerenity.enterMessage("Selenium with Page Objects without Serenity");

        inputFieldsFormWithoutSerenity.submit();

        String displayedMessage = inputFieldsFormWithoutSerenity.getDisplayedMessage();

        Assertions.assertThat(displayedMessage).isEqualTo("Selenium with Page Objects without Serenity");
    }
}
