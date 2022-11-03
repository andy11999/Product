package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void waitClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    public void waitClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By elementBy) {
        waitClickable(elementBy);
        driver.findElement(elementBy).click();
    }
    public void writeText(WebElement element, String text){
        waitVisibility(element);
        element.sendKeys(text);
    }
    public void click(WebElement element){
        waitClickable(element);
        element.click();
    }


    public List<WebElement> getElements(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }

    public void gotoUrl(String url) {
        this.driver.get(url);
    }


}
