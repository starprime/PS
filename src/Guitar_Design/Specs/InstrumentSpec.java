package Guitar_Design.Specs;

import Guitar_Design.Enums.Builder;
import Guitar_Design.Enums.InstrumentType;
import Guitar_Design.Enums.Type;
import Guitar_Design.Enums.Wood;
import Guitar_Design.Instrument;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by star on 10/25/18.
 */

public class InstrumentSpec {
    private Map<String,String> properties;

    public InstrumentSpec(Map properties) {
        if(properties == null){
            this.properties = new HashMap();
        }else {
            this.properties = new HashMap(properties);
        }
    }

    public Object getProperty(String property){
        return this.properties.get(property);
    }

    public Map getProperties(){
        return this.properties;
    }

    public boolean matches(InstrumentSpec otherspec){

        for (Iterator<String> it = otherspec.properties.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();

            if(!this.properties.get(key).equals(otherspec.properties.get(key))){
                return false;
            }

        }
        return true;
    }


}
