package Guitar_Design.Enums;

/**
 * Created by star on 10/27/18.
 */
public enum InstrumentType {
    BANJO, GUITAR, DOBRO, MANDOLIN, FIDDLE, BASS;


    public String toString() {
        switch (this){
            case BANJO: return "banjo";
            case BASS: return "bass";
            case DOBRO: return "dobro";
            case FIDDLE: return "fiddle";
            case GUITAR: return "guitar";
            case MANDOLIN: return "mandolin";
            default: return "Unspecified";
        }
    }
}
