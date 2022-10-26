package page;

import core.BasePage;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class SearchPageAmazon extends BasePage {

    String title = "";
    String productName = "";
    float price;
    String link = "";
    public SearchPageAmazon(WebDriver driver) {
        super(driver);
    }

    public List<Product> extractData(String key) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> listProducts = new ArrayList<>();
        List<WebElement> products = getElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative puis-include-content-margin puis s-latency-cf-section s-card-border']"));
        String productNameXpath = ".//span[(@class='a-size-medium a-color-base a-text-normal')]";
        String priceXpath = ".//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span[1]/span[1]";
        String linkXpath = ".//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
        for (int i=0;i< products.size();i++) {
            title = "amazon.com";
            try {
                productName = products.get(i).findElement(By.xpath(productNameXpath)).getText();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                productName = "null";

            }
            if(!productName.contains(key)){
                break;
            }
            try {
                price = Float.parseFloat(products.get(i).findElement(By.xpath(priceXpath)).getAttribute("innerHTML").replace("$","").replace(",",""));
            } catch (org.openqa.selenium.NoSuchElementException  e) {
                price = 0;

            }
            try {

                link = products.get(i).findElement(By.xpath(linkXpath)).getAttribute("href");

            } catch (org.openqa.selenium.NoSuchElementException e) {
                link = "null";
            }

            Product newProduct = new Product(title, productName, price, link);
            listProducts.add(newProduct);

        }
        return listProducts;


    }


}
