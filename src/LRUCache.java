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
            dl.removeNode(key);
            int ret = mp.get(key);
            mp.remove(key);
            return ret;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.replace(key,value);
            dl.bringToFront(value);
            return;
        }
        else if(curr<cap){
            dl.push(key);
            curr++;
        }else if(curr>=cap){
            int k = dl.removeEndVal();
            if (k>0){
                mp.remove(k);
            }
            dl.push(value);
            curr++;
        }
        mp.put(key,value);
    }

    public static void main(String [] args){
        LRUCache lr = new LRUCache(2);
        lr.put(1,1);
        lr.put(2,2);

        System.out.println(lr.get(1));
        lr.put(3,3);

        System.out.println(lr.get(2));
        lr.put(4,4);

        System.out.println(lr.get(1));
        System.out.println(lr.get(3));
        System.out.println(lr.get(4));

    }
}