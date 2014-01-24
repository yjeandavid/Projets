/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import inf2015_projet1.FeuilleDeTemps;

/**
 *
 * @author Michael
 */
public abstract class IEmploye {
    protected int noEmploye;
    protected int minHeureDeBureauParJour;
    protected int minHeureDeBureauParSemaine;
    protected int heureDeBureauParSemaine;
    protected int heureTeleTravailParSemaine;
    protected int plafondHeureBureauSemaine;
    protected FeuilleDeTemps[] feuillesDeTemps;
    protected String message;
    
    public abstract void traiterFeuillesDeTemps();
    
    public String getMessage()
    {
        return message.substring(0, (message.length()-3));
    }
}
