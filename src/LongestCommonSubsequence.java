import static java.lang.Integer.max;

class LongestCommonSubsequence{//Dynamic Programming
    static int [][]dpa;
    public static void main(String []args){
        String a="abcdaf";
        String b="acbcef";

        System.out.println(LCSDP(a.toCharArray(),b.toCharArray(),a.length(),b.length()));
        dpa=new int[a.length()][b.length()];
        for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                dpa[i][j]=0;
            }
        }
    }

    public static int LCS(char[] a,char[] b,int m,int n){
        if(m==0||n==0)return 0;
        if(a[m-1]==b[n-1]){
            return 1+LCS(a,b,m-1,n-1);
        }
        else{
            return Math.max(LCS(a,b,m-1,n),LCS(a,b,m,n-1));
        }
    }
    public static int LCSDP(char[] a,char[] b,int m,int n){
        if(m==0||n==0)return dpa[m][n]=0;

        if(a[m-1]==b[n-1]){
            System.out.println(dpa[5]+""+m+"--"+n);
            if(dpa[m-1][n-1]==0){
                dpa[m-1][n-1]=LCS(a,b,m-1,n-1);
            }
            dpa[m][n]=1+dpa[m-1][n-1];
            return dpa[m][n];
        }

        else{
            if(dpa[m-1][n]==0){
                dpa[m-1][n]=LCS(a,b,m-1,n);
            }if (dpa[m][n-1]==0){
                dpa[m][n-1]=LCS(a,b,m,n-1);
            }
            return Math.max(dpa[m-1][n],dpa[m][n-1]);
        }
    }
}