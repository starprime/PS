import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class BFSGraph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    BFSGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);
    }
    public void BFS(TreeNode root, List<Double> ret, int hie){
        int lvlsum=0,count=0;
        //ret.add(root.key,hie);
        if(root==null){return;}
        BFS(root.left,ret,hie-1);
        BFS(root.right,ret,hie-1);
    }
    public int hieght(TreeNode nd){
        int ret=0,h1=0,h2=0;
        if(nd==null)return 0;
        h1=hieght(nd.left);
        h2=hieght(nd.right);
        ret=max(h1,h2);
        ret++;
        return ret;
    }
    public int max(int v,int u){
        if(v>=u){return v;}
        else{return u;}
    }
}