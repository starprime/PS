package CTCT.GraphAndTrees.TopologicalSort;

/**
 * Created by star on 7/4/18.
 */
public class Wieghted_Binary_Tree {
    public static Tree_Node_Weighted root;
    public static void main(String []args){
        add(root,5);
        add(root,1);
        add(root,3);

        inorder(root);
    }
    public static void inorder(Tree_Node_Weighted node){
        if(node==null)return;
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
        return;
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
