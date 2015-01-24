package naval;

/** Class Bateau setting the boats and their properties 
 * for a battleship game
 *
 * @author A. MOEVI
 */
public class Bateau {

    private final int size;

    private int hp;

    /** Constructor of class Bateau
     * This methods creates a Bateau. That Bateau is defined by its size and its hit points. A new Bateau has its hit points to the maximum, i.e. equal to Bateau size.
     * @param i that integer
     */
    public Bateau(int i) {
	this.size = i;
	this.hp = i;
    }

    /**
     * @return an integer, this size.
     */
    public int getSize() {
	return this.size;
    }

    /** Predicate
     * A Bateau is sunk is it doesn't have hit points anymore.
     * @return <code>true</code> if the Bateau is actually sunk, <code>false</code> otherwise.
     */
    public boolean isSunk() {
	return (this.hp <= 0);
    }

    /** 
     * For a Bateau, being hit is having one less hit point than before.
     * If a Bateau has a positive number of hit points or zero.
     */
    public void hit() {
	if (this.hp > 0) {this.hp--;}
    }

}