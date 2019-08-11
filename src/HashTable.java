import java.util.ArrayList;

/**
 * Created by star on 6/11/18.
 */

class HashNode<K,V>{
    K key;
    V value;

    HashNode<K,V> next;
    public HashNode(K key,V value){
        this.key = key;
        this.value = value;
        this.next=null;
    }
}

public class HashTable<K,V> {
    ArrayList<HashNode<K,V>> bucketArr;

    int siz;
    int numOfBucket;

    public HashTable(){
        bucketArr = new ArrayList<>();
        numOfBucket = 10;
        siz = 0;
        for(int i=0;i<numOfBucket;i++){
            bucketArr.add(null);
        }
    }

    public int getBucketIndex(K key){
        int hascode = key.hashCode();
        return hascode%numOfBucket;
    }

    public void put(K key,V value){
        int hash = getBucketIndex(key); // get hash
        HashNode<K,V> head = bucketArr.get(hash);  // get head for hash
        while (head!=null){ // this case if key is already present in the hashtable , replace and return
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        // other wise insert new
        // get head for key
        siz++; // increase size offcourse
        head = bucketArr.get(hash); // // get head for hash
        HashNode<K,V> newNode = new HashNode<K, V>(key,value); // make a node
        newNode.next=head; //i think its redudenant , putting on top of the list recent key,value
        bucketArr.set(hash,newNode); // setting for hash
        // if size has increased over a limit 70%
        // then increase the size

        if((1.0*siz)/numOfBucket >= 0.7){
            ArrayList<HashNode<K,V>> temp = bucketArr;
            numOfBucket = 2 * numOfBucket;
            siz = 0;
            for(int i=0;i<numOfBucket;i++){
                bucketArr.add(null);
            }
            for(HashNode<K,V> headNode:temp){
                while (headNode!=null){
                    put(headNode.key,headNode.value);
                }
            }
        }
    }

    public V get(K key){
        int hash = getBucketIndex(key);
        HashNode<K,V> head = bucketArr.get(hash);
        while (head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int hash = getBucketIndex(key);
        HashNode<K,V> head = bucketArr.get(hash);
        HashNode<K,V> prev = null;
        while (head!=null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head!=null){
            return null;
        }
        if(prev!=null){
            prev.next=head.next;
        }
        else {
            bucketArr.set(hash,head.next);
        }
        return head.value;
    }

        public static void main(String []args){
            HashTable mp = new HashTable();
            mp.put(1,10);
            System.out.println(mp.get(1));
            mp.put(1,100);
            System.out.println(mp.get(1));
            System.out.println(mp.get(12));

        }
}
