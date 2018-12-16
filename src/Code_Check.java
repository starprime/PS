import java.util.Arrays;

/**
 * Created by star on 11/30/18.
 */
public class Code_Check {
    public static void main(String[] args) {
        System.out.println(Math.log(16) / Math.log(2));

        int [][][]coordsTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };
        new Code_Check().rotateRight(coordsTable[7]);


    }

    public void rotateLeft(int [][]shpe) {
        PrintArray.printArray(shpe);

        for(int i=0;i<shpe.length;i++){
            int tmp = shpe[i][0];
            shpe[i][0] = shpe[i][1];
            shpe[i][1] = -tmp;
        }
        PrintArray.printArray(shpe);
    }

    public void rotateRight(int [][]shpe) {
        PrintArray.printArray(shpe);

        for(int i=0;i<shpe.length;i++){
            int tmp = shpe[i][0];
            shpe[i][0] = -shpe[i][1];
            shpe[i][1] = tmp;
        }
        PrintArray.printArray(shpe);
    }


}
