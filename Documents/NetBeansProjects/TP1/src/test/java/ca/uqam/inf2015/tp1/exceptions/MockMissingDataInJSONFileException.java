package ca.uqam.inf2015.tp1.exceptions;

import java.util.ArrayList;
import java.util.List;


public class MockMissingDataInJSONFileException extends MissingDataInJSONFileException {
    public List<String> fichier = new ArrayList<String>() ;
    
    public void souleverException() {
        fichier.add("Le fichier JSON d'entrée contient une (ou plusieurs) erreur(s).");
    }
    
}
