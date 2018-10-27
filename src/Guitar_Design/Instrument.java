package Guitar_Design;

import Guitar_Design.Specs.InstrumentSpec;

/**
 * Created by star on 10/25/18.
 */

public abstract class Instrument {

    protected String serialNumber;
    protected double price;
    protected InstrumentSpec instrumentSpec;

    public Instrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrumentSpec = instrumentSpec;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    InstrumentSpec getSpec(){
        return this.instrumentSpec;
    }

}
