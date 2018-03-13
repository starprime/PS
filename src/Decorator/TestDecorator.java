package Decorator;

/**
 * Created by star on 3/13/18.
 */

public class TestDecorator{
    public static void main(String args[]){
        LightsDecorate lightDec;
        lightDec = new LightsDecorate(new NaturalFlowersDecorate(new ArtifitialFlowerDecorate()));
        lightDec.draw();
    }
}