package Guitar_Design.Enums;

/**
 * Created by star on 10/25/18.
 */
public enum Style {
    A,F;
    public String getString(){
        switch (this){
            case A: return "a";
            case F: return "f";
            default: return "";
        }
    }
}
