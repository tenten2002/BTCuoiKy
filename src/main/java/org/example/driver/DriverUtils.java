package org.example.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class DriverUtils {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver d) {
        driver = d;
    }

    public static void init(String type) {
        switch (type) {
            case "chrome":
                setDriver(new ChromeDriver());
                break;
            default:
                throw new RuntimeException("Unsupported browser" + type);

        }
    }

    public static WebElement findElement(By by) {
        System.out.println("Log element: " + by);
        return getDriver().findElement(by);
    }

    public static void maximum() {
        getDriver().manage().window().maximize();
    }

    public static void url(String url) {
        getDriver().get(url);
    }

    public static void quit() {
        if (getDriver() != null) getDriver().quit();
    }

    public static void screenshot() {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(srcFile, new File("C:\\Users\\Admin\\Desktop\\screenshot.png"));
        System.out.println(srcFile);
    }

    public static void until(long timeoutInSecond, Function isTrue) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSecond));
        wait.until(isTrue);
    }

    public static void until(Function isTrue) {
        until(60, isTrue);
    }

    public static String getValue(By by) {
        try {
            return findElement(by).getAttribute("value");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + by);
            return null;
        }
    }


    public static List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public static void executeScript(String script, Object... args) {
        ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }
    public boolean isBrowserOpen() {
        try {
            return driver != null && ((RemoteWebDriver) driver).getSessionId() != null;
        } catch (Exception e) {
            return false;
        }
    }


}
