package ObserverPatterns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by star on 3/12/18.
 */
public class MyBlog implements Subject {
    Set<Observer> mySubs = new HashSet<>();

    @Override
    public void registerObserver(Observer o) {
        mySubs.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
        mySubs.remove(o);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> itr = mySubs.iterator();
        while (itr.hasNext()){
            Observer obs = itr.next();
            obs.update();
        }
    }

    void addPost(){
        notifyObservers();
    }
}
