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

import static constant.Common.AMZ_URL;
import static constant.Common.EBAY_URL;

public class SearchIphoneTest extends BaseSetup {
    private String key="iPhone 11";

    @Test
    public void searchData() {
        SearchPageAmazon searchPageAmazon = new SearchPageAmazon(driver);
        SearchPageEbay searchPageEbay = new SearchPageEbay(driver);
        HomePageAmazon homePageAmazon = new HomePageAmazon(driver);
        HomePageEbay homePageEbay= new HomePageEbay(driver);
        homePageAmazon.gotoUrl(AMZ_URL);
        homePageAmazon.goToSearchPage(key);
        List<Product> listProductAmazon = searchPageAmazon.extractData(key);
        homePageEbay.gotoUrl(EBAY_URL);
        homePageEbay.goToSearchPage(key);
        List<Product> listProductEbay = searchPageEbay.extractData(key);
        listProductEbay.addAll(listProductAmazon);
        List<Product> sortedProduct = listProductEbay.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        for (Product product: sortedProduct) {
            System.out.println(product);

        }


    }


}
