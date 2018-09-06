import java.util.Arrays;

/**
 * Created by star on 9/1/18.
 */
public class String_Operations {
    public static void main(String []args){
        String a = "shello";
        String b = "hello";
        String c = new String("hello");
        String d = c;
        String e = new String("hello");

        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(c==d);
        System.out.println(c.equals(d));
        System.out.println(c==e);
        System.out.println(a==d);
        System.out.println(a.compareTo(c));

        char [] arr = {'x','b','d','e','a'};
        Arrays.sort(arr);
        PrintArray.printArray(arr);
    }
}
