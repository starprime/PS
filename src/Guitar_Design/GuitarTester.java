package Guitar_Design;

import Guitar_Design.Enums.Builder;
import Guitar_Design.Enums.Style;
import Guitar_Design.Enums.Type;
import Guitar_Design.Enums.Wood;
import Guitar_Design.Specs.GuitarSpec;
import Guitar_Design.Specs.MandolinSpec;

/**
 * Created by star on 10/25/18.
 */
public class GuitarTester {
    public static void main(String []args){
        GuitarSpec guitarSpec = new GuitarSpec(3,"lol", Builder.GIBSON, Wood.BRAZAILLIAN_ROSEWOOD, Type.ACOUSTIC);

        Inventory  inventory = new Inventory();
        inventory.addInstruments(guitarSpec,"1231",400);

        MandolinSpec mandolinSpec = new MandolinSpec(Style.A,"faart",Builder.GIBSON,Wood.ADIRONDACK,Type.ACOUSTIC);
        inventory.addInstruments(mandolinSpec,"1234",123);

    }
}
