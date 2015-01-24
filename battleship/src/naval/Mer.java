/** Class Mer, similar to a board for the battleship game
 *
 *
 *
 *
 */

package naval;

import naval.*;
import naval.direction.*;

public class Mer {
 
    private Case[][] plateau;

    private int hpglobal;

    /** Constructor of class Mer.
     * @param int Two integers, one for the length, one for the width.
     */
    public Mer(int longueur, int largeur) {
	this.hpglobal = 0;
	this.plateau = new Case [longueur][largeur];
	for(int i = 0;i < longueur;i++) {
	    for(int j = 0;j < largeur; j++) {
		this.plateau[i][j] = new Case();
	    }
	}
    }

    /** This method sets a Bateau on the Mer but raises an exception if it can't
     * @param b a Bateau, this Bateau will be set on the Mer
     * @param p a Position, the first place the user wants to set the Bateau <code>b</code>
     * @param d a Direction
     * @throws IllegalStateException if the Bateau would be set out of Mer 
     * @throws IllegalStateException some place is already taken by another Bateau.
     */
    public void poseBateau(Bateau b, Position p, Direction d) throws IllegalStateException {
	Bateau bateau = null;
	Position pos = p;
	for (int i = 0; i < b.getSize(); i++) {
	    try {
		bateau = this.plateau[pos.getX()][pos.getY()].getBateau();
	    } catch (ArrayIndexOutOfBoundsException e) {throw new IllegalStateException("Out of sea.");}
	    if (bateau != null) {throw new IllegalStateException("Spot is full.");}
	    pos = d.positionSuivante(pos);
	}
	pos = p;
	for (int j = 0; j < b.getSize(); j++) {
	    this.plateau[pos.getX()][pos.getY()].setBateau(b);
	    pos = d.positionSuivante(pos);
	}
	this.hpglobal += b.getSize();
    }


    /**
     * @param p a Position
     * @return a Reponse, according the fact there is a Bateau at this Position or not, and the number of hit points of the Bateau if there is one.
     */
    public Reponse vise(Position p) {
	Case spot = this.plateau[p.getX()][p.getY()];
	if (spot.aEteVisee()) 
	    {return Reponse.DANS_LEAU;}
	else
	    {Bateau boat = spot.getBateau();
		if (boat == null) 
		    {spot.visee();
			return Reponse.DANS_LEAU;}
		else
		    {spot.visee();
			boat.hit();
			this.hpglobal--;
			if (boat.isSunk()) 
			    {return Reponse.COULE;}
			else
			    {return Reponse.TOUCHE;}
		    }
	    }
    }

    /** Predicate
     * @return <code>true</code> if all the Bateau of the Mer are sunk,<code>false</code> otherwise.
     */
    public boolean estVide() {
	return (this.hpglobal == 0);
    }

    /** Prints the Mer on the standard output.
     * @param defenseur a boolean. <code>true</code> will print the Mer like the defender
     * i.e. with all the Position of the Mer and their actual content
     * (a Bateau hit, sunk or...water).
     * <code>false</code> will print the Mer with their content only on targeted Case, dots otherwise.
     */
    public void affichage(boolean defenseur) {
	String firstLine = "  ";
	for (int i = 0; i < this.plateau[0].length ; i++) {
	    firstLine += i+" ";
	}
	System.out.println(firstLine);
	for (int y = 0; y < this.plateau.length ; y++) {
	    String res = y+" ";
	    for (int x = 0; x < this.plateau[0].length ; x++) {
		res += this.plateau[x][y].getCaractere(defenseur)+" ";
	    }
	    System.out.println(res);
	}
    }
		    
}