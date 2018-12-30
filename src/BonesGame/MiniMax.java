//package BonesGame;
//
//import java.util.List;
//
///**
// * Created by star on 12/22/18.
// */
//
//
//
//public class MiniMax {
//    Tree tree;
//
//    public void constructTree(int noOfBones) {
//        tree = new Tree();
//        Node root = new Node(noOfBones, true);
//        tree.setRoot(root);
//        constructTree(root);
//    }
//
//    private void constructTree(Node parentNode) {
//        List<Integer> listofPossibleHeaps = GameOfBones.getPossibleStates(parentNode.getNoOfBones());
//        boolean isChildMaxPlayer = !parentNode.isMaxPlayer();
//        listofPossibleHeaps.forEach(n -> {
//            Node newNode = new Node(n, isChildMaxPlayer);
//            parentNode.addChild(newNode);
//            if (newNode.getNoOfBones() > 0) {
//                constructTree(newNode);
//            }
//        });
//    }
//}