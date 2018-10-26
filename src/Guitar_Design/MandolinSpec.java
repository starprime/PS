package Guitar_Design;

/**
 * Created by star on 10/25/18.
 */
public class MandolinSpec extends InstrumentSpec{
    Style style;

    public MandolinSpec(Style style, String model, Builder builder, Wood wood, Type type) {
        super(model, builder, wood, type);
        this.style = style;
    }

    @Override
    public boolean matches(InstrumentSpec spec) {
        if(super.matches(spec) && spec instanceof MandolinSpec){
            return ((MandolinSpec) spec).style == this.style;
        }
        return false;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
