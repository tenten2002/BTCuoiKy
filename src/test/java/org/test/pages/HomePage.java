package org.test.pages;

import org.example.elements.Element;
import org.example.elements.ListElement;
import org.openqa.selenium.By;

public class HomePage {
    ListElement menuMain = new ListElement(By.xpath("//ul[@class='oxd-main-menu']//li"));
    Element menuDashboard = new Element(By.xpath("//ul/li/a/span[text()='Dashboard']"));
    Element userDropdown = new Element(By.xpath("//span[@class='oxd-userdropdown-tab']"));
    ListElement menuDropdown = new ListElement(By.xpath("//ul[@role='menu']//li"));


    public HomePage() {

    }

    public String getDashboard() {
        return menuDashboard.waitVisibility().getText();
    }

    public void selectMenuMain(String menu) {
        menuMain.waitVisibility().clickElementWithText(menu);
    }

    public boolean isMenuDisplay() {
        return menuMain.waitVisibility().isDisplayed();
    }

    public void selectMenuDropdown() {
        userDropdown.waitVisibility().click();
        menuDropdown.waitVisibility().clickElementWithText("Logout");


    }

}

