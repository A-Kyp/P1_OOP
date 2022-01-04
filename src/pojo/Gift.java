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

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Gift{" + "\n" +
                "\tproductName='" + productName + '\'' +  ", " + "\n" +
                "\tprice=" + price + ", " + "\n" +
                "\tcategory=" + category + ", " + "\n" +
                '}';
    }
}
