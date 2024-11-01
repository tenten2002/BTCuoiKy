package org.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.test.pages.PIMPage;
import org.testng.Assert;

import java.util.Map;

public class PIMSteps {
    PIMPage pimPage = new PIMPage();

    @When("I search user with below information")
    public void iSearchUserWithBelowInformation(Map<String, String> data) {
        pimPage.inputEmployeeName(data.get("employeeName"));
        pimPage.inputEmployeeId(data.get("employeeId"));
        pimPage.selectEmploymentStatus(data.get("employmentStatus"));
        pimPage.selectInclude(data.get("include"));
        pimPage.selectJobTitle(data.get("jobTitle"));
        pimPage.clickSearchButton();
    }

    @Then("I click icon edit at user list")
    public void iClickIconEditAtUserList() {
        pimPage.clickEditIcon();
    }

    @And("I choose tabmenu {string}")
    public void iChooseTabmenu(String tabmenu) {
        pimPage.selectTab(tabmenu);
    }

    @When("I update personal details with below information")
    public void iUpdatePersonalDetailsWithBelowInformation(Map<String, String> data) {
        pimPage.updatePersonalDetails(
                data.get("firstName"),
                data.get("lastName"),
                data.get("otherId"),
                data.get("nationality")
        );
    }

    @When("I update contact information with below information")
    public void iUpdateContactInformationWithBelowInformation(Map<String, String> data) {
        pimPage.updateContactInformation(
                data.get("street1"),
                data.get("street2"),
                data.get("city"),
                data.get("state"),
                data.get("zipCode"),
                data.get("country")
        );
    }

    @Then("I see message {string} at Personal Details page")
    public void iSeeMessageAtPersonalDetailsPage(String expectedMessage) {
        Assert.assertEquals(pimPage.getToastMessage(), expectedMessage);
    }

    @Then("I see message {string} at Contact Details page")
    public void iSeeMessageAtContactDetailsPage(String expectedMessage) {
        Assert.assertEquals(pimPage.getToastMessage(), expectedMessage);
    }
}
