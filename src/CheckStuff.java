import java.util.HashSet;

/**
 * Created by skuma115 on 6/17/2017.
 */
public class CheckStuff {
    public static void main(String []args){
        CheckStuff cs=new CheckStuff();
        String testString="LOLMAX";
        int [] arr={2};//{1,2,3,4,1,2,1,4,1};

        char[] stringToCharArray = testString. toCharArray();
//        System.out.println("-"+stringToCharArray[1]+stringToCharArray.length);
        //cs.printAr(arr);
        //cs.removeElement(arr,3);
        int []nr={-1,0};

          System.out.println(cs.twoSum(nr,-1));
//        System.out.println(cs.addDigits(19));
//        System.out.println(cs.distributeCandies(nr));
//        System.out.println(cs.patternSearch("mississippi","issip"));
    }
    public int[] twoSum(int[] num, int target) {
        int j=0,k=0;    int []ret=new int[2];
        for(int i=0;num[i]<target&&i<(num.length)-1;i++){
            j=i+1;
            System.out.println(num[j]+"--"+k);
            k=target-num[i];
            while(num[j]<=k&&j<num.length){
                System.out.println(num[j]+"--"+k);
                if(num[j]==k){ret[0]=i+1;ret[1]=j+1;return ret;}
                j++;
                if(j==(num.length)){break;}
            }
        }return ret;
    }

    public int distributeCandies(int[] candies) {
        HashSet<Integer> hs=new HashSet<Integer>();
        int cl=candies.length;
        for(int i=0;i<cl;i++){
            hs.add(candies[i]);
            if(hs.size()>=cl/2){return hs.size();}
        }
        return hs.size();
    }

    public void printAr(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.println("-"+arr[i]);
        }
    }
    public int addDigits(int num) {
        int sum=0;
        while(num>=1){
            sum=sum+num%10;
            num=num/10;
            System.out.println(sum);
        }
        while(sum>=10){
            num=sum/10;
            sum=sum%10;
            sum=num+sum;
            System.out.println(sum+"-"+num);
        }

        return sum;
    }
    public  int reverse(int x) {
        int ret=0,l;
        while(x>0){
            ret*=10;
            l=x%10;
            ret=ret+l;
            x=x/10;
        }
        return ret;
    }
    public int removeElement(int[] nums, int val) {
        int ret=0,j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
                ret++;
            }
        }
        printAr(nums);
        System.out.println(ret);
        return ret;
    }//         System.out.println(cs.strStr("mississippi","issip"));
    public int strStr(String haystack, String needle) {
        int ret=0,lenH=haystack.length(),lenN=needle.length(),indN=0,got=0;
        char c='a',n=needle.charAt(0);boolean flg=false;
        for(int i=0;i<lenH;i++){
            c=haystack.charAt(i);
            if(flg){
                n=needle.charAt(indN);
                if(c!=n){
                    flg=false;
                    got=0;
                    indN=0;
                    n=needle.charAt(0);
                }
            }
            if(c==n){
                got++;
                ret=i;
                indN++;
                flg=true;
                System.out.println(n);

            }
            if(got==lenN){
                return ret-lenN+1;
            }
        }return -1;
    }
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0; i < l1-l2+1; i++) {
            int count = 0;
            while (count < l2 && haystack.charAt(i+count) == needle.charAt(count))
                count++;
            if (count == l2)
                return i;
        }
        return -1;
    }


    public int patternSearch(String htk,String ndle){
        int ret=-1;int hl=htk.length();int nl=ndle.length();
        char h,n;
        for(int i=0;i<hl-nl+1;i++){
            int j;
            ret=i;
            for(j=0;j<nl;j++){
                h=htk.charAt(i+j);
                n=ndle.charAt(j);
                if(h!=n) break;
            }
        }
        return ret;
    }
}