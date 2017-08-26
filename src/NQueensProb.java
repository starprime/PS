import java.util.ArrayList;
import java.util.List;

public class NQueensProb {
    List<Position> p;
    class Position{
        int x,y;
    }
    public NQueensProb(int n){
        p=new ArrayList<Position>();
    }
    public static void main(String []args){
        int queen=4;
        int [][]maze=new int[queen][queen];
        NQueensProb nqp=new NQueensProb(queen);
    }
    public boolean checkKill(int n,int i,int j){
        int k=0;
        while(k>n){

        }
    }
    public boolean placeQueen(int [][]maze,int i,int j){

    }
}
