/**
 * Class Hanoi setting the Tower of Hanoi problem.
 *
 * This class is able to read player inputs and move discs acoording
 * those inputs and Hanoi rules. The player can also quit the game when
 * he wants, but his progress is not saved.
 *
 * @author A. MOEVI
 */

package hanoi;

import hanoi.util.*;
import io.*;

public class Hanoi {

    private Tour[] towers;
    
    private int number;

    /** Constructor of class Hanoi
     * Hanoi will create 3 Tour, 2 of them will be empty and the third one will contain the number of Disque set as parameter.
     * @param n an integer as the number of Disque initialised but also the capacity of the Tour.
     */
    public Hanoi(int n) {
	this.number = n;
	this.towers = new Tour[3];
	this.towers[2] = new Tour(n);
	this.towers[1] = new Tour(n);
	this.towers[0] = new Tour(n,n);
    }

    /** This method moves the top of a first Tour to the second Tour. 
     * @param from an integer as the number associated with the Tour the user wants to pop.
    * @param to an integer as the number associated with the Tour the user wants to push.
     */
    public void move(int from, int to) {
	if (!(this.towers[from].isEmpty()) && (this.towers[to].isEmpty() || this.towers[from].top().getSize() < this.towers[to].top().getSize())) {
	Disque tmp = this.towers[from].pop();
	this.towers[to].push(tmp);
	}
    }
	
    private void hiddensolve(int number, int start, int finish, int tmp) {
	if (number > 0)
                {
                        hiddensolve (number-1 , start, tmp , finish);
                        move(start, finish);
                        hiddensolve (number-1 , tmp , finish , start);
                }
    }
    /** Method based on the recursive algorithm solving the Tower of Hanoi problem.
     * When this method is invoked, the Tour 0 must be full and the Tour 1 and 2 must be empty to avoid any collision. 
     */
    public void solve() {
	hiddensolve(this.number,0,2,1);
    }

    private void print() {
	System.out.println("\nTower 1 :"+this.towers[0].toString()+"\n");
	System.out.println("Tower 2 :"+this.towers[1].toString()+"\n");
	System.out.println("Tower 3 :"+this.towers[2].toString()+"\n");
    }
    
    /** Main method, this is the Tower of Hanoi game.
     * @param i an integer as the number of Disque the user wants to play with. This number should be between 1 and 10.
     */
    public static void main(String[] args) {
	int i = Integer.parseInt(args[0]);
	if (i < 1) {System.out.println("\nThe argument ("+args[0]+") is invalid, it should be a positive integer.\n"); return;}
	if (i > 10) {System.out.println("\nWell, "+args[0]+" is too much to handle. It would take around "+Math.pow(2.0, (double) i)+" moves.\nYou should try a smaller integer (between 1 and 10).\n"); return;}
	Hanoi game = new Hanoi(i);
	HanoiInput inputs = new HanoiInput();
	while (!(game.towers[2].isFull())) {
		game.print();
		inputs.readInput();
		if (inputs.isDeplacement()) {game.move(inputs.getDe(),inputs.getVers());} else {return;}
	}
	game.print();
	if (i == 10) System.out.println("Wow, incredible !"); else System.out.println("Congratulations");
	}
}
