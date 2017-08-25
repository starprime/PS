import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by skuma115 on 6/16/2017.
 */
public class DFSGraph {
    int v;
    LinkedList<Integer> adj[];
    public DFSGraph(int v){
        this.v=v;
        adj= new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
    }
    public void DFSRec(int n,boolean [] vi){
        vi[n]=true;
        System.out.print(n);
        Iterator<Integer> it=adj[n].listIterator();
        while(it.hasNext()){
            int k=it.next();
            if(!vi[k]){
                DFSRec(k,vi);
            }
        }
    }
    public void DFS(int n){
        boolean vistd[]=new boolean[v];
        DFSRec(n,vistd);

    }
    public static void main(String [] args){
        DFSGraph g=new DFSGraph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}