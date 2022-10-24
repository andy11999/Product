package page;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPageEbay {

    String title = "";
    String productName = "";
    float price;
    String link = "";
    public WebDriver driver;

    public SearchPageEbay(WebDriver driver) {
        this.driver = driver;
    }

    public List<Product> extractData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Product> listProducts = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='s-item__wrapper clearfix']"));
        String productNameXpath = ".//div[@class='s-item__title']";
        String priceXpath = ".//span[@class='s-item__price']";
        String linkXpath = ".//a[@class='s-item__link']";
        for (int i = 1; i < products.size(); i++) {
            title="ebay.com";
            try {
                productName = products.get(i).findElement(By.xpath(productNameXpath)).getText();
            } catch (NoSuchElementException e) {
                productName = "null";
            }
            try {
                String priceInString = products.get(i).findElement(By.xpath(priceXpath)).getAttribute("innerHTML");

                if (priceInString.contains("<span class=\"DEFAULT\"> to </span>")) {
                    if (priceInString.contains(" VND")) {
                        String y = priceInString.replace("<span class=\"DEFAULT\"> to </span>", " ").replace(" VND", "").replace(",", "");
                        String[] z = y.split(" ");
                        Float w1 = Float.parseFloat(z[1]) / 23000;
                        price = w1;
                    } else {
                        String y = priceInString.replace("<span class=\"DEFAULT\"> to </span>", " ").replace("$", "").replace(",", "");
                        String[] z = y.split(" ");
                        Float w1 = Float.parseFloat(z[1]);
                        price = w1;
                    }

                } else {
                    if (priceInString.contains(" VND")) {
                        price = Float.parseFloat(priceInString.replace(" VND", "").replace(",", ""));
                    } else {
                        price = Float.parseFloat(priceInString.replace("$", "").replace(",", ""));
                    }
                }

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

