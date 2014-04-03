package ca.uqam.inf2015.tp1.exceptions;

public class MissingArgumentsException extends Exception {
    public void souleverException() {
        System.out.println("Vous devez donner 2 fichiers .json en entree.");
    }
}


