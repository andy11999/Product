package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageAmazon extends BasePage {
    public HomePageAmazon(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

//    By searchTextBox = By.id("twotabsearchtextbox");
//    By searchButton = By.id("nav-search-submit-button");
//
//    public SearchPageAmazon goToSearchPage(String key){
//        writeText(searchTextBox,key);
//        click(searchButton);
//        return new SearchPageAmazon(driver);
//    }
    @FindBy(id="twotabsearchtextbox")
    WebElement searchTextbox;

    @FindBy(id="nav-search-submit-button")
    WebElement searchButton;

    public SearchPageAmazon goToSearchPage(String key){
        writeText(searchTextbox,key);
        click(searchButton);
        return new SearchPageAmazon(driver);
    }

}
