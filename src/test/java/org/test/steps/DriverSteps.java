package org.test.steps;

import io.cucumber.java.en.Given;
import org.example.driver.DriverUtils;


public class DriverSteps {


    @Given("I open browser")
    public void iOpenBrowser() {
        DriverUtils.init("chrome");
        DriverUtils.maximum();
    }


}
