/**
 * <code>StrategiePFC</code> is similar to <code>StrategieSequentille</code> but with <code>PFC<code>, the user cannot decide what the pattern is.
 *
 * Using <code>StrategiePFC</code> is the guarantee the <code>Joueur</code> will play the three different <code>Coup</code>.
 */

package pfc.strategie;

import pfc.*;

public class StrategiePFC implements Strategie {

    public int indice;

    public StrategiePFC() {
	this.indice = 0;
    }

    /** Return a <code>Coup</code>
     * @return a <code>Coup</code> following this basic loop : <code>Coup.PIERRE</code>, <code>Coup.FEUILLE</code> and <code>Coup.CISEAUX</code>.
     */
    public Coup choixCoup() {
	return Coup.values()[(this.indice++)%3];
    }


}
