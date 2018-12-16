import org.junit.runners.JUnit4;

import java.util.HashMap;

class LRUCache {

    int cap;
    int curr;
    DDLinkedList dl;
    HashMap<Integer,Integer> mp;


    public LRUCache(int capacity) {
        this.cap=capacity; // check the cap
        curr=0;
        dl = new DDLinkedList();
        mp = new HashMap<>();
    }

    public int get(int key) {
        if(mp.containsKey(key)){
            dl.bringToFront(key);
            int ret = mp.get(key);
            return ret;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println(key+" , "+curr);
        if(mp.containsKey(key)){
            mp.replace(key,value);
            dl.bringToFront(key);
            return;
        }
        else if(curr<cap){
            dl.push(key);
            curr++;
        }else {
            int k = dl.removeEndVal();
            if (k>-1){
                mp.remove(k);
            }
            dl.push(key);
        }
        mp.put(key,value);
    }

    public static void main(String []args){
        LRUCache lr = new LRUCache(3);
        lr.put(1,1);
        lr.put(2,2);
        lr.put(3,3);
        lr.put(4,4);
        lr.get(4);
        lr.get(3);
        lr.get(2);
        lr.get(1);

        lr.put(5,5);
        lr.get(1);
        lr.get(2);
        lr.get(3);
        lr.get(4);
        lr.get(5);

    }

}