package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageEbay extends BasePage {


    public HomePageEbay(WebDriver driver) {
        super(driver);
    }
    String appURL="https://ebay.com";
    public HomePageEbay getPage() {
        driver.get(appURL);
        return this;
    }
    By searchTextBox = By.xpath("//input[@placeholder='Search for anything']");
    By searchButton = By.xpath("//input[@value='Search']");

    public SearchPageEbay goToSearchPage(){
        writeText(searchTextBox,"iPhone 11");
        click(searchButton);
        return new SearchPageEbay(driver);
    }

}
