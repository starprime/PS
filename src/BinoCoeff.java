public class BinoCoeff{

    int [][]zf;
    public BinoCoeff(int n,int k){
        zf=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int l=0;l<=k;k++){
                zf[i][l]=0;
            }
        }
    }
    public static void main(String [] args){
        long strt=System.nanoTime();
        int n=5000,k=2;
        BinoCoeff bc=new BinoCoeff(n,k);
        long c=bc.getCof(n,k);
        long end=System.nanoTime();
        end=strt-end;
        end/=216000;
        System.out.print(c+"--"+end);
    }

    public int getCof(int n,int k){
        if(zf[n][k]!=0) return zf[n][k];
        if(n==k) return 1;
        else if(k==0) return 1;
        zf[n][k] =getCof(n-1,k-1)+getCof(n-1,k);
        return zf[n][k];
    }
}