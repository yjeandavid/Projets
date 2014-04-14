package ca.uqam.inf2015.tp1.application;

import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.employe.EmployeFactory;
import ca.uqam.inf2015.tp1.exceptions.MissingArgumentsException;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import ca.uqam.inf2015.tp1.gestionDonnees.JsonFactory;
import ca.uqam.inf2015.tp1.validation.Validation;
import ca.uqam.inf2015.tp1.validation.ValidationFactory;
import net.sf.json.JSONArray;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Inf2015Projet1 {
    public static void main(String[] args) {
        String messgeValidation;

        try {
            initilisationApplication(args);
            messgeValidation = executerApplication(args[0]);
            genererResultat(messgeValidation, args[1]);
        } catch (MissingArgumentsException | IOException | MissingDataInJSONFileException ex) {
            gererException(ex);

            try {
                JsonFactory.EcrireFichierJson(args[1], new JSONArray());
            } catch (IOException ex1) {
                System.out.println(ex1.getMessage());
            }
        }
    }

    private static void initilisationApplication(String[] args) throws MissingArgumentsException, IOException {
        valideNbArgument(args);
        ChargerConfigurations();
    }

    private static void valideNbArgument(String[] args) throws MissingArgumentsException {
        if (args.length < 2) {
            throw new MissingArgumentsException();
        }
    }

    private static void ChargerConfigurations() throws IOException {
        AppConfig.chargerParametres();
    }

    private static String executerApplication(String jsonFile) throws MissingDataInJSONFileException, IOException {
        List<Employe> employes;

        employes = EmployeFactory.construireEmployeAPartirDeFichierJson(jsonFile);

        return validerFeuilleDeTemps(employes);
    }

    private static String validerFeuilleDeTemps(List<Employe> employes) throws IOException {
        String messageValidation = "";

        for (int i = 0; i < employes.size(); ++i) {
            Employe anEmployee = employes.get(i);
            Validation validation = ValidationFactory.construireValidationEmploye(anEmployee);
            messageValidation += validation.validerFeuilleDeTemps();
        }

        return messageValidation;
    }

    private static void genererResultat(String messageValidation, String fichierResultat) throws IOException {
        JsonFactory.construireFichierJson(fichierResultat, messageValidation);
    }

    private static void gererException(Exception e) {
        if (e instanceof MissingArgumentsException) {
            MissingArgumentsException MAe = (MissingArgumentsException) e;

            MAe.souleverException();
        } else if (e instanceof MissingDataInJSONFileException) {
            MissingDataInJSONFileException MDJFe = (MissingDataInJSONFileException) e;

            MDJFe.souleverException();
        }  else {
            Logger.getLogger(Inf2015Projet1.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}


