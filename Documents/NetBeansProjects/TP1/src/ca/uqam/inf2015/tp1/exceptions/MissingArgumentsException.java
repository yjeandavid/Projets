/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.tp1.exceptions;

/**
 *
 * @author Michael
 */
public class MissingArgumentsException extends Exception{
    public void souleverException()
    {
        System.out.println("Vous devez donner 2 fichiers .json en entree.");
        System.exit(1);
    }
}
