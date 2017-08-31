import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutation {
    public List<String> permuT(char in[]){
        Map<Character,Integer> coMa=new HashMap<>();
        for(char c:in){
            coMa.compute(c,(key,val)->{
                if(val==null){
                    return 1;
                }else {
                    return val+1;
                }
            });
        }
        char str[]=new char[coMa.size()];
        int cnt[]=new int[coMa.size()];
        int indx=0;
        for(Map.Entry<Character,Integer> entry:coMa.entrySet()){
            str[indx]=entry.getKey();
            cnt[indx]=entry.getValue();
            indx++;
        }
        List<String> reLi=new ArrayList<>();
        char []res=new char[in.length];
        pemutUtil(str,cnt,res,0,reLi);
        return reLi;
    }
    public void pemutUtil(char []str,int []cnt,char []result,int level,List<String> resultList){
        if(result.length==level){
            resultList.add(new String(result));
            return;
        }
        for (int i=0;i<str.length;i++){

        }
    }
}
