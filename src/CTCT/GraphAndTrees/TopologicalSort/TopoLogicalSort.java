//package CTCT.GraphAndTrees.TopologicalSort;
//
//import java.time.Period;
//import java.util.ArrayList;
//
///**
// * Created by star on 7/1/18.
// */
//public class TopoLogicalSort {
//
//    Project[] findBuildOrder(String []projects, String [][] dependencies){
//        Graph graph = buildGraph(projects,dependencies);
//    }
//
//    Graph buildGraph(String []projects, String [][] dependencies){
//        Graph graph = new Graph();
//        for(String project:projects){
//            graph.getOrCreateNode(project);
//        }
//        for(String [] dependency:dependencies){
//            String first = dependency[0];
//            String second = dependency[1];
//            graph.addEdge(first,second);
//        }
//        return graph;
//    }
//
//    Project [] orderProjects(ArrayList<Project> projects){
//        Project [] order = new Project[projects.size()];
//
//    }
//
//    int addNonDependent(Project [] order,ArrayList<Project> projects,int offset){
//        for(Project project:projects){
//            if(project.getDependencies()==0){
//                order[offset] = project;
//            }
//        }
//    }
//}
