
public class BST{
    TreeNode root;
    BST(){
        root=null;
    }
    void insert(int key){
        root=insertRec(root,key);
        System.out.print(root);

    }
  public TreeNode Search(TreeNode root,int key){
        if(root==null) {System.out.println("Key not found");}
        else if(root.val>key){return Search(root.left,key);}
        else if(root.val<key){return Search(root.right,key);}
        return root;
    }

    public TreeNode insertRec(TreeNode root,int key){
//        if(root.val==key){System.out.println("Key already there");return  root;}
        if(root==null){root=new TreeNode(key);System.out.println(" - "+key);return root;}
		else if(root.val>key){return insertRec(root.left,key);}
        else if(root.val<key){return insertRec(root.right,key);}
        return root;
    }
    public void inorderTrav(TreeNode nd){
        if(nd!=null){
            inorderTrav(nd.left);
            System.out.println(nd.val);
            inorderTrav(nd.right);
        }
    }
    public void inorderTrav(){
        System.out.print(root);
        inorderTrav(root);
    }
    public static void main(String [] args){
        BST tree=new BST();
        tree.insert(50);

        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorderTrav();
    }
}
