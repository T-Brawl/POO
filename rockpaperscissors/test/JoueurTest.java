import org.junit.*;
import static org.junit.Assert.*;

import pfc.*;
import pfc.strategie.*;

public class JoueurTest {	

    @Test
    public void create() {
	Strategie strat = new StrategiePFC();
	Joueur player = new Joueur("Joueur 1",strat);
	assertNotNull("Is the constructor okay ?",player);
    }
    
    @Test
    public void gettersAndAddPoints() {
	Strategie strat = new StrategiePFC();
	Joueur player = new Joueur("Joueur 1",strat);
	assertEquals("It's the good score, right ?",player.getScore(),0);
	assertEquals("It's the right name ?",player.getName(),"Joueur 1");
	player.ajouterPoints(2);
	assertEquals("The score should be 2...",player.getScore(),2);
    }

    @Test
    public void pfc() {
	Strategie strat = new StrategiePFC();
	Joueur player1 = new Joueur("Joueur 1",strat);
	assertEquals("Rock !",player1.choisirCoup(),Coup.PIERRE);
	assertEquals("Paper !",player1.choisirCoup(),Coup.FEUILLE);
	assertEquals("Scissors !",player1.choisirCoup(),Coup.CISEAUX);
    }

    @Test
    public void sequel() {
	Coup[] tab = {Coup.PIERRE, Coup.CISEAUX, Coup.CISEAUX, Coup.PIERRE, Coup.FEUILLE};
	Strategie strat = new StrategieSequentielle(tab);
	Joueur player1 = new Joueur("Joueur 1",strat);
	assertEquals("Rock !",player1.choisirCoup(),Coup.PIERRE);
	assertEquals("Scissors !",player1.choisirCoup(),Coup.CISEAUX);
	assertEquals("Scissors !",player1.choisirCoup(),Coup.CISEAUX);
	assertEquals("Rock !",player1.choisirCoup(),Coup.PIERRE);
	assertEquals("Paper !",player1.choisirCoup(),Coup.FEUILLE);
	assertEquals("Once again : Rock !",player1.choisirCoup(),Coup.PIERRE);
	assertEquals("Once again : Scissors !",player1.choisirCoup(),Coup.CISEAUX);
	assertEquals("Once again : Scissors !",player1.choisirCoup(),Coup.CISEAUX);
	assertEquals("Once again : Rock !",player1.choisirCoup(),Coup.PIERRE);
	assertEquals("Once again : Paper !",player1.choisirCoup(),Coup.FEUILLE);
	assertEquals("One more time : Rock !",player1.choisirCoup(),Coup.PIERRE);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(JoueurTest.class);
    }

}
