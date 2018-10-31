//package Guitar_Design.Specs;
//
//import Guitar_Design.Enums.Builder;
//import Guitar_Design.Enums.Type;
//import Guitar_Design.Enums.Wood;
//
///**
// * Created by star on 10/25/18.
// */
//public class GuitarSpec extends InstrumentSpec {
//    private int numOfString;
//
//
//    public GuitarSpec(int numOfString, String model, Builder builder, Wood wood, Type type) {
//        super(model, builder, wood, type);
//        this.numOfString = numOfString;
//    }
//
//    @Override
//    public boolean matches(InstrumentSpec spec) {
//        if(super.matches(spec) && spec instanceof GuitarSpec){
//           return  ((GuitarSpec) spec).numOfString == this.numOfString;
//        }
//        return false;
//    }
//}
