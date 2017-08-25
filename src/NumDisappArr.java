import java.util.ArrayList;
import java.util.List;

/**
 * Created by skuma115 on 8/3/2017.
 */
// {4,3,2,7,8,2,3,1}
//    [5,6]
public class NumDisappArr{
    public static void main(String []args){
        NumDisappArr nda=new NumDisappArr();
        //nda.AmitChool();
        //System.out.println(nda.numberOfBoomerangs(new int[][]{{{0,0},{1,0},{-1,0},{0,1},{0,-1}}}));
    }
    public void AmitChool(){
        List al=new ArrayList();
        al.add(4);
        al.add(0,1);
        System.out.println(al);
        al.add(0,2);
        System.out.println(al);
        al.add(1,5);
        System.out.println(al.contains(5));
        System.out.println(al.get(2));
    }
    public int numberOfBoomerangs(int[][] points) {
        int ret=0;double dist;
        List<Double> no;
        int []iit;
        int []jit;
        for(int i=0;i<points.length;i++){
            no=new ArrayList<Double>();
            iit=points[i];
            for(int j=0;j<points.length;j++){
                dist=0;
                jit=points[j];
                if(iit[0]==jit[0]&&iit[1]==jit[1]){continue;}
                dist=getDist(iit,jit);
                if(no.contains(dist)){ret++;}
                else{no.add(dist);}
            }
        }
        return ret;
    }
    public double getDist(int []i,int []j){
        double dist;
        int id=Math.abs(i[0]-j[0]);
        int jd=Math.abs(i[1]-j[1]);
        id=id*id;
        jd=jd*jd;
        dist=id+jd;
        return Math.sqrt(dist);
    }
}
