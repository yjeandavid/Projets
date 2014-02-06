/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Michael
 */
public abstract class IProjet {
    private int noProjet;
    private int minutes;
    
    public int getNoProjet()
    {
        return noProjet;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public void setNoProjet(int numeroProjet)
    {
        noProjet = numeroProjet;
    }
    
    public void setMinutes(int minute)
    {
        minutes = minute;
    }
}
