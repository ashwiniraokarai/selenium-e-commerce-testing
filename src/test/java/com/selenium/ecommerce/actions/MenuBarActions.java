package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

import java.util.List;

public class MenuBarActions extends UIInteractions {
    @Step
    public List<String> textOfTopLevelMenuItems() {
        return findAll(By.cssSelector("a.level-top")).texts();
    }
}
