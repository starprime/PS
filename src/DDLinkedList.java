
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

    public void push(int data){
        DDLinkedListNode nw = new DDLinkedListNode(data);
        nw.next=head;
        nw.prev=null;
        if(head!=null){head.prev=nw;
        head.next=null;}
        head=nw;
        return;
    }

    public void walkTh() {
        DDLinkedListNode tmp = head;
        while (tmp != null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
        return;
    }

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

    public static void main(String [] args){
        DDLinkedList dl = new DDLinkedList();
        dl.push(23);
        dl.push(32);
        dl.append(4);
        DDLinkedListNode bw = dl.getNodeByVal(32);
        dl.insertAfter(bw,11);
        dl.walkTh();
    }

}
