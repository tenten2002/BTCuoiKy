package org.test.pages;

import org.example.elements.Element; // Đảm bảo đường dẫn import đúng
import org.openqa.selenium.By;

public class LoginPage {
    Element txtUsername = new Element(By.xpath("//input[@name='username']"));
    Element txtPassword = new Element(By.xpath("//input[@name='password']"));
    Element btnLogin = new Element(By.xpath("//button[@type='submit']"));

    public LoginPage() {
    }

    public void inputUsername(String username) {
        txtUsername.waitVisibility().sendKeys(username);
    }

    public void inputPassword(String password) {
        txtPassword.waitVisibility().sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.waitVisibility().click();
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLogin();
    }
}
