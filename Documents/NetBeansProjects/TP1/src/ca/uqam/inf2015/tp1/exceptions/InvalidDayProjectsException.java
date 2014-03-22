package ca.uqam.inf2015.tp1.exceptions;

public class InvalidDayProjectsException extends Exception {
    public void souleverException() {
        System.out.println("Au moins un des jours du fichier JSON contient plusieurs activités du même code.");
    }
}
