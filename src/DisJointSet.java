import java.util.HashMap;
import java.util.Map;

/**
 * Created by skuma115 on 8/13/2017.
 */
public class DisJointSet {
    private Map<Long,Node> map= new HashMap<>();
    class Node{
        long data;
        Node parent;
        int rank;
    }

    public void makeSet(long data){
        Node nd=new Node();
        nd.data=data;
        nd.parent=nd;
        nd.rank=0;
        map.put( data,nd);
    }

    public boolean union(long data1,long data2){
        Node nd1=map.get(data1);
        Node nd2=map.get(data2);

        Node paren1=findSet(nd1);
        Node paren2=findSet(nd2);

        if(paren1.data==paren2.data)return false;

        if(paren1.rank>=paren2.rank){
            paren1.rank=(paren1.rank==paren2.rank)?paren1.rank+1:paren1.rank;
            paren2.parent=paren1;
        }else{
            paren1.parent=paren2;
        }
        return true;
    }

    public long findSet(long data){
        return findSet(map.get(data)).data;
    }
    public Node findSet(Node nd){
         Node ndp=nd.parent;
        if(ndp==nd) return ndp;
        return findSet(ndp);
    }
    public static void main(String [] args){
        DisJointSet ds=new DisJointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
