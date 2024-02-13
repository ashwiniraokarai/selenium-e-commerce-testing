package com.seleniumeasy.demo.acceptancetests;

import com.SauceLabs;
import com.seleniumeasy.demo.pageobjects.InputFieldsFormWithoutSerenity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestsWithVanillaSelenium {
/*    Uncomment to run locally on your laptop
//    WebDriver driver;*/
    RemoteWebDriver driver;
    private InputFieldsFormWithoutSerenity inputFieldsFormWithoutSerenity;

    @BeforeEach
    public void setUpDriverInstance() throws MalformedURLException {
/*        //Uncomment to run on your laptop
        driver = new ChromeDriver();
        startBrowserLocally();
*/
        spinUpBrowserOnSauceLabsMachine();
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

    /*
    * Methods that should go into their own package and class file
    * */
    private void spinUpBrowserOnSauceLabsMachine() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", SauceLabs.getUserName());
        sauceOptions.put("accessKey", SauceLabs.getAccessKey());
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
         driver = new RemoteWebDriver(url, browserOptions);
    }

    private void startBrowserLocally() {
        driver = new ChromeDriver();
    }
}
