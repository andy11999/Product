package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageEbay {
    public WebDriver driver;

    public HomePageEbay(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage(){
        driver.get("https://ebay.com");
    }
    public void searchPage() {
        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//input[@value='Search']")).click();


    }
}
