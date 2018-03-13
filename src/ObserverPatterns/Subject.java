/**
 * Created by star on 3/12/18.
 */
package ObserverPatterns;


public interface Subject {
    void registerObserver(Observer o);
    void unRegisterObserver(Observer o);
    void notifyObservers();
}
