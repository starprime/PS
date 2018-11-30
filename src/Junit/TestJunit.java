package Junit;

/**
 * Created by star on 11/20/18.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit {
    @Test
    public void testSetup() {
        String str= "I am done with Junit setup";
        assertEquals("I am done with Junit setup",str);
    }
}