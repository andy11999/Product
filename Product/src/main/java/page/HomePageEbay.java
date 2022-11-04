package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageEbay extends BasePage {


    public HomePageEbay(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

//    By searchTextBox = By.xpath("//input[@placeholder='Search for anything']");
//    By searchButton = By.xpath("//input[@value='Search']");
//
//    public SearchPageEbay goToSearchPage(String key){
//        writeText(searchTextBox,key);
//        click(searchButton);
//        return new SearchPageEbay(driver);
//    }

    @FindBy (xpath="//input[@placeholder='Search for anything']")
    WebElement searchTextbox;

    @FindBy (xpath="//input[@value='Search']")
    WebElement searchButton;

    public SearchPageEbay goToSearchPage(String key){
        writeText(searchTextbox,key);
        click(searchButton);
        return new SearchPageEbay(driver);
    }


}
