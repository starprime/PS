import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by skuma115 on 7/2/2017.
 */
public class Valid_Parentheses {
    Stack<Character> stck;
    public Valid_Parentheses(){
        stck=new Stack<Character>();
    }
    public boolean isValid(String s){
        int slen=s.length();char c;boolean ret=true;
        for(int i=0;i<slen;i++){
            c=s.charAt(i);
            if(c=='('||c=='['||c=='{'||c=='}'||c==']'||c==')'){
                if(c=='('){
                    stck.push(')');
                }else if(c==']'){
                    stck.push(']');
                }else if(c=='{'){
                    stck.push('}');
                }else if(stck.isEmpty()||stck.pop()!=c){
                    ret= false;
                }else if(stck.pop()==c){
                    ret= true;
                }
            }
        }return ret;
    }
    public static void main(String[] args){
        Valid_Parentheses vp=new Valid_Parentheses();
        System.out.print(vp.isValid("asaa()ss"));
    }
}
