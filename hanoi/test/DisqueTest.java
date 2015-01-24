import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disque;

public class DisqueTest {

    @Test
    public void returnSize() {
		Disque CompactDisk = new Disque(128);
		assertEquals("Correct size ? ",CompactDisk.getSize(),128);
		Disque DVD = new Disque(0);
		assertEquals("Correct size ? ",DVD.getSize(),-1);
    }

    @Test
    public void compareString() {
		Disque CompactDisk = new Disque(128);
		assertEquals("Correct size ? ",CompactDisk.toString(),"128");
    }
    
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DisqueTest.class);
    }
}
