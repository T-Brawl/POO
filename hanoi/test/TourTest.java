import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Tour;
import hanoi.util.Disque;

public class TourTest {

    @Test
    public void constructor() {
		Tour Babel = new Tour(5,3);
		Tour ZugZug = new Tour(64,1024);
		Tour Candlestick = new Tour(10);
		assertNotNull("Is object of class Tour okay ? ",Babel);
		assertNotNull("Is object of class Tour okay ? ",ZugZug);
		assertNotNull("Is object of class Tour okay ? ",Candlestick);
    }

   
    @Test
    public void pushandtop() {
		Tour t = new Tour(10,5);
		Disque DVD = new Disque(3);
		Disque CD = new Disque(-256);
		Qualcomm.push(DVD);
		assertEquals("Is it the correct top ? ",(t.top()).getSize(),1);
		Qualcomm.push(CD);
		assertEquals("Is it the correct top ('negative' Disque) ? ",(t.top()).getSize(),1);
    }

    @Test
    public void popandtop() {
		Tour Tower = new Tour(1,1);
		assertEquals("Is it the correct top ? ",(Tower.top()).getSize(),1);
		Tower.pop();
		assertNull("Is it empty ? ",(Tower.top()));
		assertTrue("Is it really empty ? ",Tower.isEmpty());
    }

    @Test
    public void pushpopandtop() {
		Tour Stick = new Tour(2,1);
		assertFalse("Is it full ? ",Stick.isFull());
		Disque Circle = Stick.pop();
		Disque BiggerCircle = new Disque(1024);
		Disque BiggestCircle = new Disque(65536);
		Disque Wrong = new Disque(0);
		Disque Empty = null;
		assertNull("Is it empty ? ",(Stick.top()));
		Stick.push(BiggestCircle);
		Stick.push(Circle);
		assertTrue("Is it full this time ? ",Stick.isFull());
		assertEquals("Is this the correct top ? ",Stick.top().getSize(),1);
		Stick.pop();
		Stick.push(Wrong);
		assertEquals("Is this the correct top again ? ",Stick.top().getSize(),65536);
		Stick.push(BiggerCircle);
		assertEquals("Is this the correct top this time ? ",Stick.top().getSize(),1024);
		Stick.push(Circle);
		assertEquals("Is this the correct one more time ? ",Stick.top().getSize(),1024);
		Stick.push(Empty);
		assertEquals("Is it fine with a null ? ",Stick.top().getSize(),1024);
    }

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TourTest.class);
    }
}

