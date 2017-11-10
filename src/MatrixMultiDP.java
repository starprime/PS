public class MatrixMultiDP {
    static int [][]dp;
    public static void main(String []args){
        int arr[]=new int[]{1,2,3,4,5};
        int n=arr.length;
        dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        System.out.println(DPMatrixMulti(arr,1,arr.length-1));
        System.out.println();
        System.out.println(MatrixChainOrder(arr,n));
        for (int i=0;i<n;i++){
            System.out.println();
            for (int j=0;j<n;j++){
                System.out.print("\t"+dp[i][j]);
            }
        }

    }
    public static int MatrixMulti(int []arr,int i,int p){

        if(i==p)return 0;
        int cnt=0;

        int min=Integer.MAX_VALUE;

        for(int k=i;k<p;k++){
            cnt=MatrixMulti(arr,i,k)+MatrixMulti(arr,k+1,p)+arr[i-1]*arr[k]*arr[p];
        }

        if(min>cnt){
            min=cnt;
        }

        return min;
    }

    public static int DPMatrixMulti(int []arr,int i,int p){

        if(i==p)return 0;
        int cnt=0;



        int min=Integer.MAX_VALUE;

        for(int k=i;k<p;k++){
            if(dp[i][k]==0){
                dp[i][k]=DPMatrixMulti(arr,i,k);
            }
            if(dp[k+1][p]==0){
                dp[k+1][p]=DPMatrixMulti(arr,k+1,p);
            }
            cnt=dp[i][k]+dp[k+1][p]+arr[i-1]*arr[k]*arr[p];
        }

        if(min>cnt){
            min=cnt;
        }

        return min;
    }
    static int MatrixChainOrder(int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }
}
