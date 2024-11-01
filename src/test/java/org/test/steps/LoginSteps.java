package org.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.test.pages.LoginPage;
import org.example.driver.DriverUtils;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        DriverUtils.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Navigate to the login page");
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String user, String pass) {
        loginPage.login(user, pass);
    }

}


