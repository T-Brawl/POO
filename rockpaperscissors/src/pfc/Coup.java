package pfc;

public enum Coup {PIERRE, FEUILLE, CISEAUX;
    
    /** Compare two <code>Coup</code>
     * @param c a <code>Coup</code>
     * @return an integer following this rules :
     * 0 for a tie or draw, <code>this</code> and <code>c</code> are the same, 
     * 1 when <code>this</code> beat <code>c</code>,
     * -1 when <code>this</code> is beaten by <code>c</code>. 
     */
    public int compareCoup(Coup c) {
	if (this == c) {return 0;}
	if (
	    ( (this == PIERRE) && (c == CISEAUX) ) || 
	    ( (this == CISEAUX) && (c == FEUILLE) ) || 
	    ( (this == FEUILLE) && (c == PIERRE) ) 
	    ) {return 1;} else {return -1;}
    }

}
