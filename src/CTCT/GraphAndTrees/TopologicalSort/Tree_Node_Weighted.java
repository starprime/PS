package CTCT.GraphAndTrees.TopologicalSort;

import java.util.Random;

/**
 * Created by star on 7/4/18.
 */
public class Tree_Node_Weighted {
    Tree_Node_Weighted left;
    Tree_Node_Weighted right;
    int val;
    int left_sum = 0;
    int right_sum = 0;

    public Tree_Node_Weighted(int val){
        this.val = val;
    }
    public static void main(String []args){
        Tree_Node_Weighted nd = new Tree_Node_Weighted(23);
        int i = 0;
        Random rn = new Random();
        while (i<101){
            nd.add(rn.nextInt(500));
            i++;
        }

        //inorder(nd);
        System.out.println(nd.left.left_sum);
        System.out.println(nd.left.right_sum);
        System.out.println(nd.size());
        System.out.println(nd.data());
        System.out.println(nd.left.right.right.right.val);

    }

    public int random(){
        int sz = size();
        Random rnd = new Random();
        int ret = rnd.nextInt(sz);
        if(ret == left_sum+1)return val;
        if(ret > left_sum){
            ret-=left_sum;
            return find(left,ret);
        }else{
            //ret-=right_sum;
            return find(right,ret);
        }

    }
    public int find(Tree_Node_Weighted nd,int blnce){
        return 4;
    }

    public int size(){return left_sum+right_sum;}
    public int data(){return val;}
    public void add(int val){
            if(left_sum > right_sum){
                right_sum++;
                if(right == null){
                    right = new Tree_Node_Weighted(val);
                    return;
                }else {
                    right.add(val);
                }
            }else {
                left_sum++;
                if(left == null){
                    left = new Tree_Node_Weighted(val);
                    return;
                }else {
                    left.add(val);
                }
            }
            return;
    }

    public static void inorder(Tree_Node_Weighted node){
        if(node==null)return;
        inorder(node.left);
        System.out.print(node.val+" -> ");
        inorder(node.right);
        return;
    }
}
