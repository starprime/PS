/**
 * Created by star on 8/15/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 11, 5, 23, 12};
        Solution6 s = new Solution6();

        System.out.println(kthLarger(arr, 0, arr.length - 1, 4));
        s.printArray(arr);

    }

    static int kthLarger(int[] arr, int l, int r, int tgt) {
        if (l >= r) return -1;

        int piv = partitionFunc(arr, l, r);

        System.out.println(piv);
        Solution6 s = new Solution6();
        s.printArray(arr);

        if (piv == tgt) return arr[piv];
        else if (piv > tgt) return kthLarger(arr, l, piv - 1, tgt);
        else return kthLarger(arr, piv + 1, r, tgt);

    }

    static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int piv = partitionFunc(arr, l, r);
        quickSort(arr, l, piv - 1);
        quickSort(arr, piv + 1, r);
        return;
    }

    static int partitionFunc(int[] arr, int l, int r) {

        int piv = r;
        r = r - 1;

        while (l < r) {

            int lval = arr[l], rval = arr[r], pivVal = arr[piv];

            if (rval < pivVal && lval > pivVal) {
                swap(arr, l, r);
                r--;
                l++;
            } else if (rval > pivVal && lval < pivVal) {
                r--;
                l++;
            } else if (rval > pivVal) {
                r--;
            } else if (lval < pivVal) {
                l++;
            }

        }
        System.out.println("l - " + l + " r " + r);
        int newPiv = Math.max(r, l);
        if (arr[newPiv] > arr[piv]) swap(arr, newPiv, piv);
        return newPiv;
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
