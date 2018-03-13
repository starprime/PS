import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

class Events{
    int x;
    int y;
    PriorityQueue<Integer> prQu;
    public Events(int x, int y,PriorityQueue<Integer> qu){
        this.x = x;
        this.y = y;
        this.prQu = qu;
    }
}
public class viagogo {

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);

        int matsize = Integer.parseInt(scan.nextLine());
        int numOfEv = Integer.parseInt(scan.nextLine());
        int itr = numOfEv;

        // Create map for all the events where id is key and other are value
        // will use id extensively
        Map<Integer,Events> evnt = new HashMap<>();
        while(itr>0){
            String event = scan.nextLine();
            String [] brk = event.split(" ");

            //adding price in priority queue when we will pop we will get least value first
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 3;i<brk.length;i++){
                pq.add(Integer.parseInt(brk[i]));
            }
            Events ev = new Events(Integer.parseInt(brk[1]),Integer.parseInt(brk[2]),pq);
            evnt.put(Integer.parseInt(brk[0]),ev);
            itr--;
        }



        // read buyers location and store in array

        int noBuyers = Integer.parseInt(scan.nextLine());
        itr = noBuyers;int i=0;
        int [][] buyersPosi = new int[noBuyers][2];
        while (itr>0){
            String coord = scan.nextLine();
            String [] crds = coord.split(" ");
            buyersPosi[i][0] = Integer.parseInt(crds[0]);
            buyersPosi[i][1] = Integer.parseInt(crds[1]);
            i++;itr--;
        }

        // tree map will sort the distance key is (b/w buyer and event) and value will information of buyer and event

        // for all buyers calculate distance for all event
        for(int j=0;j<noBuyers;j++){
            TreeMap<Integer,List<Integer>> tmp = new TreeMap<>();
            for(Map.Entry<Integer, Events> ent : evnt.entrySet()){
                // distance between buyer and event
                int dist = manDist(ent.getValue().x,ent.getValue().y,buyersPosi[j][0],buyersPosi[j][1]);
                // if the distance already available
                // create a list with all buyer with similar distance
                if(tmp.containsKey(dist)){
                    List<Integer> li = tmp.get(dist);
                    li.add(ent.getKey());
                    tmp.put(dist,li);
                }else{
                    List<Integer> li = new ArrayList<>();
                    li.add(ent.getKey());
                    tmp.put(dist,li);
                }
            }
            System.out.println(tmp);

            int minD = Integer.MAX_VALUE;
            int minP=Integer.MAX_VALUE;
            int minID=Integer.MAX_VALUE;
            Map<Integer,Integer> ids = new HashMap<>();

            for(Map.Entry<Integer,List<Integer>> env : tmp.entrySet()){
                minD = Math.min(env.getKey(),minD);
                if(env.getKey()==minD){
                    List<Integer> evnList = env.getValue();
                    for(int evnId:evnList){
                        if(evnt.get(evnId).prQu.size()>0){
                            int eventPrice = evnt.get(evnId).prQu.peek();
                            minP = Math.min(minP,eventPrice);
                            //System.out.println(minP);
                            if( minP==eventPrice){
                                ids.put(evnId,eventPrice);
                            }
                        }else{
                            minP = Integer.MAX_VALUE;
                        }
                    }
                }
                if(ids.isEmpty()){minD=Integer.MAX_VALUE;}
                System.out.println();
            }
            for(Map.Entry<Integer,Integer> ent:ids.entrySet()){
                if(minP==ent.getValue()){
                    minID = Math.min(minID,ent.getKey());
                }
            }
            if(minID>numOfEv){
                System.out.println("-1 0");
            }else{
                minP= evnt.get(minID).prQu.poll();
                System.out.println(minID+" "+minP);
            }
        }

    }

    public static int manDist(int x1,int y1,int x2,int y2){
        return Math.abs(x1 - x2)+Math.abs(y1 - y2);
    }

}