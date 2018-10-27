package Guitar_Design.Enums;

/**
 * Created by star on 10/25/18.
 */
public enum Wood {
    INDIAN_ROSEWOOD, BRAZAILLIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ALDER, SITKA, ADIRONDACK;

    public String toString(){
        switch (this){
            case ADIRONDACK: return "adirondack";
            case ALDER: return "alder";
            case BRAZAILLIAN_ROSEWOOD: return "brazaillian_rosewood";
            case CEDAR: return "cedar";
            case COCOBOLO: return "cocobolo";
            case INDIAN_ROSEWOOD: return "indian_rosewood";
            case MAHOGANY: return "mahogany";
            case MAPLE: return "maple";
            case SITKA: return "sitka";
            default: return "";
        }
    }
}
