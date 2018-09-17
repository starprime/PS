package LeetCodeDesign;

public class MyCircularQueue {
    int [] qu;
    int frnt;
    int re;
    int sze;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        qu = new int[k];
        frnt = 0;
        re = -1;
        sze = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(re - frnt >= qu.length-1)return false;
        if(sze<=qu.length){
            re+=1;
            if(re>=qu.length){
                re=0;
            }
            qu[re] = value;
            sze++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(sze == 0)return false;
        if(frnt==qu.length-1){
            frnt = 0;
        }else{
            frnt+=1;
        }
        sze--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return qu[frnt];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return qu[re];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return sze==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return sze == qu.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */