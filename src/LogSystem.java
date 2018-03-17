import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class LogSystem{

    Queue<Log> qu;

    class Log implements Comparable<Log>{
        int id;
        long timestamp;
        public Log(int id,long timestamp){
            this.id=id;
            this.timestamp=timestamp;
        }
        @Override
        public int compareTo(Log b) {
            if(timestamp>b.timestamp){
                return 1;
            }else if(timestamp<b.timestamp){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public LogSystem() {
        qu = new PriorityQueue<>();
    }

    public void put(int id, String timestamp) {
        long tmpstmp=strn2Long(timestamp);
        Log lg = new Log(id,tmpstmp);
        qu.add(lg);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> li=new ArrayList<>();

        return li;
    }

    public long strn2Long(String str){
        int ret=0;StringBuilder st=new StringBuilder();

        String []starr=str.split(":");
        for(String s:starr){
            st.append(s);
        }
        System.out.println(st.toString());
        return Long.parseLong(st.toString());
    }

    public String long2String(long val){
        return Long.toString(val);
    }

}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */