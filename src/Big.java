import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Big {


    static int bestAverageGrades(String[][] scores) {
        class Guy {
            int count;
            int totalSum;

        }

        Map<String, Guy> m = new HashMap<String, Guy>();
        double d = Double.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (m.get(scores[i][0]) == null) {
                Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
                Guy guy = new Guy();
                guy.count = guy.count + 1;
                guy.totalSum = guy.totalSum + Integer.parseInt(scores[i][1]);


                m.put(scores[i][0], guy);
            } else {

                Guy guy = m.get(scores[i][0]);
                guy.count = guy.count + 1;
                guy.totalSum = guy.totalSum + Integer.parseInt(scores[i][1]);
                m.put(scores[i][0], guy);
            }
        }

        Set<String> keys = m.keySet();
        Iterator<String> itr = keys.iterator();
        int max = 0;
        Map<String, Integer> m2 = new HashMap<String, Integer>();
        while (itr.hasNext()) {
            String s = itr.next();
            Guy guy = m.get(s);
            int count = guy.count;
            int totalSum = guy.totalSum;
            int x = totalSum / count;
            if (max <= x) {
                max = x;
                m2.put(s, max);
            }
        }

        System.out.println(m2);

        return max;

    }
}