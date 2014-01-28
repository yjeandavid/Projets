import java.util.Random;

/**
 * I N F 1 1 2 0 - TP2 hiver 2009
 *
 * Classe fournie pour le Tp2
 * 
 * ==============================> Placez cette classe dans votre projet
 * 
 * @author Louise Laforest 
 */


public class JeuArithmetique {

	private  static final int FACILE = 1;
	private  static final int MOYEN = 3;
	private  static final int DIFFICILE = 4;
	private  static final int EXTREME = 5;
	private static int degreDifficulte = FACILE;
	private static int germe = 25;
	private static Random generateur = new Random(germe);

	private static final int OP_MIN_FACILE = 1;
	private static final int OP_MAX_FACILE = 20;
	private static final int OP_MIN_MOYEN = 1;
	private static final int OP_MAX_MOYEN = 50;
	private static final int OP_MIN_DIFFICILE = -25;
	private static final int OP_MAX_DIFFICILE = 25;
	private static final int OP_MIN_EXTREME = 0;
	private static final int OP_MAX_EXTREME = 0;

	
	private static String operations = "+-*/%^";

	
	
	public static int getFacile() {
		return FACILE;
	}

	public static int getMoyen() {
		return MOYEN;
	}

	public static int getDifficile() {
		return DIFFICILE;
	}

	/**
	 * Permet de definir le degre de difficulte. FACILE : operations + et -,
	 * operandes entre 1 et 20 inclusivement MOYEN : operations +, -, *, et /,
	 * operandes entre 1 et 50 inclusivement DIFFICILE : operations +, -, *, /
	 * et %, operandes entre -25 et 25 inclusivement (sauf 0)
	 * 
	 * @param degre
	 *            degre de difficulte. Si autre que FACILE, MOYEN ou DIFFICILE,
	 *            FACILE sera choisi.
	 */
	public static  void choisirDegreDifficulte(int degre) {
		if (degre == MOYEN || degre == DIFFICILE) {
			degreDifficulte = degre;
		} else if(degre == FACILE){
			degreDifficulte = FACILE;
		} else{
			degreDifficulte = EXTREME;
		}
	} // choisirDegreDifficulte

	/**
	 * Retourne une operation choisie au hasard en fonction du degre de
	 * difficulte choisi
	 * 
	 * @return le caractere correspondant a l'operation
	 */
	public static char operationAuHasard() {
		
		return operations.charAt(nombreAleatoire(0, degreDifficulte));
	} // operationAuHasard

	/**
	 * Retourne un nombre choisi au hasard en fonction du degre de difficulte
	 * choisi
	 * 
	 * @return le nombre choisi au hasard
	 */
	public static int operandeAuHasard() {
		int reponse;
		if (degreDifficulte == FACILE) {
			reponse = nombreAleatoire(OP_MIN_FACILE, OP_MAX_FACILE);
		} else if (degreDifficulte == MOYEN) {
			reponse = nombreAleatoire(OP_MIN_MOYEN, OP_MAX_MOYEN);
		} else {
			do {
				reponse = nombreAleatoire(OP_MIN_DIFFICILE, OP_MAX_DIFFICILE);
			} while (reponse == 0);
		}
		return reponse;
	} // operandeAuHasard


	private static int nombreAleatoire(int min, int max) {
		int reponse;
		if (min > max) {
			reponse = 0;
		} else {
			
			reponse = (int) Math.floor((max - min + 1)
					* generateur.nextDouble())
					+ min;
			System.out.println(generateur.nextDouble());
		}
		return reponse;
	} // nombreAleatoire

} // JeuArithmetique
