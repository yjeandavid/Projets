package ca.uqam.inf2015.tp1.exceptions;

public class InvalidProjectMinutesException extends Exception {
    public void souleverException() {
        System.out.println("Le fichier JSON contient un ou plusieurs projets de 0 minute.");
    }
}
