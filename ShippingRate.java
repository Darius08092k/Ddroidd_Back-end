package Project;

public class ShippingRate {
    private int rate;
    private String shippingCountry;

    public ShippingRate(int rate, String shippingCountry) {
        this.rate = rate;
        this.shippingCountry = shippingCountry;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }
}
