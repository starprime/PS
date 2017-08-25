import static java.lang.Integer.max;

class LongestCommonSubsequence{//Dynamic Programming
    public static void main(String []args){
        String a="abcdaf";
        String b="acbcf";
        int t[][]=new int[a.length()][b.length()];
        for(int i=0;i<a.length();i++)
        {
            for(int j=0;j<b.length();j++){
                if(i==0||j==0){
                    t[i][j]=0;
                }
                else if(a.charAt(i)==b.charAt(j)){
                    t[i][j]=t[i-1][j-1]+1;
                }else {
                    t[i][j]=max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        for(int [] row:t){
            printRow(row);
        }
    }
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}