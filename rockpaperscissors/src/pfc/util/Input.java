/**
 * Une classe utilitaire pour la saisie de chaines ou d'entiers sur l'entrée standard.
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package pfc.util;

import java.io.IOException;
import java.util.Scanner;

public class Input {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * permet la saisie d'une chaîne sur l'entrée standard
	 * 
	 * @return la chaine saisie
	 */
	public static String readString() {
			return Input.scanner.next();
	}

	/**
	 * permet la saisie d'un entier sur l'entrée standard
	 * 
	 * @return l'entier saisi
	 * @exception java.io.IOException si la saisie ne correspond par un entier
	 */
	public static int readInt() throws java.io.IOException {
		try {
			return Input.scanner.nextInt();
		} catch (Exception e) {
			Input.scanner.skip(".*");
			throw new java.io.IOException();
		}
	}

	
	// pour le test
	public static void main(String[] args) {
		
			System.out.print(" chaine : ? ");
			String chaineLue = Input.readString();
			System.out.println("lue  => " + chaineLue);
		int intLu;
		try {
			System.out.print(" int : ? ");
			intLu = Input.readInt();
			System.out.println("lu  => " + intLu);
		} catch (java.io.IOException e) {
		    //"exception... : la saisie n'est pas un entier";
		    // on peut par exemple ici fournir une valeur par défaut : 
		    intLu = 0;
      		    System.out.println("corrigé  => " + intLu);
		}
	
	}
}// Input
