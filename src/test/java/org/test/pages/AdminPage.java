package org.test.pages;

import org.example.elements.Element;
import org.example.elements.ListElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.example.driver.DriverUtils.driver;

public class AdminPage {
    Element btnAdd = new Element(By.xpath("//button[contains(.,'Add')]"));
    Element sltUserRole = new Element(By.xpath("//div[.= 'User Role']/following-sibling::div/div"));
    Element txtEmployeeName = new Element(By.xpath("//input[@placeholder='Type for hints...']"));
    Element sltStatus = new Element(By.xpath("//div[.= 'Status']/following-sibling::div/div"));
    Element txtUserName = new Element(By.xpath("//div[.= 'Username']/following-sibling::div/input"));
    Element txtPassword = new Element(By.xpath("//div[.= 'Password']/following-sibling::div/input"));
    Element txtConfirmPassword = new Element(By.xpath("//div[.= 'Confirm Password']/following-sibling::div/input"));
    ListElement listBox = new ListElement(By.xpath("//div[@role='listbox']//div//span"));
    //Element lblSearching = new Element(By.xpath("//div[@role='listbox']//div[@role='option' and text()='Searching....']"));
    Element btnSave = new Element(By.xpath("//button[@type='submit']"));
    Element toastMessage = new Element(By.xpath("//p[contains(@class,'oxd-text--toast-message')]"));

    public AdminPage() {
    }

    public void clickAddButton() {
        btnAdd.waitVisibility().click();
    }

    public void selectRole(String userRole) {
        sltUserRole.waitVisibility().click();
        listBox.waitVisibility().clickElementWithText(userRole);
    }

    public void selectEmployeeName(String employeeName) {
        txtEmployeeName.waitVisibility().sendKeys(employeeName);
        listBox.waitVisibility().clickFirst();

    }

    public void selectStatus(String status) {
        sltStatus.waitVisibility().click();
        listBox.waitVisibility().clickElementWithText(status);
    }

    public void inputUserName(String userName) {
        txtUserName.waitVisibility().sendKeys(userName);
    }

    public void inputPassword(String password) {
        txtPassword.waitVisibility().sendKeys(password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        txtConfirmPassword.waitVisibility().sendKeys(confirmPassword);
    }

    public void clickSaveBtn() {
        btnSave.click();
    }

    public String getToastMessage() {
        return toastMessage.waitVisibility().getText();
    }


    public void createUser(String userRole, String employeeName, String status, String userName, String password, String confirmPassword) {
        selectRole(userRole);
        selectEmployeeName(employeeName);
        selectStatus(status);
        inputUserName(userName);
        inputPassword(password);
        inputConfirmPassword(confirmPassword);
        clickSaveBtn();

    }
}