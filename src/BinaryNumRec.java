public class BinaryNumRec {
    public static void main(String []args){
        int n= 10;
        BinaryNumRec bnr=new BinaryNumRec();
        bnr.createBin(n);
    }
    public void createBin(int n){
        if(n==1){System.out.print(n);return;}
        createBin(n/2);
        System.out.print(n%2);
    }
}
