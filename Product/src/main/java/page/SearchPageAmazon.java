package page;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPageAmazon {

    String title = "";
    String productName = "";
    float price;
    String link = "";
    public WebDriver driver;

    public SearchPageAmazon(WebDriver driver) {
        this.driver = driver;
    }

    public List<Product> extractData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> listProducts = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative puis-include-content-margin puis s-latency-cf-section s-card-border']"));
        String productNameXpath = ".//span[(@class='a-size-medium a-color-base a-text-normal')]";
        String priceXpath = ".//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span[1]/span[1]";
        String linkXpath = ".//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
        for (int i = 0; i < products.size(); i++) {
//            title = "amazon.com";
//            List<WebElement> productNames= driver.findElements(By.xpath(productNameXpath));
//            if(productNames.size()>0){
//                productName=driver.findElement(By.xpath(productNameXpath)).getText();
//            }else{
//                productName="null";
//            }
//            List<WebElement> priceProducts= driver.findElements(By.xpath(priceXpath));
//            if(priceProducts.size()>0){
//                String priceInString=driver.findElement(By.xpath(priceXpath)).getAttribute("innerHTML").replace("$","");
//                price=Float.parseFloat(priceInString);
//
//            }else{
//                price=0;
//            }
//            List<WebElement> linkProducts=driver.findElements(By.xpath(linkXpath));
//            if(linkProducts.size()>0){
//                link=driver.findElement(By.xpath(linkXpath)).getAttribute("href");
//            }else{
//                link="null";
//            }

            try {
                productName = products.get(i).findElement(By.xpath(productNameXpath)).getText();
            } catch (NoSuchElementException e) {
                productName = "null";
            }
            try {
                price = Float.parseFloat(products.get(i).findElement(By.xpath(priceXpath)).getAttribute("innerHTML").replace("$",""));
            } catch (NoSuchElementException e) {
                price = 0;
            }
            try {
                link = products.get(i).findElement(By.xpath(linkXpath)).getAttribute("href");
            } catch (NoSuchElementException e) {
                link = "null";
            }
            Product product = new Product(title, productName, price, link);
            listProducts.add(product);

        }
        return listProducts;


    }


}
