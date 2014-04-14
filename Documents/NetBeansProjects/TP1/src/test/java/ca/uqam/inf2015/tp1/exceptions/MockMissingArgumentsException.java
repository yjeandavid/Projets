package ca.uqam.inf2015.tp1.exceptions;

import java.util.ArrayList;
import java.util.List;


public class MockMissingArgumentsException extends MissingArgumentsException {
     public List<String> fichier = new ArrayList<String>() ;
     
     
     public void souleverException() {
         fichier.add("Vous devez donner 2 fichiers .json en entree.");
        
    }
    
}
