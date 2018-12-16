// Add standard Java imports as needed

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

//class UnionFind {
//
//    static class Relation{
//        String pare;
//        String child;
//
//        public Relation(String pare,String child){
//            this.pare = pare;
//            this.child = child;
//        }
//    }
//
//    static HashMap<Relation, List<Relation>> parent = new HashMap<>();;
//
//    public UnionFind() {
//        parent = new HashMap<>();
//    }
//
//    static public void add(String n, String p) {
//        List<Relation> tmp = parent.get(n);
//        tmp.add(new Relation(n,p));
//
//        parent.put(n, tmp);
//    }
//
//    static public boolean contains(String n) {
//        return parent.containsKey(n);
//    }
//
//    static public void union(String n1, String n2) {
//        String p1 = compressFind(n1);
//        String p2 = compressFind(n2);
//        if (p1 != p2) {
//            add(p1, p2);
//        }
//    }
//
//    static public String compressFind(String n) {
//            String parent;
//          for(Map.Entry<Relation, List<Relation>> entry: parent.entrySet()){
//            if(entry.getKey().child.equals(n)){
//                parent = entry.getKey().pare;
//            }
//          }
//
//
////        String p = parent.get(n);
////        while (p != parent.get(p)) {
////            p = parent.get(p);
////        }
////        String tmp = null;
////        String father = parent.get(n);
////        while (father != parent.get(father)) {
////            tmp = parent.get(father);
////            parent.put(father, p);
////            father = tmp;
////        }
////        parent.put(n, p);
////        return p;
//    }
//}

class Solution7 {

    static HashMap<String, HashSet<String>> map = new HashMap<>();

    private static void addLink(String id1, String id2) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> set = map.getOrDefault(id1, new HashSet<>());
        set.add(id2);
        if (!map.containsKey(id1))
            map.put(id1, set);
        System.out.println(" set " + set);
        Queue<String> q = new LinkedList<>();
        q.addAll(set);

        while (!q.isEmpty()) {
            String next = q.poll();
            if (!visited.contains(next)) {
                if (map.containsKey(next)) {
                    Set<String> temp = map.get(next);
                    map.get(next).add(id1);
                    q.addAll(temp);
                }
                visited.add(next);
            }
        }

        set = map.getOrDefault(id2, new HashSet<>());
        set.add(id1);
        if (!map.containsKey(id2))
            map.put(id2, set);
        System.out.println(" set " + set);
        q.clear();
        q = new LinkedList<>();
        q.addAll(set);
        while (!q.isEmpty()) {
            String next = q.poll();
            if (!visited.contains(next)) {
                if (map.containsKey(next)) {
                    Set<String> temp = map.get(next);
                    map.get(next).add(id2);
                    q.addAll(temp);
                }
                visited.add(next);
            }
        }
    }

    private static boolean isLinked(String id1, String id2) {
        System.out.println("Enter isLInk");
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(id1);
        visited.add(id1);
        while (!q.isEmpty()) {
            String key = q.poll();

            if (map.containsKey(key)) {
                Set<String> s = map.get(key);
                Iterator<String> it = s.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.equals(id2)) {
                        return true;
                    }
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            } else {
                return false;
            }
        }
        System.out.println("Exit isLInk");
        return false;
    }

    private static void removeId(String id) {
        System.out.println("Enter remove");
        Queue<String> q = new LinkedList<>();
        if (map.containsKey(id)) {
            Set<String> s = map.get(id);
            Iterator<String> it = s.iterator();
            while (it.hasNext()) {
                q.offer(it.next());
            }
            while (!q.isEmpty()) {
                Set<String> set = map.get(q.poll());
                set.remove(id);
            }
            map.remove(id);
        }
        System.out.println("Exit remove");
    }

    // Boilerplate below to emulate successive API calls.
    // Do not change
    public static boolean[] solution(long[] operationsToPerform, String[] firstArgs, String[] secondArgs) {
        boolean[] isLinkedResults = new boolean[operationsToPerform.length];

        for (int opNum = 0; opNum < operationsToPerform.length; opNum++) {
            isLinkedResults[opNum] = callOperation(operationsToPerform[opNum], firstArgs[opNum], secondArgs[opNum]);
        }

        return isLinkedResults;
    }

    private static boolean callOperation(long operationType, String firstArg, String secondArg) {
        if (operationType == 0) {
            addLink(firstArg, secondArg);
        } else if (operationType == 1) {
            return isLinked(firstArg, secondArg);
        } else if (operationType == 2) {
            removeId(firstArg);
        } else {
            throw new RuntimeException("Unrecognized operation type.");
        }

        return true;
    }

    static int findMatchingPair(String S) {
        char[] str = S.toCharArray();

        for(int i = str.length-1;i>0;i--) {
            char c = str[i];
            if (Character.isLowerCase(c)) {
                if (Character.toLowerCase(str[i - 1]) == str[i] && Character.isUpperCase(str[i - 1])) {
                    return i - 1;
                }
            }
        }
        return -1;
    }
    static void somethingTest(){
        Map<Integer,Integer> mp = new HashMap<>();
        for(Map.Entry<Integer,Integer> enteySet :mp.entrySet()){
            int i = enteySet.getKey();
        }
        String s = "asdfas";
    }
}

