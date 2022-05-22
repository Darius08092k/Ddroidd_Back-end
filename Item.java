package Project;

public class Item {
    private String name;
    private double price;
    private double weight;
    private String country;

    public Item(String name, double price, double weight, String country) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.country = country;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
