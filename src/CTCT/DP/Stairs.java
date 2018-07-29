package CTCT.DP;

public class Stairs {
    static int type_steps = 2;
    static int totalPC = 0;

    public static void main(String []args){
        int total_steps_n = 5;
        int blnce = 3;
        getPnC(1,blnce);
        System.out.println(totalPC);

    }

    static  void getPnC(int ith, int blnce){
        if(blnce==0) {
            totalPC=totalPC+1;return;
        }
        if(blnce < 0)return;

        for (int i=ith; i <= type_steps; i++){
            if(blnce-i<0)return;
            blnce=blnce-i;
            getPnC(i,blnce);
        }
    }

}