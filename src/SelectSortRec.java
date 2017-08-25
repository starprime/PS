public class SelectSortRec {
    public static void main(String []args){
        int []arr={23,321,12,31,1534,44,34,75};
        SelectSortRec ssr=new SelectSortRec();
        ssr.selc(arr,0,1);
    }
    public void selc(int []arr,int i,int j){
        if(i>=arr.length-1){        System.out.println("--");
            return;}
        print(arr);
        if(arr[i]>arr[j]){
            swap(arr,i,j);
            j++;
        }else{
                j++;
        }
        if(j>arr.length-1&&i!=arr.length-2){
            i++;
            j=i+1;
        }
        selc(arr,i,j);
    }
    public void swap(int []arr,int i,int j){
        int l=arr[i];
        arr[i]=arr[j];
        arr[j]=l;
    }
    public void print(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}