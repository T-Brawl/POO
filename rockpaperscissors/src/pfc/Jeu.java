/**
 * Class implementing a Rock, Papers, Scissors game with two players.
 *
 * To play, the two <code>Joueur</code> play several <code>Coup</code>
 * follwing their own </code>Strategie</code>. 
 *
 * By default, a <code>Joueur</code> ignore what the other <code>Joueur</code> has played. But the second <code>Joueur</code> can cheat and win/lose/get the tie.
 */


package pfc;

import pfc.*;
import pfc.util.*;
import pfc.strategie.*;

public class Jeu {

    private int nbTours;

    private Joueur j1;

    private Joueur j2;

    /** Constructor of class Jeu
     * @param j1 an instance of class <code>Joueur</code>, representing a player
     * @param j2 a <code>Joueur</code> as well
     * @param nb an integer as the number of rounds. <code>nb</code> should be positive (>= 1)
     */
    public Jeu(Joueur j1, Joueur j2, int nb) {
	this.nbTours = nb;
	this.j1 = j1;
	this.j2 = j2;
    }


    /** Plays a round
     * @param cheat a <code>String</code>. By default, the two <code>Joueur</code> play at the same time. But the cheat mode can be activated by <code>cheat</code>.<br/> 
     * If <code>cheat</code> is <code>"gagner"</code>, the second <code>Joueur</code> will pick a <code>Coup</code> and retry if that <code>Coup</code> doesn't make him win.<br/>
     * Same thing for <code>"perdre"</code> and <code>"neutre"</code>, the second <code>Joueur</code> will respectively lose and get the draw.<br/>
      * With cheat mode, the strategy <b>must</b> generate the three different <code>Coup</code> possible or the <code>Jeu</code> can be stuck into an endless loop. It's highly recommended to use <code>pfc.strategie.StrategiePFC</code><br/><br/>
     * After picking <code>Coup</code>, the score of two <code>Joueur</code> will be updated according the method <code>pfc.Coup.compareCoup</code>.
     */
    public void jouerUnTour(String cheat) {
	if (this.nbTours == 1) {System.out.println("DERNIER TOUR !!!!");}
	Coup c1 = this.j1.choisirCoup();
	Coup c2 = this.j2.choisirCoup();
	int res = c1.compareCoup(c2);
	if(cheat.equals("gagner")) {
	    while (res != -1) {
		c2 = this.j2.choisirCoup();
		res = c1.compareCoup(c2);
	    }
	}
	if(cheat.equals("perdre")){
	    while (res != 1) {
		c2 = this.j2.choisirCoup();
		res = c1.compareCoup(c2);
	    }
	} 
	if(cheat.equals("neutre")){
	    while (res != 0) {
		c2 = this.j2.choisirCoup();
		res = c1.compareCoup(c2);
	    }
	}
	switch(res) {
	case 0 : this.j1.ajouterPoints(1);this.j2.ajouterPoints(1);System.out.println("EGALITE ! 1 point chacun !\n");break;
	case 1 : this.j1.ajouterPoints(2);System.out.println(c1+" bat "+c2+". 2 points pour "+this.j1.getName()+".\n");break;
	case -1 : this.j2.ajouterPoints(2);System.out.println(c2+" bat "+c1+". 2 points pour "+this.j2.getName()+".\n");break;
	default:  this.j1.ajouterPoints(0);this.j2.ajouterPoints(0);break;
	}
	this.nbTours--;
    }

    /** Predicate
     * @return <code>true</code> if the game is over (i.e. the attribute <code>nbTours</code> is zero or less), <code>false</code> otherwise
     */
    public boolean estFini() {
	return (nbTours <= 0);
    }

    /** Determinates the winner of the <code>Jeu</code>
     * @return <code>null</code> if the game is a tie or a draw, the <code>Joueur</code> with the greatest score otherwise.
     */
    public Joueur getGagnant() {
	if (this.j1.getScore() == this.j2.getScore()) {return null;}
	if (this.j1.getScore() > this.j2.getScore()) {return this.j1;} else {return this.j2;}
    }
    
