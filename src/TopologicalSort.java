import java.util.Iterator;
import java.util.LinkedList;

public class TopologicalSort {
    int n;
    public static int si=0;
    static int stack[];
    LinkedList<Integer> edge[];
    boolean visited[];
    LinkedList<Integer> set=new LinkedList<>();

    public TopologicalSort(int n){
        this.n=n;
        visited=new boolean[n];

        stack=new int[n];
        edge=new LinkedList[n];
        for(int i=0;i<n;i++){
            edge[i]=new LinkedList();
            visited[i]=false;
        }
    }

    public void add(int n,int e){
        edge[n].add(e);
    }

    public void topSort(int s){
        visited[s]=true;

        Iterator<Integer> it=edge[s].listIterator();
        while (it.hasNext()){
            int e=it.next();
            if(!visited[e]){
                topSort(e);
            }
        }
        addStack(s);
    }

    public static void addStack(int x){
        stack[++si]=x;
    }

    public void topSort(){
        boolean v;
    }

    public static void main(String [] args){
        TopologicalSort ts=new TopologicalSort(8);
        ts.add(0,2);
        ts.add(1,2);
        ts.add(1,3);
        ts.add(2,4);
        ts.add(4,7);
        ts.add(4,5);
        ts.add(3,5);
        ts.add(5,6);

        ts.topSort(1);

        for(int i=0;i<8;i++){
            System.out.println(stack[i]);
        }
    }

}
