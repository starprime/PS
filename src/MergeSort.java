public class MergeSort {

    public static void main(String []args){
        int [] arr = {23,12,4,121,59,12};
        MergeSort ms = new MergeSort();
        ms.sort(arr,0,arr.length);
    }

    public void sort(int []arr,int l,int r){
        int len = r-l;
        if(len>1){
            sort(arr,l,len/2);
            sort(arr,len/2+1,r);
            merge(arr,l,len/2,r);
        }
        return;
    }

    public void merge(int[] arr, int l, int m, int r) {

        int k=m+1;
        int [] left = new int[m-l+1];
        int [] right = new int[r-m];

        for(int c=0,i=l;i<m;i++,c++){
            left[c]=arr[i];
        }

        for(int c=0,i=m+1;i<r;i++,c++){
            right[c]=arr[i];
        }

        int a = 0,x = l, b = 0;

        while(a < m+1 && b < r+1){
            if(left[a]>right[b]){
                arr[x] = right[b];x++;b++;
            }else {
                arr[x] = left[a];x++;a++;
            }
        }

        if(a==m){
            for(int i=b;b<r;i++){
                arr[x] = right[i];x++;
            }
        }else if(b == r){
            for(int i=a;a<m+1;i++){
                arr[x] = left[i];x++;
            }
        }
    }

    public void swap(int []arr,int x,int y){
        int re = arr[x];
        arr[x] = arr[y];
        arr[y] = re;
    }

}
