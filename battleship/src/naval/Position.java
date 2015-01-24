package naval;

public class Position {

    private int x;
    
    private int y;

    /** Constructor of class Position
     *
     * @param Integers One for x-axis, one for y-axis
     */
    public Position(int x,int y) {
	this.x = x;
	this.y = y;
    }
    
    /** Getter for x-axis
     * @return x, an int for the x-axis coordinate.
     */
    public int getX() {
	return this.x;
    }
    
    /** Getter for y-axis
     * @return y, an int for the y-axis coordinate.
     */
    public int getY() {
	return this.y;
    }

    /** Predicate
     * Two Position are the same if they have the same x-axis and y-axis coordinates.
     * @return <code>true</code> if they are, <code>false</code> otherwise.
     */
    public boolean equals(Object o) {
	if (o instanceof Position) {
	    Position p = (Position) o;
	    return ((this.x == p.x) && (this.y == p.y));
	}
	return false;
    }

    public String toString() {
	return ("x : "+this.x+"\ny : "+this.y);
    }
}