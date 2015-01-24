package pfc.strategie;

import pfc.*;
import java.util.Random;

public class StrategieAleatoire implements Strategie {

    private Random dice;

    public StrategieAleatoire() {
	Random tmp = new Random();
	this.dice = tmp;
    }

    /**
     * @return a <code>Coup</code>, randomly picked.
     */
    public Coup choixCoup() {
	int val = this.dice.nextInt(3);
	return Coup.values()[val];
    }


}
