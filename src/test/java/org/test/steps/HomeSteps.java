package org.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.test.pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @And("I logout account Admin")
    public void iLogoutAccountAdmin() {
        homePage.selectMenuDropdown();
    }

    @Then("I should see list menu main")
    public void iShouldSeeListMenuMain() {
        assert homePage.isMenuDisplay();
    }

    @And("I choose menu {string}")
    public void iChooseMenu(String menu) {
        homePage.selectMenuMain(menu);
    }

}
