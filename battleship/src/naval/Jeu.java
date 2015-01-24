package naval;

import java.util.InputMismatchException;
import java.util.Scanner;
import naval.direction.*;
import naval.*;

public class Jeu {

    private Mer mer;

    public Jeu(int nl, int nc) {
        this.mer = new Mer(nl, nc);
    }

    public void init() throws IllegalStateException {
	/*   Random alea = new Random();
	     alea.nextInt(Integer.parseInt(args[0])); 

		Je détaille dans le README */
        this.mer.poseBateau(new Bateau(3), new Position(2, 3), new DirectionEst());
        this.mer.poseBateau(new Bateau(4), new Position(6, 5), new DirectionNord());
    }

    public void joue() {
        System.out.println("Saisissez les coordonnees de la case (x,y) visee sous la forme : x y, exemple : 3 2");
        System.out.println("Pour arreter la partie, entrer une coordonnee x negative.");

        Scanner in = new Scanner(System.in);
        boolean fini = false;
        while (!fini) {
            this.mer.affichage(false);
            try {
                System.out.print("x y ? ");
                int x = in.nextInt();
                if (x < 0) {
                    fini = true;
                }
                if (!fini) {
                    int y = in.nextInt();
                    System.out.println(this.mer.vise(new Position(x, y)));
                    fini = this.mer.estVide();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            } catch (InputMismatchException e) {
                in.skip(".*");
            }
        }
        System.out.println("Voici ou etaient les bateaux : ");
        this.mer.affichage(true);
        System.out.println("See you next time! ");
    }

    /** Main method setting a battleship game on a Mer of 9 * 9 Case.
     */
    public static void main(String[] args) {
        Jeu jeu = new Jeu(9,9);
        try {
            jeu.init();
            jeu.joue();
        } catch (IllegalStateException e) {
            System.out.println("Partie impossible : bateaux non poses.");
        }
    }

}
 
