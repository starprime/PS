import java.util.HashMap;

class LRUCache {

    int cap;
    int curr;
    DDLinkedList dl;
    HashMap<Integer,Integer> mp;

    class DDLinkedList {
        DDLinkedListNode head;

        class DDLinkedListNode {
            int val;
            DDLinkedListNode next;
            DDLinkedListNode prev;

            public DDLinkedListNode(int val) {
                this.val = val;
            }
        }
        public void push(int data){
            DDLinkedListNode nw = new DDLinkedListNode(data);
            nw.next=head;
            nw.prev=null;
            if(head!=null){head.prev=nw;
                head.next=null;}
            head=nw;
            return;
        }
        public int removeEnd(){
            if(head==null)return -1;
            DDLinkedListNode lst = head;
            while(lst.next!=null){
                lst=lst.next;
            }
            int ret = lst.val;
            if(lst==head)return ret;
            DDLinkedListNode prv =lst.prev;
            prv.next=null;
            lst.prev=null;
            return ret;
        }
        public void bringToFront(int val){
            if(head.val==val)return;
            DDLinkedListNode tmp=head;
            while (tmp!=null){
                if(tmp.val==val)break;
                tmp=tmp.next;
            }
            if(tmp!=null){
                DDLinkedListNode prv = tmp.prev;
                DDLinkedListNode nxt = tmp.next;

                if(nxt==null) prv.next=null;
                else{
                    prv.next=nxt;
                    nxt.prev=prv;
                }
            }
            push(val);
        }

        public void removeNode(int val){
            if(head.val==val){
                head=null;
                return;
            }

            DDLinkedListNode dd = head;

            while(dd!=null){
                if(dd.val==val)break;
                dd=dd.next;
            }

            if(dd!=null){
                DDLinkedListNode prv = dd.prev;
                DDLinkedListNode nxt = dd.next;
                prv.next=nxt;
                if(nxt!=null)nxt.prev=prv;
            }

            return;
        }

        public DDLinkedListNode DDLinkedList(){return head;}
    }
    public LRUCache(int capacity) {
        this.cap=capacity;
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
        if(curr<cap){
            dl.push(key);
            curr++;
        }else if(curr==cap){
            int k = dl.removeEnd();
            if(k>0)mp.remove(k);
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