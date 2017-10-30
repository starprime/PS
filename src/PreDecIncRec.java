public class PreDecIncRec {
    public static void main(String []args){
        int a=4;
        print(a);
    }
    static public void print(int n){
        if(n>0){
            print(--n);
            System.out.print("#" + n);
            print(--n);
        }
        return;
    }
}
