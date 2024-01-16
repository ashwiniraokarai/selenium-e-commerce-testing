package com.selenium.ecommerce.acceptancetests.navigation;

import com.selenium.ecommerce.actions.MenuBarActions;
import com.selenium.ecommerce.actions.NavigationActions;
import com.selenium.ecommerce.actions.PageHeadActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SerenityJUnit5Extension.class)
//Through extending the UIInteractions class, you don't have to worry about the boilerplate webdriver config code in your tests
public class MenuBarTest extends UIInteractions {
    //Let Serenity manage the instantiation of navigationAction for me. It'll also manage the driver object life cycles between objects
    @Steps
    NavigationActions navigationAction;
    @Steps
    MenuBarActions menuBarActions;
    @Steps
    private PageHeadActions pageHeadActions;

    @Test
    void shouldDisplayTheCorrectTitle(){
        // Before refactor: openUrl("https://magento.softwaretestingboard.com/");
        navigationAction.openTheLumaLandingPage();

       // Before refactor: String pageTitle = getTitle();
        String pageTitle = pageHeadActions.pageTitle();

       Assertions.assertThat(pageTitle).isEqualTo("Home Page");
    }

    @Test
    void composingSelectorsToGrabAllTopLevelMenuItems() {
        //Before refactor: openUrl("https://magento.softwaretestingboard.com/");
        navigationAction.openTheLumaLandingPage();;

        //Yields all elements that have css class called .level-top
        List<WebElementFacade> allTopLevels = findAll(By.cssSelector(".level-top"));

        //Know how many elements I'm getting
        System.out.println("Count of all top level elements: " + allTopLevels.size());

        /*    Investigate what  elements and what kind those elements are (using readable text and tag names)
                 Store findings in a Map of element tag names and text
         */
        Map<String, List<String>> mapOfElementTagNameAndText = new HashMap<String, List<String>>();

        /*   The result will help me determine if selector needs further filtering/ tweaking
        */
        for(WebElementFacade webElementFacade : allTopLevels){
            String elementTagNameAsKey = webElementFacade.getTagName();
            List<String> listOfTextOfElementsAsValue;
            String textOfElementAsListItem = webElementFacade.getText();

            // Start a new empty List (Value) in the Map for each new Key
            mapOfElementTagNameAndText.putIfAbsent(elementTagNameAsKey, new ArrayList<String>());

            // When a Key exists, Get the existing Value (List) , and Add a new element to the List
            listOfTextOfElementsAsValue = mapOfElementTagNameAndText.get(elementTagNameAsKey);
            listOfTextOfElementsAsValue.add(textOfElementAsListItem);
        }

        //Map contents tell me there are li items as well as link (a) items that match this selector
        System.out.println(mapOfElementTagNameAndText);

        //Using the intel I have, tweak the selector further to filter elements that I am interested in
        //Yields only 'a' elements that have css class .level-top
        List<WebElementFacade> allTopLevelLinks = findAll(By.cssSelector("a.level-top"));

        //Know how many elements I'm getting
        System.out.println("Count of top level elements that should have 'a' tag: " + allTopLevelLinks.size());

        //Confirm the elements by text and kind
        mapOfElementTagNameAndText.clear();
        for(WebElementFacade webElementFacade : allTopLevelLinks){
            mapOfElementTagNameAndText.putIfAbsent(webElementFacade.getTagName(), new ArrayList<String>());
            mapOfElementTagNameAndText.get(webElementFacade.getTagName()).add(webElementFacade.getText());
        }

        //Map tells me there are 'a' elements only
        System.out.println(mapOfElementTagNameAndText);
    }

    @Test
    void shouldShowTopLevelMenuItems() {
        //Before refactor: openUrl("https://magento.softwaretestingboard.com/");
        navigationAction.openTheLumaLandingPage();

        //Using a previously tested selector (on dev tools and thro the previous test in detail)
        //.texts() is a convenient method from serenitybdd-core lib. Allows you to skip looping thro the elements in the List.
        //Before refactor: List<String> allTopMenuItems = findAll(By.cssSelector("a.level-top")).texts();
        List<String> allTopMenuItems = menuBarActions.textOfTopLevelMenuItems();

        Assertions.assertThat(allTopMenuItems).containsExactly("What's New","Women", "Men", "Gear", "Training", "Sale");
    }
}
