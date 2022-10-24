package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageAmazon {
    public static WebDriver driver;
    public HomePageAmazon(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage(){
        driver.get("https://amazon.com");
    }
    public void searchPage() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
