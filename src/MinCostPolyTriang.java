/**
 * Created by star on 11/10/17.
 */
public class MinCostPolyTriang {
    static double [][]dp;
    static int cnt=0,cntdp=0;
    public static void main(String []args){
        int [][]points=new int[][]{{0, 0},{0, 3},{0, 1}, {1, 0}, {2, 0}, {2, 1}, {1, 2}, {0, 2},{0, 3},{2, 2}, {4, 2}, {3, 2},{1, 3},{2, 3},{3, 3}};
        int n=points.length;
        dp=new double[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0.0;
            }
        }

        System.out.println(MCPTDP(points,0,points.length-1)+"--"+cntdp);

        System.out.println(MCPT(points,0,points.length-1)+"---"+cnt);

    }

    public static double MCPT(int [][]arr,int i,int j){
        if(j<i+2){
            return 0;
        }
        double min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            cnt++;
            double cnt=MCPT(arr,i,k)+MCPT(arr,k,j)+distance(arr,i,k,j);
            min=Math.min(min,cnt);
        }
        return min;
    }

    public  static double distance(int [][]arr,int i,int j,int k){
        return distBW(arr,i,j)+distBW(arr,j,k)+distBW(arr,k,i);
    }

    public static double distBW(int [][]arr,int i,int j){
        int []a=arr[i];
        int []b=arr[j];
        int x=a[0]-b[0];
        x*=x;
        int y=a[1]-b[1];
        y*=y;
        return Math.sqrt(x+y);
    }

    public static double MCPTDP(int [][]arr,int i,int j){
        if(j<i+2){
            dp[i][j]=0;
            return 0;
        }

        double min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            cntdp++;
            dp[i][k]=(dp[i][k]==0.0)?MCPTDP(arr,i,k):dp[i][k];
            dp[k][j]=(dp[k][j]==0.0)?MCPTDP(arr,k,j):dp[k][j];
            double cnt=dp[i][k]+ dp[k][j]+distance(arr,i,k,j);
            min=Math.min(min,cnt);
        }
        dp[i][j]= min;
        return dp[i][j];
    }

}
