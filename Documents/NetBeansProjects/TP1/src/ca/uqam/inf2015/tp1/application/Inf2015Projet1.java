package ca.uqam.inf2015.tp1.application;

import java.io.IOException;
import java.util.List;

import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.employe.EmployeFactory;
import ca.uqam.inf2015.tp1.exceptions.MissingArgumentsException;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import ca.uqam.inf2015.tp1.gestionDonnees.JsonFactory;

public class Inf2015Projet1 {

	/**
	 * @param args
	 *            deux fichiers json le premier represente le fichier d'entree
	 *            le second represente le fichier de sortie
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<Employe> employes;
                String messageValidation = "";
                
                try {
                    if (args.length < 2)
                        throw new MissingArgumentsException();
                    
                    employes = EmployeFactory.buildEmployesFromJsonFile(args[0]);

                    for(int i = 0; i < employes.size(); ++i) {
                        Employe anEmployee = employes.get(i);
                        messageValidation += anEmployee.validerFeuilleDeTemps();
                    }
                } catch (MissingDataInJSONFileException mdijfe) {
                    mdijfe.souleverException();
                } catch (MissingArgumentsException mae) {
                    mae.souleverException();
                } finally {
                    JsonFactory.buildJsonFile(args[1], messageValidation);
                }
	}
}
