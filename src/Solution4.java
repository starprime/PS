/**
 * Created by star on 10/21/18.
 */
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution4
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries){
        if(numDeliveries == 0 || numDestinations == 0) return new ArrayList<>();

        TreeMap<Double,List<List<Integer>>> sortedLocation = new TreeMap<>();

        for(int i = 0; i < numDestinations;i++){
            Double distanceFromSource = getDistance(allLocations.get(i));

            List<List<Integer>> farziList;

            if(sortedLocation.containsKey(distanceFromSource)){
                farziList = sortedLocation.get(distanceFromSource);
                farziList.add(allLocations.get(i));
            }else {
                farziList = new ArrayList<>();
                farziList.add(allLocations.get(i));
                sortedLocation.put(distanceFromSource,farziList);
            }
        }

        int k =0;

        List<List<Integer>> returnedNearestList = new LinkedList<>();

        for(Map.Entry<Double, List<List<Integer>>> entry:sortedLocation.entrySet() ){
            List<List<Integer>> dummyList = entry.getValue();
            if(k == numDeliveries)break;

            //for(int i = 0;i<dummyList.size();i++){
            for(List<Integer> i:dummyList){
                returnedNearestList.add(i);
                if(++k == numDeliveries)break;
            }
        }

        return returnedNearestList;
    }

    // METHOD SIGNATURE ENDS

    private Double getDistance(List<Integer> loc){
        int x = loc.get(0);
        int y = loc.get(1);
        return Math.abs(Math.sqrt((x*x)+(y*y)));
    }
}
