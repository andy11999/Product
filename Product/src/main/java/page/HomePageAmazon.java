package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageAmazon extends BasePage {
    public HomePageAmazon(WebDriver driver) {
        super(driver);

    }

    By searchTextBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");

    public SearchPageAmazon goToSearchPage(String key){
        writeText(searchTextBox,key);
        click(searchButton);
        return new SearchPageAmazon(driver);
    }

}
