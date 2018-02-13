import java.util.HashMap;
import java.util.Map;

class Logger {
    Map<String,Integer> mp;
    /** Initialize your data structure here. */
    public Logger() {
        mp=new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(mp.containsKey(message)){
            if(timestamp-mp.get(message)>9){
                mp.put(message,timestamp);
                return true;
            }else {
                return false;
            }
        }
        mp.put(message,timestamp);
        return true;
    }
}

/*
Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
 */