    /** The actual Rock, Papers, Scissors game
     * Two plyers (created with objects of <code>Joueur</code> class) play this game.<br/> 
     * Player 1 is the user interacting with his inputs (<code>pfc.util.Input</code>), 
     * player 2 is the computer playing with a certain <code>Strategie</code>. This last is chosen by the user.
     */
    public static void main(String args[]) {
	int nb = -1;
	boolean chosi = false;
	String triche = "";
	Strategie strat = null;
	Joueur computer = null; 
	//Nom du joueur
	System.out.println("> Entrez votre nom de joueur. ");
	String nomJoueur = Input.readString();
	Strategie input = new StrategieInput();
	Joueur user = new Joueur(nomJoueur,input);
	//Nombre de tours qui doit être un nombre (readInt) ET positif (condition de sortie de boucle)
	System.out.println("> Entrez le nombre de tours. ");
	while (nb == -1) {
	    try {
		int tmp = Input.readInt();
		if (tmp > 0) 
		    {nb = tmp;} 
		else {System.out.println("> Ce n'est pas une entier valable.\n  Le nombre doit être positif pour lancer le jeu.");}
		
	    }
	    catch (java.io.IOException e) {
		System.out.println("> Ce n'est pas une entrée valable. Entrez un entier.");}
	}
	//Les différents adversaires et leurs stratégies
	while(!chosi) {
	    System.out.println("> Choissisez votre adversaire selon sa stratégie.");
	    System.out.println("  Tapez en majuscule le nom de la stratégie.\n ");
	    System.out.println("  Kappa \t: stratégie ALEATOIRE");
	    System.out.println("  Ygritte \t: stratégie PIERRE");
	    System.out.println("  Frank Gore \t: stratégie FEUILLE");
	    System.out.println("  Toad \t\t: stratégie CISEAUX");
	    System.out.println("  Alex Kidd\t: stratégie SEQUENCE (à vous trouver laquelle...)");
	    System.out.println("  Bad Luck Brian: stratégie PERDANTE");
	    System.out.println("  Giygas \t: stratégie GAGNANTE");
	    System.out.println("  Ponce de Leon\t: stratégie NEUTRE\n");
	    String chaineLue = Input.readString();
	    switch(chaineLue) {
	    case "ALEATOIRE" : 
		strat = new StrategieAleatoire();
		computer = new Joueur("Kappa",strat); 
		chosi = true; 
		break;
	    case "PIERRE" : 
		strat = new StrategieConstante(Coup.PIERRE);
		computer = new Joueur("Ygritte",strat); 
		chosi = true; 
		break;
	    case "FEUILLE" : 
		strat = new StrategieConstante(Coup.FEUILLE);
		computer = new Joueur("Frank Gore",strat); 
		chosi = true; 
		break;
	    case "CISEAUX" : 
		strat = new StrategieConstante(Coup.CISEAUX);
		computer = new Joueur("Toad",strat); 
		chosi = true; 
		break;
	    case "SEQUENCE" : 
		Coup[] tab = {Coup.PIERRE, Coup.CISEAUX, Coup.CISEAUX, Coup.PIERRE, Coup.FEUILLE};
		strat = new StrategieSequentielle(tab);
		computer = new Joueur("Alex Kidd",strat); 
		chosi = true; 
		break;
	    case "PERDANTE" : 
		strat = new StrategiePFC();
		computer = new Joueur("Bad Luck Brian",strat); 
		triche = "perdre";
		chosi = true; 
		break;
	    case "GAGNANTE" : 
		strat = new StrategiePFC();
		computer = new Joueur("Giygas",strat); 
		triche = "gagner";
		chosi = true; 
		break;
	    case "NEUTRE" : 
		strat = new StrategiePFC();
		computer = new Joueur("Ponce de Leon",strat); 
		triche = "neutre";
		chosi = true; 
		break;
	    default :break;
	    }
	}
	//Le début du jeu
	System.out.println("> C'est parti !\n> Pour jouer un coup, tapez PIERRE, FEUILLE ou CISEAUX.\n(P, F ou C fonctionne aussi)\n");
	Jeu game = new Jeu(user, computer, nb);
	while (!(game.estFini())) {
	    game.jouerUnTour(triche);
	}
	//Impression des scores finaux
	System.out.println("\n"+user.toString());
	System.out.println(computer.toString()+"\n");
	//Qui est le vainqueur
	Joueur winner = game.getGagnant();
	if (winner == null)
	    {System.out.println("Pas de gagnant...\n"); return;}
	else
	    {if (winner.getScore() == user.getScore())
		    {System.out.println("A WINRAR IS YOU !\n"); return;}
		else
		    {System.out.println("YOU LOSE !\n"); return;}
	    }
    }
}
