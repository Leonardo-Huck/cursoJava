package entities;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
       public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(", $");
        sb.append(String.format("%.2f", getPrice()));

        return sb.toString();
    }
}
