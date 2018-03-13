package ObserverPatterns;

/**
 * Created by star on 3/12/18.
 */
public class ObserverPattern {
    public static void main(String args[]){
        MyBlog learnJava = new MyBlog();

        Subscribers s1 = new Subscribers("bcd@bcd.com");
        Subscribers s2 = new Subscribers("def@def.com");
        Subscribers s3 = new Subscribers("ghi@ghi.com");

        learnJava.registerObserver(s1);
        learnJava.registerObserver(s2);
        learnJava.registerObserver(s3);

        learnJava.addPost();

        learnJava.unRegisterObserver(s2);

        learnJava.addPost();
    }
}