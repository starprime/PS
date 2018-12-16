// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution3
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    private class BFS_class{
        private int coord_X;
        private int coord_Y;
        private int path_distance;

        BFS_class(int coord_X,int coord_Y,int d){
            this.coord_X = coord_X;
            this.coord_Y = coord_Y;
            this.path_distance = d;
        }
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {

        boolean[][] coord_visited = new boolean[numRows][numColumns];

        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numColumns; col++)
            {
                if (area.get(row).get(col) == 0)
                {
                    coord_visited[row][col] = true;
                    continue;
                }
            }
        }


        BFS_class begin_coord = new BFS_class(0,0,0);

        Queue<BFS_class> queue = new LinkedList<>();

        queue.offer(begin_coord);

        coord_visited[0][0] = true;

        while (!queue.isEmpty()) {
            BFS_class coords = queue.poll();


            if (area.get(coords.coord_X).get(coords.coord_Y) == 9)
                return coords.path_distance;


            // moving right
            if (coords.coord_Y + 1 < numColumns &&
                    coord_visited[coords.coord_X][coords.coord_Y + 1] == false) {
                queue.offer(new BFS_class(coords.coord_X, coords.coord_Y + 1, coords.path_distance + 1));
                coord_visited[coords.coord_X][coords.coord_Y + 1] = true;
            }


            // moving left
            if (coords.coord_Y - 1 >= 0 && coord_visited[coords.coord_X][coords.coord_Y - 1] == false) {
                queue.offer(new BFS_class(coords.coord_X, coords.coord_Y - 1, coords.path_distance + 1));
                coord_visited[coords.coord_X][coords.coord_Y - 1] = true;
            }


            // moving down
            if (coords.coord_X + 1 < numRows &&
                    coord_visited[coords.coord_X + 1][coords.coord_Y] == false) {
                queue.offer(new BFS_class(coords.coord_X + 1, coords.coord_Y, coords.path_distance + 1));
                coord_visited[coords.coord_X + 1][coords.coord_Y] = true;
            }

            // moving up
            if (coords.coord_X - 1 >= 0 &&
                    coord_visited[coords.coord_X - 1][coords.coord_Y] == false)
            {
                queue.offer(new BFS_class(coords.coord_X - 1, coords.coord_Y, coords.path_distance + 1));
                coord_visited[coords.coord_X - 1][coords.coord_Y] = true;
            }

        }
        return -1;
    }
}
