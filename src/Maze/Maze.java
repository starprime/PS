package Maze;

/**
 * Created by star on 11/22/18.
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Maze extends JPanel {

    private Room[][] rooms;// m x n matrix of rooms
    private ArrayList<Wall> walls; // List of walls
    private Random rand;// for random wall
    private int height;// height of matrix
    private int width;// width of matrix
    private int num;// incrementor
    private JoinRoom ds;// union paths

    // paint methods //
    private int x_cord; // x-axis rep
    private int y_cord;// y-axis rep
    private int roomSize;
    private int randomWall;

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        rooms = new Room[height][width];
        walls = new ArrayList<Wall>((height - 1) * (width - 1));
        generateRandomMaze();
        setPreferredSize(new Dimension(800, 700));
    }
    private void generateRandomMaze() {
        generateInitialRooms();// see next method
        ds = new JoinRoom(width * height);
        rand = new Random(); // here is the random room generator
        num = width * height;

        while (num > 1) {
            // when we pick a random wall we want to avoid the borders getting eliminated
            randomWall = rand.nextInt(walls.size());
            Wall temp = walls.get(randomWall);
            // we will pick two rooms randomly
            int roomA = temp.currentRoom.y + temp.currentRoom.x * width;
            int roomB = temp.nextRoom.y + temp.nextRoom.x * width;

            // check roomA and roomB to see if they are already members
            if (ds.find(roomA) != ds.find(roomB)) {
                walls.remove(randomWall);
                ds.unionRooms(ds.find(roomA), ds.find(roomB));
                temp.isGone = true;
                temp.currentRoom.adj.add(temp.nextRoom);
                temp.nextRoom.adj.add(temp.currentRoom);
                num--;
            }// end of if
        }// end of while
    }

    // name the room to display
    private int roomNumber = 0;
    /**
     * Sets the grid of rooms to be initially boxes
     * This is self explanitory, we are only creating an reverse L for all
     * The rooms and there is an L for the border
     */
    private void generateInitialRooms() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // create north walls
                rooms[i][j] = new Room(i, j);
                if (i == 0) {
                    rooms[i][j].north = new Wall(rooms[i][j]);
                } else {
                    rooms[i][j].north = new Wall(rooms[i - 1][j], rooms[i][j]);
                    walls.add(rooms[i][j].north);
                }
                if (i == height - 1) {
                    rooms[i][j].south = new Wall(rooms[i][j]);
                }
                if (j == 0) {
                    rooms[i][j].west = new Wall(rooms[i][j]);
                } else {
                    rooms[i][j].west = new Wall(rooms[i][j - 1], rooms[i][j]);
                    walls.add(rooms[i][j].west);
                }
                if (j == width - 1) {
                    rooms[i][j].east = new Wall(rooms[i][j]);
                }
                rooms[i][j].roomName = roomNumber++;// we will name the rooms
            }
        }
        // initalize entrance and exit
        rooms[0][0].west.isGone = true;// you can replace .west.isGone with .north.isGone
        // this is just saying the roomName for top left is 0
        rooms[0][0].roomName = 0;
        // we will remove the south wall of the last room
        rooms[height - 1][width - 1].south.isGone = true;
        // this is just saying the roomName for bottom right is the last element in the mxn room matrix
        rooms[height - 1][width - 1].roomName = (height * width);
    }

    public void paintComponent(Graphics g) {
        x_cord = 40;
        y_cord = 40;
        // could have taken height as well as width
        // just need something to base the roomsize
        roomSize = (width - x_cord) / width + 7;

        // temp variables used for painting
        int x = x_cord;
        int y = y_cord;

        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if (!(rooms[i][j].north.isGone)) {
                    g.drawLine(x, y, x + roomSize, y);
                }//end of north if
                // west wall not there draw the line
                if (rooms[i][j].west.isGone == false) {
                    g.drawLine(x, y, x, y + roomSize);
                }// end of west if
                if ((i == height - 1) && rooms[i][j].south.isGone == false) {
                    g.drawLine(x, y + roomSize, x + roomSize,
                            y + roomSize);
                }// end of south if
                if ((j == width - 1) && rooms[i][j].east.isGone == false) {
                    g.drawLine(x + roomSize, y, x + roomSize,
                            y + roomSize);
                }// end of east if
                x += roomSize;// change the horizontal
            }// end of inner for loop
            x = x_cord;
            y += roomSize;
        }// end of outer for loop
    }

    public static void main(String[] args) {
        // we will use the scanner for userInput
        Scanner userInput = new Scanner(System.in);
        int m, n;// these are variables for the size of maze (m x n)
        System.out.print("Enter the size of your maze: ");
        // store the input
        m = userInput.nextInt();
        n = userInput.nextInt();
        // use JFrame to put the created panel on
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.getContentPane().add(new Maze(m, n));
        frame.pack();
        frame.setVisible(true);
    }// end of main
}// END OF CLASS