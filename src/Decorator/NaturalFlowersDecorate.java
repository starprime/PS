package Decorator;

/**
 * Created by star on 3/13/18.
 */
public final class NaturalFlowersDecorate implements Decorator{

    Decorator decor;

    @Override
    public void draw(){
        if(decor != null){
            decor.draw();
        }
        System.out.println("Decorating with Natural flowers");
    }

    NaturalFlowersDecorate(){

    }

    NaturalFlowersDecorate(Decorator decor){
        this.decor = decor;
    }
}