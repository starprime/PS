import java.util.Stack;
public class NextGreaterElemnt{
    public static void main(String []args){
        Stack<Integer> stck=new Stack<Integer>();
        int []arr={4,5,2,25,6,3,10};
        stck.push(arr[0]);int curr=0,next=0;
        for(int i=1;i<arr.length;i++){
            next=arr[i];
            if(!stck.empty()){
                curr=stck.pop();
                while(next>curr){
                    System.out.println(curr+"has next element"+next);
                    if(!stck.empty()){
                    curr=stck.pop();}else {stck.push(next);break;}
                }
                if(curr>next){stck.push(curr);stck.push(next);}
            }
        }while(!stck.empty()){
            System.out.println(stck.pop()+"has next element -1");
        }
    }
}