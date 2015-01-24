import org.junit.*;
import static org.junit.Assert.*;

import naval.Bateau;

public class BateauTest {	

    @Test
    public void createBateau() {
	Bateau petitBateau = new Bateau(10);
	assertNotNull("construction bateau ?", petitBateau);
    }
    
    @Test
    public void giveHitPoints() {
	Bateau Titanic = new Bateau(1024);
	assertEquals("HP correct ? ",Titanic.getSize(),1024);
    }

    @Test
    public void goodJobCaptain() {
	Bateau CostaCroisiere = new Bateau(1);
	assertFalse("Is it sunk ? ",CostaCroisiere.isSunk());
	CostaCroisiere.hit();
	assertTrue("Is it sunk now ? ",CostaCroisiere.isSunk());
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(BateauTest.class);
    }

}