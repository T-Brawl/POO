import org.junit.*;
import static org.junit.Assert.*;

import naval.*;

public class CaseTest {	

    @Test
    public void createCaseAndReturn() {
	Bateau petitBateau = new Bateau(3);
	Case firstCase = new Case();
	assertNotNull("construction case ?", firstCase);
	firstCase.setBateau(petitBateau);
	assertNotNull("case is still okay ?", firstCase);
	assertNotNull("what about the boat ?", firstCase.getBateau());
	assertEquals("Is it correct ?",firstCase.getBateau().getSize(),petitBateau.getSize(),3);
    }
    


    @Test
    public void booltest() {
	Case tralse = new Case();
	assertFalse("Should be false... ",tralse.aEteVisee());
	tralse.visee();
	assertTrue("Should be true... ",tralse.aEteVisee());
    }


    @Test
    public void motherOfChar() {
	Bateau flyingDutchmen = new Bateau(16);
	Case teemoleon = new Case();
	teemoleon.setBateau(flyingDutchmen);
	assertEquals("Is it the good char ? ",teemoleon.getCaractere(true),'B');
	assertEquals("Is it the good char again ? ",teemoleon.getCaractere(false),'.');
	teemoleon.visee();
	assertEquals("Is it the good char with that boat ? ",teemoleon.getCaractere(true),'*');
	assertEquals("Is it the good char one more time ? ",teemoleon.getCaractere(false),'*');
    }


    @Test
    public void empty() {
	Case empty = new Case();
	assertEquals("Defense, not targeted ",empty.getCaractere(true),'~');
	assertEquals("Offense, not targeted (yet) ",empty.getCaractere(false),'.');
	empty.visee();
	assertEquals("Defense, targeted ",empty.getCaractere(true),'~');
	assertEquals("Offense, targeted ",empty.getCaractere(false),'~');
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(CaseTest.class);
    }

}