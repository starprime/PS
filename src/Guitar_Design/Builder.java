package Guitar_Design;

/**
 * Created by star on 10/25/18.
 */
public enum Builder {
    FENDER,MARTIN,GIBSON,COLLINGS,OLSON,RYAN,PRS,ANY;

    public String toString(){
        switch (this){
            case ANY: return "any";
            case COLLINGS: return "collings";
            case FENDER: return "fender";
            case GIBSON: return "gibson";
            case MARTIN: return "martin";
            case OLSON: return "olson";
            case PRS: return "prs";
            case RYAN: return "ryan";
            default: return "";
        }

    }
}
