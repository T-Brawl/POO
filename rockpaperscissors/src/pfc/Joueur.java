/**
 * Class implementing a player for Rock, Papers, Scissors.
 *
 * A <code>Joueur</code> will a play a <code>Coup</code> according his <code>Strategie</code>. He also has a name (<code>String</code>) and a score, zero when he starts playing then evolving according the <code>Jeu</code>
 *
 *
 */

package pfc;

import pfc.*;
import pfc.strategie.*;

public class Joueur {

    private int score;

    private String nom;

    private Strategie strategie;

    /** 
     * A <code>Joueur</code> always have his score at zero. This score will evolve following what happened in a <code>Jeu</code>.
     * @param nom a <code>String</code> for the player name.
     * @param s a <code>Strategie</code> for the player.
     */
    public Joueur(String nom, Strategie s){
	this.score = 0;
	this.nom = nom;
	this.strategie = s;
    }

    /** 
     * @return a <code>Coup</code> according the player <code>Strategie</code>.
     */
    public Coup choisirCoup() {
	return this.strategie.choixCoup();
    }

    /**
     * @param i an integer. <code>i</code> could be any integer but it's recommend to only use zero or postive numbers.
     */
    public void ajouterPoints(int i){
	this.score += i;
    }

    /**
     * @return the score, an integer. It follows the rules setting on a <code>Jeu</code>. It has to be zero or a positive number.
     */
    public int getScore() {
	return this.score;
    }

    /**
     * @return the name of the <code>Joueur</code> as a <code>String</code>.
     */
    public String getName() {
	return this.nom;
    }

    /**
     * @return a <code>String</code> with the name and the current score. The score has to be positive or zero.
     */
    public String toString() {
	if (this.score >= 2)
		{return("Score de "+this.nom+" : "+this.score+" points.");}
	else
		{if (this.score == 1) 
			{return("Score de "+this.nom+" : 1 point.");}

		else
			{return("Score de "+this.nom+" : Zéro pointé.");}
		}
    }
}
