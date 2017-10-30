import java.util.ArrayList;
import java.util.List;

public class NQueensProb {
    List<Position> p;
    int nofq;
    class Position{
        int x,y;
    }
    public NQueensProb(int n){
        this.nofq=n;
        p=new ArrayList<Position>();
    }
    public static void main(String []args){
        int queen=4;
        int [][]maze=new int[queen][queen];
        for(int i=0;i<queen;i++){ for(int j=0;j<queen;j++){maze[i][j]=0; }}
        NQueensProb nqp=new NQueensProb(queen);
        System.out.print(nqp.placeQueen(maze,0));
        for(int i=0;i<nqp.p.size();i++){
            System.out.print(nqp.p.get(i).x);
            System.out.println(nqp.p.get(i).y);
        }
    }
    public boolean checkKill(int [][]maze,int i,int j){
        int k=0;boolean dec=false;int x,y;
        if(p.size()==0)return true;
        while(k<p.size()){
            x=p.get(k).x;
            y=p.get(k).y;
            if(i==x)dec=false;
            else if(j==y) dec=false;
            else if((x+y)==(i+j)||(x-y)==(i-j)){dec=false;}
            else {dec=true;}
            k++;
            if(!dec){
                return false;
            }
        }
        return dec;
    }
    public boolean placeQueen(int [][]maze,int i){
        if(i>nofq){return false;}
        Position pl;boolean ret=false;
        int k=0;
        while (k<nofq){
            if(checkKill(maze,i,k)) {
                pl=new Position();
                pl.x=i;pl.y=k;
                p.add(i,pl);
                if(placeQueen(maze,i+1)){
                    ret=true;
                }else{
                    p.remove(i);
                    ret=false;
                }
            }k++;
        }return ret;
    }
}
