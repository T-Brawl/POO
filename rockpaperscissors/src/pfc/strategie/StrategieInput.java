package pfc.strategie;

import pfc.*;
import pfc.util.*;

public class StrategieInput implements Strategie {

    /**
     * @return a <code>Coup</code> following the user inputs. Those inputs have to be correct or it will be asked to type an other time.
     */
    public Coup choixCoup() {
	String choix = Input.readString();
	while(1 == 1) {
	    if (choix.equals("PIERRE") || choix.equals("P") || choix.equals("Pierre") || choix.equals("pierre") || choix.equals("p") ) {return Coup.PIERRE;}
	    if (choix.equals("FEUILLE") || choix.equals("F") || choix.equals("Feuille")  || choix.equals("f") || choix.equals("feuille")) {return Coup.FEUILLE;}
	    if (choix.equals("CISEAUX") || choix.equals("C") || choix.equals("ciseaux") || choix.equals("c") || choix.equals("Ciseaux")) {return Coup.CISEAUX;}
	    System.out.println("  ?");choix = Input.readString();}
    }


}
