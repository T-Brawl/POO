import org.junit.*;
import static org.junit.Assert.*;

import naval.Position;

public class PositionTest {	

    @Test
    public void createPosition() {
	Position place = new Position(3,14159);
	assertNotNull("construction bateau ?", place);
    }
    
    @Test
    public void giveCoord() {
	Position spot = new Position(2048,4096);
	assertEquals("correct x ? ",spot.getX(),2048);
	assertEquals("correct y ? ",spot.getY(),4096);
    }

    @Test
    public void equality() {
	Position pos = new Position(42,69);
	Position pos3 = new Position(42,69);
	assertEquals("Is it the same ? ",pos,pos3);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(PositionTest.class);
    }

}