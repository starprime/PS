package Guitar_Design;

/**
 * Created by star on 10/25/18.
 */
public enum Type {
    ACOUSTIC, ELECTRIC;
    public String toString(){
        switch (this){
            case ACOUSTIC: return "acoustic";
            case ELECTRIC: return "electric";
            default: return "";
        }
    }
}
