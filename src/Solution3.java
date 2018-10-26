/**
 * Created by star on 10/21/18.
 */
import java.util.List;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution3
{
    // METHOD SIGNATURE ENDS
    private class PointsOnMap{
        private int x;
        private int y;
        private int distance;
        public PointsOnMap(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }
    
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // to keep track of already visited items
        boolean[][] visited = new boolean[numRows][numColumns];
        // traverse through the matrix to set trenches as visited nodes
        // we dont need to visit them
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++)
            {

                if (lot.get(i).get(j) == 0){
                    visited[i][j] = true;
                    continue;
                }
            }
        }

        // starting point in the PointsOnMap
        PointsOnMap startingPoint = new PointsOnMap(0,0,0);

        // BFS is used here its best to find shortest path.
        Queue<PointsOnMap> queue = new LinkedList<>();

        queue.offer(startingPoint);

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            PointsOnMap pointsOnMap = queue.poll();

            // Destination found;
            if (lot.get(pointsOnMap.x).get(pointsOnMap.y) == 9)
                return pointsOnMap.distance;
            
            // moving left
            if (pointsOnMap.y - 1 >= 0 && visited[pointsOnMap.x][pointsOnMap.y - 1] == false) {
                queue.offer(new PointsOnMap(pointsOnMap.x, pointsOnMap.y - 1, pointsOnMap.distance + 1));
                visited[pointsOnMap.x][pointsOnMap.y - 1] = true;
            }

            // moving right
            if (pointsOnMap.y + 1 < numColumns &&
                    visited[pointsOnMap.x][pointsOnMap.y + 1] == false) {
                queue.offer(new PointsOnMap(pointsOnMap.x, pointsOnMap.y + 1, pointsOnMap.distance + 1));
                visited[pointsOnMap.x][pointsOnMap.y + 1] = true;
            }
            // moving up
            if (pointsOnMap.x - 1 >= 0 &&
                    visited[pointsOnMap.x - 1][pointsOnMap.y] == false) {
                queue.offer(new PointsOnMap(pointsOnMap.x - 1, pointsOnMap.y, pointsOnMap.distance + 1));
                visited[pointsOnMap.x - 1][pointsOnMap.y] = true;
            }

            // moving down
            if (pointsOnMap.x + 1 < numRows &&
                    visited[pointsOnMap.x + 1][pointsOnMap.y] == false) {
                queue.offer(new PointsOnMap(pointsOnMap.x + 1, pointsOnMap.y, pointsOnMap.distance + 1));
                visited[pointsOnMap.x + 1][pointsOnMap.y] = true;
            }
            
        }
        return -1;
    }
}