import java.util.*;
public class Main{//<Integer> will force to get int type only
    public static void main(String [] args){
        LinkedList queue = new LinkedList();
        queue.add(12);
        queue.add(1312);
        queue.add(1231);
        queue.add(5233);
        queue.add(423);
        ListIterator i=queue.listIterator();
        while(i.hasNext()){
            System.out.println("-"+i.next());
        }
    }
}