import java.math.BigInteger;

public class DotProduct {
    static int dotProduct(int[] x, int[] y) {

        int n = x.length;

        //int sum = 0;
        BigInteger sum = new BigInteger("0");
        for(int i=0; i < n; i++){
            sum = sum.add(new BigInteger(String.valueOf(x[i])).multiply(new BigInteger(String.valueOf(y[i]))));
        }

        //System.out.print(sum);
        return sum.intValue();

    }
    public static void main(String[] args){
        int x[]={3,1,4,5,1,2,5};
        int y[]={};

    }
}
