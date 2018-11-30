package Tetris;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by star on 11/22/18.
 */

public class MineSweeper {
    Random rn;
    int SIDE  = 24; // side length of the board
    int MINES = 99; // // number of mines on the board
    final int MAXSIDE = 7;
    final int MAXMINES = 20;
    int[][] realBoard;
    int[][] myBoard;
    boolean gameOver;

    public MineSweeper(){
        rn = new Random();
        gameOver = false;
        realBoard = new int[MAXSIDE][MAXSIDE];
        myBoard= new int[MAXSIDE][MAXSIDE];
        randomMines();
        nonMinesVal();
    }

    public void randomMines(){
        int tn = 0; /// mine is represented by 9
        int x,y;
        while(tn<MAXMINES){
            x = rn.nextInt(MAXSIDE);
            y = rn.nextInt(MAXSIDE);
            if(realBoard[x][y]!=9){
                realBoard[x][y] = 9;
                tn++;
            }
        }
    }

    private void nonMinesVal(){
        for(int i = 0;i<MAXSIDE;i++){
            for(int j = 0;j<MAXSIDE;j++){
                if(realBoard[i][j] == 9)continue;
                realBoard[i][j] = countMines(i-1,j) + countMines(i+1,j) +
                                  countMines(i,j-1) + countMines(i,j+1) +
                                  countMines(i-1,j-1) + countMines(i-1,j+1) +
                                  countMines(i+1,j-1) + countMines(i+1,j+1);

            }
        }
    }

    private int countMines(int i,int j){
        if(i < 0 || j < 0 || i >=MAXSIDE || j >= MAXSIDE || realBoard[i][j] != 9){
            return 0;
        }
        return 1;

    }
    private void disPlayStatReal(){
        for(int i = 0;i<MAXSIDE;i++){
            System.out.println();
            for(int j = 0;j<MAXSIDE;j++){
                System.out.print(realBoard[i][j]+",");
            }
        }
    }
    private void disPlayStat(){
        for(int i = 0;i<MAXSIDE;i++){
            System.out.println();
            for(int j = 0;j<MAXSIDE;j++){
                System.out.print(myBoard[i][j]+",");
            }
        }
    }

    private void makeMove(int i,int j){
        System.out.println("Move made for "+i+" and "+j);
        if(realBoard[i][j] == 9){
            disPlayStatReal();
            gameOver = true;
            return;
        }
        myBoard[i][j] = realBoard[i][j];
        disPlayStat();
        System.out.println();
    }

    private void play(){
        Scanner sc = new Scanner(System.in);
        String[] cords;

        while (!gameOver){
            cords = sc.nextLine().split(",");
            makeMove(Integer.valueOf(cords[0]),Integer.valueOf(cords[1]));
        }
        System.out.println("\n Game Over");

    }

    public static void main(String []args){
        MineSweeper mineSweeper = new MineSweeper();
        //mineSweeper.disPlayStatReal();
        mineSweeper.play();
    }
}
