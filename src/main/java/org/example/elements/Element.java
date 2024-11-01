package org.example.elements;

import org.example.driver.DriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Element {
    static final long TIMEOUT = 10;

    public List<WebElement> getElements() {
        return DriverUtils.findElements(by);

    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    private By by;

    public Element(By by) {
        this.by = by;

    }

    public WebElement getElement() {
        return DriverUtils.findElement(by);
    }

    public Element click() {
        getElement().click();
        return this;
    }


    public Element submit() {
        getElement().submit();
        return this;
    }


    public Element sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend);
        return this;
    }


    public Element clear() {
        getElement().clear();
        return this;

    }


    public String getTagName() {
        return getElement().getTagName();
    }


    public String getAttribute(String value) {
        return getElement().getAttribute(value);
    }


    public boolean isSelected() {
        return false;
    }


    public boolean isEnabled() {
        return false;
    }


    public String getText() {
        return getElement().getText().trim();
    }


    public List<WebElement> findElements(By by) {
        return List.of();
    }


    public WebElement findElement(By by) {
        return null;
    }


    public boolean isDisplayed() {
        return false;
    }


    public Point getLocation() {
        return null;
    }


    public Dimension getSize() {
        return null;
    }


    public Rectangle getRect() {
        return null;
    }


    public String getCssValue(String propertyName) {
        return "";
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    public Element waitVisibility() {
        return waitVisibility(TIMEOUT);
    }

    public Element waitVisibility(long timeoutInSecond) {
        DriverUtils.until(timeoutInSecond, ExpectedConditions.visibilityOfElementLocated(getBy()));
        return this;

    }

    public Element waitClickable() {
        return waitClickable(TIMEOUT);
    }

    public Element waitClickable(long timeoutInSecond) {
        DriverUtils.until(timeoutInSecond, ExpectedConditions.elementToBeClickable(getBy()));
        return this;
    }

    public Element waitTextIsNot(String text) {
        return waitTextIsNot(TIMEOUT, text);

    }

    public Element waitTextIsNot(long timeoutInSecond, String text) {
        DriverUtils.until(timeoutInSecond, d -> {
            WebElement e = getElement();
            if (e != null) {
                String txt = e.getText();
                if (txt != null && !txt.isEmpty() && !txt.equalsIgnoreCase(text))
                    return true;
            }
            return false;
        });
        return this;
    }

    public Element waitPresence(long timeoutInSecond) {
        DriverUtils.until(timeoutInSecond, ExpectedConditions.presenceOfElementLocated(getBy()));
        return this;
    }

    public void waitInvisibility() {
        DriverUtils.until(ExpectedConditions.invisibilityOfElementLocated(getBy()));//
    }

    public void waitTextToBe(String text) {
        DriverUtils.until(ExpectedConditions.textToBe(getBy(), text));

    }


    public void scrollTo() {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    public Element clearValueScript() {
        DriverUtils.executeScript("arguments[0].value = '';", getElement());
        return this;
    }

    public Element clickUsingJavaScript() {
        DriverUtils.executeScript("arguments[0].click();", getElement());
        return this;
    }
}

