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
                                             int numDeliveries)
    {
        if(numDeliveries == 0 || numDestinations == 0) return new LinkedList<>();

        TreeMap<Double,List<List<Integer>>> nearestLocation = new TreeMap<>();

        // WRITE YOUR CODE HERE
        for(int i = 0; i < numDestinations;i++){
            // calculate distance from 0,0
            Double dis = EucLideanDistance(allLocations.get(i));

            List<List<Integer>> tempLi;
            //
            if(nearestLocation.containsKey(dis)){
                tempLi = nearestLocation.get(dis);
                tempLi.add(allLocations.get(i));
                //treeMap.put(dis,tempLi);//
            }else {
                tempLi = new ArrayList<>();
                tempLi.add(allLocations.get(i));
                nearestLocation.put(dis,tempLi);
            }
        }

        int k =0;

        List<List<Integer>> nearestCoordinate = new LinkedList<>();
        for(Map.Entry<Double, List<List<Integer>>> entry:nearestLocation.entrySet() ){
            List<List<Integer>> tmpLit = entry.getValue();
            if(k == numDeliveries)break;
            for(int i = 0;i<tmpLit.size();i++){
                nearestCoordinate.add(tmpLit.get(i));
                if(++k == numDeliveries)break;
            }
        }
        return nearestCoordinate;
    }

    // METHOD SIGNATURE ENDS
    public Double EucLideanDistance(List<Integer> loc){
        // assuming coordinates of consumer as 0,0
        int x = loc.get(0);
        int y = loc.get(1);
        // calculate Euclidean Distance
        return Math.abs(Math.sqrt((x*x)+(y*y)));

    }
    // METHOD SIGNATURE ENDS
}
