// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution5
{
    class Coordinates implements Comparable<Coordinates> {
        List<Integer> coord;
        int distance;
        public Coordinates(List<Integer> coord,int distance){
            this.coord = coord;
            this.distance = distance;
        }

        @Override
        public int compareTo(Coordinates b) {
            int d =  b.distance - this.distance;
            if(d == 0)
            {
                d = b.coord.get(0) - this.coord.get(0); // compare  X
                if(d == 0)
                {
                    d = b.coord.get(1) - this.coord.get(1); // compare Y
                }
            }
            return d;
        }
    }

    // it will compute it in numDestinations log numDeliveries

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        List<List<Integer>> ret = new LinkedList<>();
        if(numDeliveries == 0 || numDestinations == 0)return ret;
        /// using PriorityQueue to find nearest numDeliveries Destinations
        // it will compute it in numDestinations log numDeliveries
        Queue<Coordinates> maxHeap = new PriorityQueue<Coordinates>(numDeliveries);
        // WRITE YOUR CODE HERE
        int k = numDeliveries;
        int  dist;

        for(int i = 0; i < numDestinations;i++){
            dist = EucLideanDistance(allLocations.get(i));
            // matin size is is less than K
            if(maxHeap.size()<k)
            {
                maxHeap.add(new Coordinates(allLocations.get(i), dist));
            }
            else
            {
                if(maxHeap.peek().distance > dist)
                {
                    maxHeap.poll();
                    maxHeap.add(new Coordinates(allLocations.get(i), dist));
                }
            }
        }

        for(int i=0;i<k;i++)
        {
            ret.add(maxHeap.poll().coord);
        }
        return ret;

    }

    // METHOD SIGNATURE ENDS
    public int EucLideanDistance(List<Integer> loc){
        // assuming coordinates of consumer as 0,0
        int x = loc.get(0);
        int y = loc.get(1);
        // calculate Euclidean Distance
        //return Math.abs(Math.sqrt((x*x)+(y*y)));
        return (x*x) + (y*y);

    }
    // METHOD SIGNATURE ENDS
}