/**
 * Created by skuma115 on 6/22/2017.
 * a b x a b c a b c a b y
 * a b c a b y
 */
public class KMP
{
    public static void main(String [] args){
        //String str="abxabcabcaby";
        //String patt="abcaby";
        String str="AAAAABAAABA";
        String patt="AAAA";
        //String patt="aabaabaaa";
        KMP kmp=new KMP();
        System.out.println(kmp.getPatternArr(patt.toCharArray()));
        //System.out.print(kmp.KMPS(patt.toCharArray(),str.toCharArray()));
    }
    public boolean KMPS(char [] patt,char [] haystack){
        int i=0,j=0;
        int []pattarr=getPatternArr(patt);
        while (j<haystack.length && i<patt.length){
            if(haystack[j]==patt[i]){
                i++;j++;
            }else{
                if(i!=0){
                    i=pattarr[i-1];
                }else{
                    j++;
                }
            }if(i==patt.length){
                return true;
            }
        }return false;
    }
    /*
    public int[] getPatternArr(char [] patt){
        int []retArr=new int[patt.length];
        int i=0,j=0;
        retArr[0]=0;
        for(i=1;i<patt.length;){
            if(patt[i]==patt[j]){
                retArr[i]=++j;
                i++;
            }else{
                if(j!=0){
                    j=retArr[j-1];
                }else{
                    retArr[i]=0;
                    i++;
                }
            }
        }
        return retArr;
    }*/

    public int[] getPatternArr(char [] patt){
        int []retArr=new int[patt.length];
        int i=1,j=0;
        retArr[0]=0;
        for(i=1;i<patt.length;){
            if(patt[j]==patt[i]){
                j++;
                retArr[i]=j;
                i++;
            }else {
                if(j!=0){
                    j=retArr[j-1];
                }else{
                    retArr[i]=0;
                    i++;
                }
            }
        }
        return retArr;
    }
    public void printArra(int [] pArr){
        for(int i=0;i<pArr.length;i++){
            System.out.print(pArr[i]);
        }
    }
}
