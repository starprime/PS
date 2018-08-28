/**
 * Created by star on 8/25/18.
 */
public final class PrintArray {

    private PrintArray(){}

    static public void printArray(int []nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" , ");
        }
        System.out.println();
    }
    static public void printArray(char []chars){
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]+",");
        }
        System.out.println();
    }
    static public void printArray(String []str){
        for(int i=0;i<str.length;i++){
            System.out.print(str[i]+",");
        }
        System.out.println();
    }

    static public void printArray(String [][]str){
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str[0].length;j++) {
                System.out.print(str[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
    static public void printArray(char [][]chars){
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[0].length;j++) {
                System.out.print(chars[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
    static public void printArray(int [][]nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++) {
                System.out.print(nums[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

}
