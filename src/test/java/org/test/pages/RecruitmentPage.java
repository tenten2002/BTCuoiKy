package org.test.pages;

import org.example.elements.ListElement;
import org.example.elements.Element;
import org.openqa.selenium.By;

public class RecruitmentPage {
    Element btnAdd = new Element(By.xpath("//button[contains(.,'Add')]"));
    Element txtFirstName = new Element(By.xpath("//input[@name='firstName']"));
    Element txtLastName = new Element(By.xpath("//input[@name='lastName']"));
    Element txtMiddleName = new Element(By.xpath("//input[@name='middleName']"));
    Element sltVacancy = new Element(By.xpath("//div[.= 'Vacancy']/following-sibling::div/div"));
    ListElement listVacancy = new ListElement(By.xpath("//div[@role='listbox']//div//span"));
    Element txtEmail = new Element(By.xpath("//div[.='Email']//input"));
    Element txtPhone = new Element(By.xpath("//div[.='Contact Number']//input"));
    Element txtDate = new Element(By.xpath("//div[@class='oxd-date-input']"));
    ListElement listDate = new ListElement(By.xpath("//div[@class='oxd-calendar-dates-grid']/div"));
    Element checkbox = new Element(By.xpath("//span[contains(@class,'checkbox')]"));
    Element btnSave = new Element(By.xpath("//button[@type='submit']"));
    Element toastMessage = new Element(By.xpath("//p[contains(@class,'oxd-text--toast-message')]"));

    public RecruitmentPage() {
    }

    public void clickAddBtn() {
        btnAdd.waitVisibility().click();
    }

    public void inputFirstName(String firstName) {
        txtFirstName.waitVisibility().sendKeys(firstName);
    }

    public void inputMiddleName(String middleName) {
        txtMiddleName.waitVisibility().sendKeys(middleName);
    }

    public void inputLastName(String lastName) {
        txtLastName.waitVisibility().sendKeys(lastName);
    }

    public void selectVacancy(String vacancy) {
        sltVacancy.waitVisibility().click();
        listVacancy.waitVisibility().clickElementWithText(vacancy);
    }

    public void inputEmail(String email) {
        txtEmail.waitVisibility().sendKeys(email);
    }

    public void inputPhone(String phone) {
        txtPhone.waitVisibility().sendKeys(phone);
    }

    public void inputDate(String date) {
        txtDate.waitVisibility().click();
        listDate.waitVisibility().clickElementWithText(date);
    }

    public void clickCheckbox() {
        checkbox.waitClickable().click();
    }

    public void clickSaveBtn() {
        btnSave.waitVisibility().click();
    }

    public String getToastMessage() {
        return toastMessage.waitVisibility().getText();
    }

    public void addNewCandidate(String firstName, String lastName, String middleName, String vacancy, String email, String phone, String date) {
        inputFirstName(firstName);
        inputLastName(lastName);
        inputMiddleName(middleName);
        selectVacancy(vacancy);
        inputEmail(email);
        inputPhone(phone);
        inputDate(date);
        clickCheckbox(); // Nếu checkbox có liên quan
        clickSaveBtn();
    }
}
