package com.LocationAbstractFactory.cities; 
/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 */
public class ChisinauCity implements City {

    @Override
    public void makeCommand() {
        System.out.println("Searching a taxi around Chisinau");
    }
}