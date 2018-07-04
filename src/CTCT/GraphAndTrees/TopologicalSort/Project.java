package CTCT.GraphAndTrees.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by star on 7/1/18.
 */
public class Project {
    private ArrayList<Project> child = new ArrayList<>();
    private HashMap<String,Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name){
        this.name = name;
    }
    public void addNieghbour(Project node){
        if(!map.containsKey(node.getName())){
            child.add(node);
            map.put(node.getName(),node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies(){dependencies++;}

    public void decrementependencies(){dependencies--;}

    public String getName() { return name; }

    public ArrayList<Project> getChild() { return child;}

    public int getDependencies() { return dependencies; }
}
