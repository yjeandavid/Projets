/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.tp1.exceptions;

/**
 *
 * @author Michael
 */
public class MissingDataInJSONFileException extends Exception{
    public void souleverException()
    {
        System.out.println("Le fichier JSON d'entrée contient une (ou plusieurs) erreur(s)");
        System.exit(1);
    }
}
