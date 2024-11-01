package org.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.test.pages.RecruitmentPage;
import org.testng.Assert;

import java.util.Map;

public class RecruitmentSteps {
    RecruitmentPage recruitmentPage = new RecruitmentPage();

    @Then("I click Add button at Recruitment page")
    public void iClickAddButtonAtRecruitmentPage() {
        recruitmentPage.clickAddBtn();
    }

    @When("I create new candidate with below information")
    public void iCreateNewCandidateWithBelowInformation(Map<String, String> data) {
        recruitmentPage.addNewCandidate(
                data.get("firstName"),
                data.get("lastName"),
                data.get("middleName"),
                data.get("vacancy"),
                data.get("email"),
                data.get("phone"),
                data.get("date")
        );
    }

    @Then("I see message {string} at Recruitment page")
    public void iSeeMessageAtRecruitmentPage(String expectedMessage) {
        Assert.assertEquals(recruitmentPage.getToastMessage(), expectedMessage);
    }
}
