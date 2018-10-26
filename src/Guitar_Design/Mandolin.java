package Guitar_Design;

/**
 * Created by star on 10/25/18.
 */
public class Mandolin extends Instrument {
    Style style;

    @Override
    String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    double getPrice() {
        return this.price;
    }

    @Override
    void setPrice(double price) {
        this.price = price;
    }

    public String getStyle(){
        return style.getString();
    }

    public void setStyle(Style style){
        this.style = style;
    }
}
