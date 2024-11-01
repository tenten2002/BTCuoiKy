package org.example.elements;

import org.example.driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ListElement {

    public By getBy() {
        return By;
    }

    public void setBy(By by) {
        this.By = by;
    }

    private By By;

    public ListElement(By By) {
        this.By = By;

    }

    public ListElement waitVisibility() {
        DriverUtils.until(ExpectedConditions.visibilityOfElementLocated(getBy()));
        return this;
    }

    public List<WebElement> getElements() {
        return DriverUtils.getDriver().findElements(getBy());
    }

    public WebElement getElement(int index) {
        return getElements().get(index);
    }

    public void clickElementWithText(String expectedText) {
        List<WebElement> elements = getElements();
        for (WebElement element : elements) {
            if (element.getText().equals(expectedText)) {
                element.click();
                break;
            }
        }

    }

    public void clickFirst() {
        getFirstElement().click();
    }

    public WebElement getFirstElement() {
        return getElements().getFirst();
    }

    //    public void waitTextToBe(String text) {
//        DriverUtils.until(ExpectedConditions.textToBe(getBy(), text));
//    }
    public ListElement waitTextToBePresentInElement(String text) {
        DriverUtils.until(ExpectedConditions.textToBePresentInElementLocated(getBy(), text));
        return this;

    }
    public boolean isDisplayed() {
        return getElements().stream().allMatch(WebElement::isDisplayed);
    }

}
