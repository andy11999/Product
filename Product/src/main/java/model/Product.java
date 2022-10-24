package model;

public class Product {
    private String title = "";
    private String productName = "";
    private float price;
    private String link = "";

    public Product(String title, String productName, float price, String link) {
        this.title = title;
        this.productName = productName;
        this.price = price;
        this.link = link;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Name of Page: " + this.title + " Name of product: " + this.productName + " Price: " + this.price + " Link: " + this.link;
    }


}
