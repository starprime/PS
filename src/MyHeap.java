/**
 * Created by skuma115 on 6/17/2017.
 */
public class MyHeap {

    public static void main(String [] args){
        int [] arr={12,3,141,31,63,1141};
        MyHeap mh=new MyHeap();
        mh.heapifyUp(arr);
        int len=arr.length;
        for(int i=0;i<len;i++){
            System.out.print("-"+arr[i]);
        }
    }
    public void heapifyUp(int []arr){
        int len=arr.length;
        int p;
        for(int c=len-1;c>0;c--){
            p=(c-2)/2;
            System.out.println((3/2)+"p-"+arr[p]+" c-"+arr[c]);
            if(arr[p]<arr[c]){
                swap(arr,p,c);
            }
        }
    }
    public void swap(int []arr,int x,int y){
        int temp=arr[y];
        arr[y]=arr[x];
        arr[x]=temp;
    }
}
