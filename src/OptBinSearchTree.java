public class OptBinSearchTree {
    public static int[][]w,c,r;
    public static int n;
    public static int []keys,q,p;

    public static void main(String [] args){
        keys=new int[]{3,7,10,15,20,25};
        q=new int[]{5,6,4,4,3,8,0};
        p=new int[]{10,3,9,2,0,10};
        n=keys.length;

    }
    public void OBST(){
        for(int i=0;i<=n;i++){
            w[i][i]=q[i];
            for(int j=i+1;j<=n;j++){
                w[i][j]=w[i][j-1]+p[j]+q[j];
            }
        }
        for(int i=0;i<=n;i++){
            c[i][i]=w[i][i];
        }
        for(int i=0;i<=n-1;i++){
            int j=i+1;
            c[i][j]=w[i][j]+c[i][i]+c[j][j];
            r[i][j]=j;
        }
        int min=Integer.MAX_VALUE;
        for(int h = 2; h <= n; h++) {
            for (int i = 0; i <= n - h; i++) {
                int j = i + h;
                int m = r[i][j - 1];
                min = c[i][m - 1] + c[m][j];
                for (int k = m + 1; k <= r[i + 1][j]; k++) {
                    int x = c[i][k - 1] + c[k][j];
                    if (x < min) {
                        m = k;
                        min = x;
                    }
                }
                c[i][j] = w[i][j] + min;
                r[i][j] = m;
            }

        }
        System.out.print("\nThe weight matrix W:\n");
        int i=0,j;
        for(i = 0; i <= n; i++){
            for(j = i; j <= n; j++)
                System.out.println("%d "+w[i][j]);
        }

//Display Cost matrix C
        System.out.print("\nThe cost matrix C:\n");
        for(i = 0; i <= n; i++) {
            for(j = i; j <= n; j++)
                System.out.println(c[i][j]);
        }

//Display root matrix R
        for(i = 0; i <= n; i++) {
            for(j = i; j <= n; j++)
                System.out.println("%d "+ r[i][j]);
        }

    }
}
