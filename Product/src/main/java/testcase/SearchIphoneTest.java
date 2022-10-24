package testcase;

import core.BaseSetup;
import model.Product;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.HomePageAmazon;
import page.HomePageEbay;
import page.SearchPageAmazon;
import page.SearchPageEbay;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchIphoneTest extends BaseSetup {

    @Test
    public void searchData() {
        SearchPageAmazon searchPageAmazon = new SearchPageAmazon(driver);
        SearchPageEbay searchPageEbay = new SearchPageEbay(driver);
        HomePageAmazon homePageAmazon = new HomePageAmazon(driver);
        HomePageEbay homePageEbay= new HomePageEbay(driver);
        homePageAmazon.getPage();
        homePageAmazon.searchPage();
        List<Product> listProductAmazon = searchPageAmazon.extractData();
        homePageEbay.getPage();
        homePageEbay.searchPage();
        List<Product> listProductEbay = searchPageEbay.extractData();
        listProductEbay.addAll(listProductAmazon);
        List<Product> sortedProduct = listProductEbay.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedProduct.size(); i++) {
            System.out.println(sortedProduct.get(i));
            if (sortedProduct.get(i).getProductName().contains("iPhone 11")) {
                System.out.println("Mention Product");
            } else {
                System.out.println("Does not mention product");
            }
        }


    }


}
