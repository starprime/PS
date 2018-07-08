package CTCT.GraphAndTrees.TopologicalSort;

/**
 * Created by star on 7/4/18.
 */
public class Wieghted_Binary_Tree {
    public  static Tree_Node_Weighted root;

    public static void main(String []args){

    }

    public static void add(Tree_Node_Weighted root,int val){
        if(root == null){
            root = new Tree_Node_Weighted(val);
            return;
        }
        else {
        if(root.left_sum > root.right_sum){
            root.right_sum++;
            add(root.right,val);

        }else {
            root.left_sum++;
            add(root.left,val);
        }
    }
    }

}
