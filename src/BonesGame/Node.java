package BonesGame;

import java.util.List;

/**
 * Created by star on 12/22/18.
 */
public class Node {
    int noOfBones;
    boolean isMaxPlayer;
    int score;
    List<Node> children;
    // setters and getters

    public Node(int noOfBones, boolean isMaxPlayer, int score, List<Node> children) {
        this.noOfBones = noOfBones;
        this.isMaxPlayer = isMaxPlayer;
        this.score = score;
        this.children = children;
    }

    public Node(int noOfBones, boolean isMaxPlayer) {
        this.noOfBones = noOfBones;
        this.isMaxPlayer = isMaxPlayer;
    }

    public int getNoOfBones() {
        return noOfBones;
    }

    public void setNoOfBones(int noOfBones) {
        this.noOfBones = noOfBones;
    }

    public boolean isMaxPlayer() {
        return isMaxPlayer;
    }

    public void setMaxPlayer(boolean maxPlayer) {
        isMaxPlayer = maxPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}