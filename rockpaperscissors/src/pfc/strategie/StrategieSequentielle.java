package pfc.strategie;

import pfc.*;

public class StrategieSequentielle implements Strategie {

    private Coup[] coups;
    
    private int indice;

    public StrategieSequentielle(Coup[] tab){
	this.coups = tab;
	this.indice = 0;
    }

    public Coup choixCoup() {
	return this.coups[(this.indice++)%(this.coups.length)];
    }


}
