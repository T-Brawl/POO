/**
 * Class Disque
 *
 *
 *
 * @author A. MOEVI
 */

package hanoi.util;

public class Disque {
    
    private final int size;

    /** Constructor of class Disque
     * @param n an integer representing the size of disk. The size is a positive number or -1 if the integer is invalid.
     */
    public Disque(int n){
	if (n > 0) {
	this.size = n;
	} else {
	    this.size = -1; }
    }

    /**
     * @return an integer, the size of a Disque
     */
    public int getSize() {
	return this.size;
    }

    public String toString() {
	return(""+this.size);
    }

}

    
