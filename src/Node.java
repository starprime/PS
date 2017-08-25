import java.util.LinkedList;

/**
 * Created by skuma115 on 6/16/2017.
 */
public class Node {
    private int id;
    LinkedList<Node> adj=new LinkedList<Node>();
    private Node(int id){
        this.id=id;
    }
}
