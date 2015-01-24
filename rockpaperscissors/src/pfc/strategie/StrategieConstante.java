package pfc.strategie;

import pfc.*;

public class StrategieConstante implements Strategie {

    private Coup coup;

    public StrategieConstante(Coup c){
	this.coup = c;
    }

    public Coup choixCoup() {
	return this.coup;
    }


}
