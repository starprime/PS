import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    List<Integer> ret;
    int k;

    public List<Integer> lexicalOrder(int k) {
        LexicographicalNumbers s=new LexicographicalNumbers();
        ret=new ArrayList<>();
        s.k=k;
        s.genR(1);
        return ret;
    }
    public void genR(int n){
        if(n>k)return;
        for(int i=0;i<=10&&n+i<k;i++){
            System.out.println(n+i);
            ret.add(0,n+i);
            genR((n+i)*10);
        }
    }
}