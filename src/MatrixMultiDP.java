public class MatrixMultiDP {
    public static void main(String []args){
        int arr[]=new int[]{40,20,30,10,30};

        System.out.println(MatrixMulti(arr,1,arr.length-1));

    }
    public static int MatrixMulti(int []arr,int i,int p){
        if(i==p)return 0;
        int cnt=0;

        int min=Integer.MAX_VALUE;

        for(int k=i;k<p;k++){
            cnt=MatrixMulti(arr,i,k)+MatrixMulti(arr,k+1,p)+arr[i-1]*arr[k]*arr[p];
        }

        if(min>cnt){
            min=cnt;
        }

        return min;

    }
}