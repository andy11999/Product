package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageEbay extends BasePage {


    public HomePageEbay(WebDriver driver) {
        super(driver);
    }

    By searchTextBox = By.xpath("//input[@placeholder='Search for anything']");
    By searchButton = By.xpath("//input[@value='Search']");

    public SearchPageEbay goToSearchPage(String key){
        writeText(searchTextBox,key);
        click(searchButton);
        return new SearchPageEbay(driver);
    }

}
