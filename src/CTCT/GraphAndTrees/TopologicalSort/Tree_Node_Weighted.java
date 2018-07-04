package CTCT.GraphAndTrees.TopologicalSort;

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
    public Tree_Node_Weighted(int val,int left_sum,int right_sum){
        this.val = val;
        this.left_sum = left_sum;
        this.right_sum = right_sum;
    }

}
