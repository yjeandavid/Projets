package ca.uqam.inf2015.tp1.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.employe.EmployeFactory;

public class ValidationFeuilleDeTemps {

	/**
	 * @param args
	 *            deux fichiers json le premier represente le fichier d'entree
	 *            le second represente le fichier de sortie
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		List<Employe> employes;
		
		if (args.length < 2) {
			System.out.println("Vous devez donner 2 fichiers .json "
					+ "en entrée.");
			System.exit(1);
		}
		
		employes = new ArrayList<>();
		
		EmployeFactory.buildEmployesFromJsonFile(args[0]);
		
		// faire validation regle d'affaire
		
	}
	
	
}
