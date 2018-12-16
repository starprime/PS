import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTT {
    int mat[][] = new int[3][3];
    int count = 0;
    char dis[] = { '-', 'X', 'O' };
    int resultR[] = new int[3];
    int resultC[] = new int[3];
    int resultD[] = new int[3];
    int resultAD[] = new int[3];

    TicTT() {

    }

    boolean addToken(int i, int j, int player) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3 && mat[i][j] == 0) { // should check isBoardfull logic here
            mat[i][j] = player;
            count++;
            resultR[i] += player == 2 ? -1 : 1; // leetcode lgic
            // if(Math.abs(resultR[i])==3)
            return true;
        } else {
            System.out.println("Wrong move made please try again");
        }
        return false;
    }

    boolean isBoardFull() {
        if (count >= 9)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TicTT tic = new TicTT();
        tic.printBoard();
		/*
		 * if (!tic.addToken(0, 1, 1)) { System.out.println("Improper location"); }
		 */
        Scanner sc = new Scanner(System.in);
        while (!tic.isBoardFull()) {
            System.out.println("Enter row, col for your move");
            try {
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (!tic.addToken(r, c, 1)) {
                    continue;
                }
            } catch (InputMismatchException e) {
                continue;
            }
            System.out.println("Human Move made");
            tic.printBoard();
            tic.makeAIMove();
            System.out.println("AI Move made");
            tic.printBoard();
        }
        tic.printBoard();
    }

    private void makeAIMove() {
        if (!isBoardFull()) { // could have used random function for i, j
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (addToken(i, j, 2)) {
                        return;
                    }
                }
            }
        } else {
            System.out.println("Board is full!!");
            throw new NullPointerException(); // Null pointer to exit abruptly

            // Runtime exception is used not Compile time exception( will use try catch - which is gracefull exception)
            // Custom error class could have been
        }
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dis[mat[i][j]]);
                if (j != 2)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
}
