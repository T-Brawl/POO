import org.junit.*;
import static org.junit.Assert.*;

import pfc.*;
import pfc.strategie.*;

public class JeuTest {

    @Test
    public void create() {
	Strategie strat = new StrategiePFC();
	Joueur player1 = new Joueur("Joueur 1",strat);
	Joueur player2 = new Joueur("Joueur 2",strat);
	Jeu game = new Jeu(player1,player2,10);
	assertNotNull("Is the constructor okay ?",game);
    }

    @Test
    public void scores() {
	Strategie strat = new StrategiePFC();
	Joueur player1 = new Joueur("Joueur 1",strat);
	Joueur player2 = new Joueur("Joueur 2",strat);
	Jeu game = new Jeu(player1,player2,10);
	assertNull("Draw at the beginning !",game.getGagnant());
	player1.ajouterPoints(42);
	assertSame("Player 1 is leading !",game.getGagnant(),player1);
	player2.ajouterPoints(69);
	assertSame("Player 2 is leading now !",game.getGagnant(),player2);
	player1.ajouterPoints(27);
	assertNull("Draw at the end !",game.getGagnant());
    }

    @Test
    public void over() {
	Strategie strat1 = new StrategiePFC();
	Strategie strat2 = new StrategiePFC();
	Joueur player1 = new Joueur("Joueur 1",strat1);
	Joueur player2 = new Joueur("Joueur 2",strat2);
	Jeu game = new Jeu(player1,player2,3);
	assertNull("Draw at the beginning !",game.getGagnant());
	assertFalse("Over ?",game.estFini());
	game.jouerUnTour("");
	assertFalse("Done ?",game.estFini());
	game.jouerUnTour("");
	assertFalse("Game over now ?",game.estFini());
	game.jouerUnTour("");
	assertTrue("It should be done",game.estFini());
	game.jouerUnTour("");
	assertTrue("You went too far but that's alright",game.estFini());
	assertNull("Draw at the end !",game.getGagnant());
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(JeuTest.class);
    }

}
