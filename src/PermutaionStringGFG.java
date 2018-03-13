public class PermutaionStringGFG {
    static int k=0;
    public static void main(String []args){
        String st="ABC";
        PermutaionStringGFG psg=new PermutaionStringGFG();
        psg.permute(st,0,st.length()-1);
    }


    public void permute(String str,int l,int h){
        if(l==h){
            System.out.println(str);
        }else {
            for (int i = l; i <= h; i++) {
                k++;
                str = swap(str, l, i);
                permute(str, l + 1, h);
                str = swap(str, l, i);
            }
        }
    }
    public String swap(String str,int i,int j){
        char []arr=str.toCharArray();
        char c=arr[i];
        arr[i]=arr[j];
        arr[j]=c;
        String s= String.valueOf(arr);
        return s;
    }
}
