package naval;


/** Classe permettant de modeliser les cases du jeu de bataille navale.
 * Une case peut contenir ou non un bateau et avoir ete visee ou non
 */
public class Case {
    private Bateau bateau;
    private boolean visee;

    /** cree une case sans bateau et jamais visee
     */
    public Case() {
        this.bateau = null;
        this.visee = false;
    }
    
    /** fournit le bateau present sur cette case (<code>null</code> si aucun)
     * @return le bateau present sur cette case (<code>null</code> si aucun)
     */
    public Bateau getBateau() {
        return this.bateau;
    }

    /** fixe le bateau sur cette case
     * @param bateau le bateau sur cette case
     */
    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    /** indique si cette case a deja ete visee ou non
     * @return <code>true</code> si et seulement si cette case a deja ete visee
     */
    public boolean aEteVisee() {
        return this.visee;
    }

    /** vise cette case
     */
    public void visee() {
        this.visee = true;
    }

    /** fournit un caractere dependant du statut de la case : vide,
     * touche, avec un bateau ou inconnu
     * @return un cararactere dependant du statut de la case : vide <code>~</code>,
     * touche <code>*</code>, avec un bateau <code>B</code> ou inconnu<code>.</code>
     */
    public char getCaractere(boolean defenseur) {
        if (defenseur) {
	    if (this.bateau == null) {return VIDE;} 
	    else 
		{if (this.visee) { return TOUCHE;} 
		    else   {return BATEAU;}
		}
	} else 
	    { if (this.visee) {
		    if (this.bateau == null) {return VIDE;} else {return TOUCHE;} 
		} else {return INCONNU;}}}
    
    private static final char VIDE = '~';
    private static final char BATEAU = 'B';
    private static final char TOUCHE = '*';
    private static final char INCONNU = '.';
}
