package Guitar_Design.Specs;

import Guitar_Design.Enums.Builder;
import Guitar_Design.Enums.Type;
import Guitar_Design.Enums.Wood;

/**
 * Created by star on 10/25/18.
 */
public class InstrumentSpec {
    private String model;
    private Builder builder;
    private Wood wood;
    private Type type;

    public InstrumentSpec(String model, Builder builder, Wood wood, Type type) {
        this.model = model;
        this.builder = builder;
        this.wood = wood;
        this.type = type;
    }

    public boolean matches(InstrumentSpec spec){
        boolean compareProp = this.builder == spec.builder && this.wood == spec.wood && this.type == spec.type;
        return compareProp && this.model != null && !this.model.equals("") && spec.model==this.model;

    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public String getBuilder(){
        return builder.toString();
    }

    public void setBuilder(Builder builder){
        this.builder = builder;
    }

    public String getWood(){
        return wood.toString();
    }
    public void setWood(Wood wood){
        this.wood = wood;
    }

    public String getType(){
        return type.toString();
    }
    public void setType(Type type){
        this.type = type;
    }


}
