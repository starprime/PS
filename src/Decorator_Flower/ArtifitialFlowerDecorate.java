package Decorator_Flower;

/**
 * Created by star on 3/13/18.
 */
public class ArtifitialFlowerDecorate implements Decorator{
    Decorator decor;

    ArtifitialFlowerDecorate(){

    }

    @Override
    public void draw(){
        if(decor != null){
            decor.draw();
        }
        System.out.println("Decorating with Artifitial flowers");
    }

    ArtifitialFlowerDecorate(Decorator decor){
        this.decor = decor;
    }
}