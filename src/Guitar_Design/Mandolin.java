package Guitar_Design;


import Guitar_Design.Specs.InstrumentSpec;

public class Mandolin extends Instrument {

    public Mandolin(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        super(serialNumber, price, instrumentSpec);
    }

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


}
