package ca.uqam.inf2015.tp1.exceptions;

public class MissingDataInJSONFileException extends Exception {
    public void souleverException() {
        System.out.println("Le fichier JSON d'entrée contient une (ou plusieurs) erreur(s).");
    }
}


