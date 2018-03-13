import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by star on 3/12/18.
 */
public class Java_Learn {
    public static void main(String []args){
        List<Integer> lo=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        EvenList<Integer> myL = new EvenList<>(lo);
        Iterator<Integer> iter = myL.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
