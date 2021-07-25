package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     This method accepts a List<WebElements> and returns List<String>
     @param webElementList
     */
    public static List<String> getElementsText(List<WebElement> webElementList){

        //Create placeholder List<String>
        List<String> actualAsString = new ArrayList<>();

        for (WebElement each : webElementList) {

            actualAsString.add(each.getText());

        }

        return actualAsString;

    }


    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in the sleep method");
        }
    }
}
