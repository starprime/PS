package CTCT.GraphAndTrees.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by star on 7/1/18.
 */
public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String,Project> map = new HashMap<>();

    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name,node);
        }
        return map.get(name);
    }
    public void addEdge(String startName,String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNieghbour(end);
    }

}
