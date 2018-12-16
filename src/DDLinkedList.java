/**
 * Created by star on 6/10/18.
 */

public class DDLinkedList{
    DDLinkedListNode head;

    class DDLinkedListNode {
        int val;
        DDLinkedListNode next;
        DDLinkedListNode prev;
        public DDLinkedListNode(int val){
            this.val = val;
        }
    }

    // putting in the front ,
    public void push(int data){
        // create new node
        DDLinkedListNode nw = new DDLinkedListNode(data);
        // set next to head
        nw.next=head;
        nw.prev=null;

        if(head!=null){head.prev=nw;
        head.next=null;}
        head=nw;
        return;
    }
    // put in the last
    public void append(int data){
        DDLinkedListNode lst = head;
        while (lst.next != null){
            lst=lst.next;
        }
        DDLinkedListNode nw = new DDLinkedListNode(data);
        lst.next = nw;
        nw.next = null;
        nw.prev = lst;
        return;
    }

    public void walkTh() {
        DDLinkedListNode tmp = head;
        while (tmp != null){
            System.out.print(tmp.val+",");
            tmp=tmp.next;
        }
        System.out.println();
        return;
    }
    public DDLinkedListNode getNodeByVal(int val){
        DDLinkedListNode lst = head;
        while (lst.next != null){
            if(lst.val==val)return lst;
            lst=lst.next;
        }
        System.out.println("Node is Null");
        return null;
    }
    public void insertAfter(DDLinkedListNode nd,int val){
        DDLinkedListNode nxt = nd.next;
        DDLinkedListNode nw = new DDLinkedListNode(val);
        nd.next=nw;
        nw.prev=nd;
        if(nxt!=null){
            nw.next=nxt;
            nxt.prev=nw;
        }else {
            nw.next=null;
        }
        return;
    }
    public int removeEndVal(){
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

    public void removeEnd(){
        DDLinkedListNode lst = head;
        while(lst.next!=null){
            lst=lst.next;
        }
        System.out.println(lst.val);
        DDLinkedListNode prv =lst.prev;
        prv.next=null;
        lst.prev=null;
        return;
    }



    public void removeNode(int val){

        DDLinkedListNode dd = head;

        while(dd!=null){
            if(dd.val==val)break;
            dd=dd.next;
        }

        if(dd!=null){
            DDLinkedListNode prv = dd.prev;
            DDLinkedListNode nxt = dd.next;
            if(prv==null)head=nxt;
            else prv.next=nxt;
            if(nxt!=null)nxt.prev=prv;
        }

        return;
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


    public static void main(String [] args){
        DDLinkedList dl = new DDLinkedList();
        dl.push(23);
        dl.push(32);
        dl.walkTh();
        dl.append(4);
        DDLinkedListNode bw = dl.getNodeByVal(32);
        dl.insertAfter(bw,11);
        dl.walkTh();
        dl.removeEnd();
        dl.walkTh();
    }
}

