package Guitar_Design;

/**
 * Created by star on 10/25/18.
 */
public abstract class Instrument {
    protected String serialNumber;
    protected double price;

    abstract String getSerialNumber();

    abstract void setSerialNumber(String serialNumber);

    abstract double getPrice();

    abstract void setPrice(double price);
}
