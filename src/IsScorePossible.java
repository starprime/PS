import java.util.HashMap;
import java.util.Map;

public  class IsScorePossible {
    static boolean  isScorePossible(int[] points, int finalScore)
    {
        Map<Integer,Integer> myMap = new HashMap<Integer, Integer>();

        for(int i=0;i<points.length;i++) {
            myMap.put(points[i],points[i]);
        }

        for(int i=0;i<points.length; i++) {

            if(points[i]<=finalScore) {
                int hold = Math.abs(points[i] - finalScore);
                if(myMap.containsKey(hold)){
                    return true;
                }
                else {
                    while ((points[i] + points[i])<finalScore){
                        hold = (points[i] + points[i]);
                        if(myMap.containsKey(hold) || hold==finalScore){
                            return true;
                        }
                    }
                }
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String []args){
        int x[]={7,3};
        System.out.println(isScorePossible(x,9));
    }
}
