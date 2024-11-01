package org.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.test.pages.AdminPage;
import org.test.pages.HomePage;
import org.testng.Assert;

import java.util.Map;

public class AdminSteps {
    AdminPage adminPage = new AdminPage();

    @Then("I click Add button at Admin page")
    public void iClickAddButtonAtAdminPage() {
        adminPage.clickAddButton();
    }

    @When("I create new user with below information")
    public void iCreateNewUserWithBelowInformation(Map<String, String> data) {
        adminPage.createUser(data.get("userRole"),
                data.get("employeeName"),
                data.get("status"),
                data.get("userName"),
                data.get("password"),
                data.get("confirmPassword"));

    }

    @Then("I see message {string} at user page")
    public void iSeeMessageAtUserPage(String expectedMessage) {
        Assert.assertEquals(adminPage.getToastMessage(), expectedMessage);

    }


}
