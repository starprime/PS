public class MatrixMultiDP {
    static int [][]dp;static int cntdp=0,cnt=0;
    public static void main(String []args){
        int arr[]=new int[]{1,2,3,4,5};
        int n=arr.length;
        dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        System.out.println(matrixOrder(arr,1,n-1));
        System.out.println(MatrixChainOrder(arr,1,n-1));

        System.out.println();
        for (int i=0;i<n;i++){
            System.out.println();
            for (int j=0;j<n;j++){
                System.out.print("\t"+dp[i][j]);
            }
        }
        System.out.println("\n for arr length -- "+arr.length);

        System.out.println("\n"+cnt);

        System.out.println("\n"+cntdp);


    }

    public static int matrixOrder(int []arr,int i,int j){
        if(i==j)return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=0)return dp[i][j];
        for(int k=i;k<j;k++){
            cntdp++;
            dp[i][k]=(dp[i][k]==0)?matrixOrder(arr,i,k):dp[i][k];
            dp[k+1][j]=(dp[k+1][j]==0)?matrixOrder(arr,k+1,j):dp[k+1][j];

            int cnt=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];

            min=Math.min(min,cnt);
        }
        dp[i][j]=min;
        return min;

    }

    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {   cnt++;
            int count = MatrixChainOrder(p, i, k) +
                    MatrixChainOrder(p, k+1, j) +
                    p[i-1]*p[k]*p[j];
            System.out.println((i-1)+"--"+k+"--"+(j)+"--"+p[i-1]*p[k]*p[j]);
            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;
    }
}
/*
         0  1   2   3   4
     0   0	0	0	0	0
     1   0	0	6	18	38
     2   0	0	0	24	64
     3   0	0	0	0	60
     4   0	0	0	0	0
     */