import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class EvenList<T> implements Iterable<T> {
    private List<T> li;

    EvenList(List<T> li){
        this.li = li;
    }

    @Override
    public Iterator<T> iterator() {
        return new EvenIterator<T>();
    }
    private class EvenIterator<T> implements Iterator<T>{
        int size = li.size();
        int currentPointer = 0;

        @Override
        public boolean hasNext() {
            return currentPointer<size;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T val = (T)li.get(currentPointer);
            currentPointer+=1;

            return val;
        }
    }
}
