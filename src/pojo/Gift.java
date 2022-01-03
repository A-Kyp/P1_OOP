package pojo;

import enums.Category;

public class Gift {
    private String productName;
    private Double price;
    private Category category;

    public Gift(String productName, Double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
}
