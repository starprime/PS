package Decorator_Flower;

/**
 * Created by star on 3/13/18.
 */
public class LightsDecorate implements Decorator{
    Decorator decor;

    LightsDecorate(){

    }

    @Override
    public void draw(){
        if(decor != null){
            decor.draw();
        }
        System.out.println("Decorating with lights");
    }

    LightsDecorate(Decorator decor){
        this.decor = decor;
    }
}