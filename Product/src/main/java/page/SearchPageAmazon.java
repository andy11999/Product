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
//        String productNameXpath = "//span[(@class='a-size-medium a-color-base a-text-normal')]";
//        String priceXpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span[1]/span[1]";
//        String linkXpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
        for (int i=0;i< products.size();i++) {
            title = "amazon.com";
            String productNameXpath= "//div[@data-index="+(i+2)+"]//span[@class='a-size-medium a-color-base a-text-normal']";
            List<WebElement> productNameList= driver.findElements(By.xpath(productNameXpath));
            if(productNameList.size()>0){
                productName=driver.findElement(By.xpath(productNameXpath)).getText();
            }else{
                productName="null";
            }
            String priceXpath="//div[@data-index="+(i+2)+"]//span[@class='a-price']//span[@class='a-offscreen']";
            List<WebElement> priceList= driver.findElements(By.xpath(priceXpath));
            if(priceList.size()>0){
                price= Float.parseFloat(driver.findElement(By.xpath(priceXpath)).getAttribute("innerHTML").replace("$",""));
            }else{
                price=0;
            }
            String linkXpath= "//div[@data-index="+(i+2)+"]//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
            List<WebElement> linkList= driver.findElements(By.xpath(priceXpath));
            if(linkList.size()>0){
                link=driver.findElement(By.xpath(linkXpath)).getAttribute("href");
            }else{
                link="null";
            }
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
//
//            try {
//                productName = driver.findElement(By.xpath(productNameXpath)).getText();
//            } catch (NoSuchElementException e) {
//                productName = "null";
//            }
//            try {
//                price = Float.parseFloat(driver.findElement(By.xpath(priceXpath)).getAttribute("innerHTML").replace("$",""));
//            } catch (NoSuchElementException e) {
//                price = 0;
//            }
//            try {
//                link = driver.findElement(By.xpath(linkXpath)).getAttribute("href");
//            } catch (NoSuchElementException e) {
//                link = "null";
//            }

            Product newProduct = new Product(title, productName, price, link);
            listProducts.add(newProduct);

        }
        return listProducts;


    }


}
