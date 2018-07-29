package CTCT.GraphAndTrees.TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;
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
        Tree_Node_Weighted nd = new Tree_Node_Weighted(1);
        int i = 2;
        Random rn = new Random();
        while (i<15){
            nd.add(i);
            i++;
        }

        inorder(nd);
        System.out.println(nd.left.left_sum);
        System.out.println(nd.left.right_sum);
        System.out.println(nd.size());
        System.out.println(nd.data());
        preorder(nd);
        printLevelOrderBFS(nd);

    }
    public static void printLevelOrderBFS(Tree_Node_Weighted root){
        Queue<Tree_Node_Weighted> queue = new LinkedList<Tree_Node_Weighted>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while(!queue.isEmpty()){
            Tree_Node_Weighted n = queue.remove();
            System.out.print(n.val + " ");
            if(n.left != null){
                queue.add(n.left);
                nextLevelCount++;
            }
            if(n.right != null){
                queue.add(n.right);
                nextLevelCount++;
            }
            currentLevelCount--;
            if(currentLevelCount == 0){
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
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
    public static void preorder(Tree_Node_Weighted node){
        if(node==null)return;
        System.out.print(node.val+" -> ");
        preorder(node.left);
        preorder(node.right);
    }
}
