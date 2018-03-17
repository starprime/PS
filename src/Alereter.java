/**
 * Created by star on 3/15/18.
 */
public class Alereter {
    public static void main(String []args){
        float n = (float) 1.5;
        alert(new int[]{1, 2, 100, 2, 2},3,n);
    }

    static boolean alert(int[] inputs, int windowSize, float allowedIncrease) {
        int len = inputs.length;
        int isum=0;
        for(int j=0;j<windowSize;j++){
            isum = isum+inputs[j];
        }

        int nwsum = isum;
        System.out.println(nwsum);
        for(int i=windowSize;i<len;i++){
            nwsum-= (inputs[i-windowSize]/windowSize);
            nwsum+= (inputs[i]/windowSize);
            System.out.println(nwsum);
        }
        return true;
    }

    static boolean chk(int []arr,int x,int y,int find){
        for(int i=x;i<=y;i++){
            if(arr[i]==find)return true;
        }
        return false;
    }

}
