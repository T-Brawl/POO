/**
 * Class Tour.
 *
 * In Hanoi game, a Tour can hold a certain amount of Disque, hence it can be full or empty.
 * According the number of Disque currently held by the Tour, the user can see the top of the Tour, pop ou push a valid Disque.
 * 
 * @author A. MOEVI
 */

package hanoi.util;

import hanoi.util.Disque;

public class Tour {

    private Disque[] discs;

    private int capacity;

    private int number;

    /** Constructor of class Tour
     * @param c an integer as the capacity of the Tour
     * @param n an integer as well for the number of Disque initialised
     * Those Disque are set this way: the top on the Tour has a size of 1, the bottom one with a size of <code>n</code> (or <code>c</code> if <code>n</code> is stricly greater than <code>c</code>)
     */
    public Tour(int c,int n) {
	this.capacity = c;
	if (n > c) {this.number = c;} else {this.number = n;}
	this.discs = new Disque[c];
	int j = 0;
	int i = this.number;
	while (i > 0) {
	     this.discs[j++] = new Disque(i--);;
	}
    }
    
    /** Constructor of class Tour
     * @param c an integer as the capacity of the Tour.
     * This Tour will contain no Disque, hence will be empty.
     */
    public Tour(int c) {
	this.capacity = c;
	this.discs = new Disque[c];
	this.number = 0;
    }

    /** Predicate
     * @return <code>true</code> if this Tour is full (cannot hold more Disque), <code>false</code> otherwise.
     */
    public boolean isFull() {
	return(this.number == this.capacity) ;
    }

    /** Predicate
     * @return <code>true</code> if this Tour is empty (holds no Disque at all), <code>false</code> otherwise.
     */
    public boolean isEmpty(){
	return(this.number == 0);
    }

    /** Method returning the top of this Tour.
     * @return a Disque, the Disque at the top of the Tour.
     */
    public Disque top() {
	if (this.isEmpty()) {
	    return null;
	}
	return(this.discs[this.number - 1]);
    }

    /** Method push following the example of stack. The method does not push an invalid Disque (negative size) or push a bigger Disque than the current top.
     * @param d a Disque
     */
    public void push(Disque d){
	if (!(this.isFull()) && !(d == null)) {
	    if (this.isEmpty() || ((this.top().getSize() > d.getSize()) && (d.getSize() > 0))) {
		this.discs[this.number++] = d;
		    }
	}
    }
    
    /** Method pop in the manner of stack.
     * @return a Disque, <code>null</code> if the Tour is empty.
     */
    public Disque pop() {
	if (!(this.isEmpty())) {
	    Disque d = this.discs[this.number - 1];
	    this.discs[this.number - 1] = null;
	    this.number--;
	    return d;
	}
	return null;
    }
	
    public String toString(){
	String res = new String("");
	for (int i = this.number - 1; i > -1 ; i--) {
	    res += "\n"+this.discs[i].toString();
	}
	return res;
    }
};


