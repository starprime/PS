import java.util.ArrayList;
import java.util.List;


public class MyStringBuilder {
    List<Character> li;

    public MyStringBuilder(){
        li = new ArrayList<>();
    }

    public void add(char c){
        li.add(c);
    }

    public void add(String str){
        for(char c:str.toCharArray()){
            li.add(c);
        }
    }

    public String toString(){
        int sz = li.size();
        char [] chAr = new char[sz];

        for(int i=0;i<sz;i++){
            chAr[i] = li.get(i);
        }

        return String.valueOf(chAr);
    }

    public static void main(String []args){
        MyStringBuilder msb = new MyStringBuilder();
        msb.add('p');
        msb.add("lol");
        System.out.println(msb.toString());
    }

}
