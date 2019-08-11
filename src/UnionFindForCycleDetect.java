
/**
 * Created by skuma115 on 8/13/2017.
 */
public class UnionFindForCycleDetect {
    int V,E;
    Edge edge[];

    class Edge implements Comparable<Edge>{
        int src,dest,wieght;

        @Override
        public int compareTo(Edge o) {
            return this.wieght-o.wieght;
        }
    };
    class subSet{
        int parent,rank;
    };

    public UnionFindForCycleDetect(int v,int e){
        this.V=v;
        this.E=e;
        edge=new Edge[e];
        for(int i=0;i<e;i++){
            edge[i]=new Edge();
        }
    }

    public void addEdge(int edg,int srcval,int dstval){
        this.edge[edg].dest=dstval;
        this.edge[edg].src=srcval;
    }

    public int find(int []parent,int i){
        if(parent[i]==-1){
            return i;
        }
        return find(parent,parent[i]);
    }

    public void union(int []parnt,int x,int y){
        int xset=find(parnt,x);
        int yset=find(parnt,y);
        parnt[xset]=yset;
    }

    public boolean isCycle(UnionFindForCycleDetect grph){
        int [] parnt=new int[this.V];
        for(int i=0;i<this.V;i++)parnt[i]=-1;

        for(int i=0;i<this.E;i++){
            int x=find(parnt,grph.edge[i].src);
            int y=find(parnt,grph.edge[i].dest);
            if(x==y){
                printArra(parnt);
                return true;
            }
            union(parnt,x,y);
        }
        printArra(parnt);
        return false;
    }

    public void printArra(int [] pArr){
        for(int i=0;i<pArr.length;i++){
            System.out.print(pArr[i]);
        }
    }

    public static void main(String []args){
        UnionFindForCycleDetect ufcd=new UnionFindForCycleDetect(3,3);

/*
        ufcd.addEdge(1,1,2);
        ufcd.addEdge(0,0,1);
        ufcd.addEdge(2,2,0);
*/
        // add edge 0-1
        ufcd.edge[0].src = 0;
        ufcd.edge[0].dest = 1;

        // add edge 1-2
        ufcd.edge[1].src = 1;
        ufcd.edge[1].dest = 2;

        // add edge 0-2
        ufcd.edge[2].src = 0;
        ufcd.edge[2].dest = 2;

        System.out.println(ufcd.isCycle(ufcd));
    }
}
