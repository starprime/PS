import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Event {
    public int x;
    public int y;
    public PriorityQueue<Integer> prices;
    public int id;
    public Event(int id, int x, int y, PriorityQueue<Integer> prices) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.prices = prices;
    }
}

public class Solution_P {
    private static int md(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    private static Event minTicket(ArrayList<Event> events) {
        ArrayList<Event> spe = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < events.size(); i++) {
            if(events.get(i).prices.peek() < min) {
                spe = new ArrayList<>();
                spe.add(events.get(i));
                min = events.get(i).prices.peek();
            } else if(events.get(i).prices.peek() == min) {
                spe.add(events.get(i));
            }
        }
        min = Integer.MAX_VALUE;
        Event result = spe.get(0);
        if(spe.size() > 1) {
            for(Event e: spe) {
                if(e.id < min) {
                    result = e;
                    min = e.id;
                }
            }
        }
        return result;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());

        ArrayList<Event> events = new ArrayList<>();

        while(numberOfEvents > 0){
            String event = scan.nextLine();
            String[] temp = event.split(" ");
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i = 3; i < temp.length; i++)
                queue.add(Integer.parseInt(temp[i]));

            // TODO: you will need to parse and store the events
            Event eveli = new Event(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), queue) ;
            events.add(eveli);
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        int[][] buyers = new int[numberOfBuyers][2];
        int i = 0;
        while(numberOfBuyers > 0){
            String buyer = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            String[] temp = buyer.split(" ");
            buyers[i][0] = Integer.parseInt(temp[0]);
            buyers[i][1] = Integer.parseInt(temp[1]);
            i++;
            numberOfBuyers--;
        }
        numberOfBuyers = i;

        for(int k = 0; k < numberOfBuyers; i++) {
            TreeMap<Integer, ArrayList<Event>> map = new TreeMap<>();
            for(int j = 0; j < events.size(); j++) {
                int dist = md(buyers[k][0], buyers[k][1], events.get(j).x, events.get(j).y);
                if(map.containsKey(dist)) {
                    ArrayList<Event> list = map.get(dist);
                    list.add(events.get(j));
                    map.put(dist, list);
                } else {
                    ArrayList<Event> list = new ArrayList<>();
                    list.add(events.get(j));
                    map.put(dist, list);
                }
            }
            Iterator it = map.entrySet().iterator();
            Map.Entry mpen= (Map.Entry)it.next();

            ArrayList<Event> shortest = (ArrayList<Event>)mpen.getValue();

            Event minT = minTicket(shortest);
            for(int m = 0; i < events.size(); i++) {
                if(events.get(m).equals(minT)) {
                    if(events.get(m).prices.size() == 1) events.remove(m);
                    else events.get(m).prices.poll();
                }
            }
            System.out.println(minT.id + " " + minT.prices.peek());
        }
        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
        //System.out.println("2 50");
    }
}
