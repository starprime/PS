package Guitar_Design;

import Guitar_Design.Enums.*;
import Guitar_Design.Specs.InstrumentSpec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by star on 10/25/18.
 */
public class GuitarTester {
    public static void main(String []args){
        Map<String,String> guitarProperties = new HashMap<>();
        guitarProperties.put("Instrument", String.valueOf(InstrumentType.GUITAR));
        guitarProperties.put("wood", String.valueOf(Wood.ADIRONDACK));
        guitarProperties.put("builder", String.valueOf(Builder.COLLINGS));
        guitarProperties.put("type", String.valueOf(Type.ACOUSTIC));

        InstrumentSpec guitarSpec =  new InstrumentSpec(guitarProperties);
        // why i need instrument spec why cant i have map in instrument
        // why making object of instrument using inventory constuctor, why cant just make it here from client and send

        Map<String,String> banjoProperties = new HashMap<>();
        banjoProperties.put("Instrument", String.valueOf(InstrumentType.BANJO));
        banjoProperties.put("wood", String.valueOf(Wood.ADIRONDACK));
        banjoProperties.put("builder", String.valueOf(Builder.COLLINGS));

        InstrumentSpec banjoSpec =  new InstrumentSpec(banjoProperties);


        Map<String,String> mandolinProperties = new HashMap<>();
        mandolinProperties.put("Instrument", String.valueOf(InstrumentType.MANDOLIN));
        mandolinProperties.put("wood", String.valueOf(Wood.ADIRONDACK));
        mandolinProperties.put("builder", String.valueOf(Builder.GIBSON));

        InstrumentSpec mandolinSpec =  new InstrumentSpec(mandolinProperties);

        Inventory inventory = new Inventory();
        inventory.addInstruments(guitarSpec,"123",238);
        inventory.addInstruments(banjoSpec,"323",9834);
        inventory.addInstruments(mandolinSpec,"89743",23142);

        Map<String,String> testProp = new HashMap<>();
        testProp.put("builder", String.valueOf(Builder.COLLINGS));

        InstrumentSpec testSpec = new InstrumentSpec(testProp);
        List<Instrument> results = inventory.search(testSpec);

        System.out.println(results);
        int k = 1;
        if(!results.isEmpty()){
            for(Iterator iterator = results.iterator();iterator.hasNext();){
                Instrument instrument = (Instrument) iterator.next();
                InstrumentSpec spec = instrument.getSpec();
                System.out.println("Product :"+ k++);
                for (Iterator it = spec.getProperties().keySet().iterator();it.hasNext();) {
                    String propertyName = (String) it.next();

                    System.out.println(propertyName+" - "+instrument.instrumentSpec.getProperties().get(propertyName));
                }

            }
        }

    }
}
