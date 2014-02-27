package ca.uqam.inf2015.tp1.feuilleDeTemps;

import ca.uqam.inf2015.tp1.application.AppConfig;

public class Projet {

    private int noProjet;
    private double minutes;
    
    public static Projet buildProjet(int noProjet, double minutes)
    {
    	return new Projet(noProjet, minutes);			
    }
    
    private Projet(int noProjet, double minutes)
    {
    	setNoProjet(noProjet);
    	setMinutes(minutes);
    }
    
    public int getNoProjet()
    {
        return noProjet;
    }
    
    public double getMinutes()
    {
        return minutes;
    }
    
    public void setNoProjet(int noProjet)
    {
        this.noProjet = noProjet;
    }
    
    public void setMinutes(double minutes)
    {
        this.minutes = minutes;
    }
    
    public boolean IsTeleTravail()
    {
         boolean isTeleTravail = false;
            if (noProjet >= AppConfig.CODE_REF_TELE_TRAVAIL
             && noProjet != AppConfig.CODE_REF_CONGES_FERIES
             && noProjet != AppConfig.CODE_REF_CONGES_MALADIE) 
            {
                isTeleTravail = true;
            }
        return isTeleTravail;
    }
    
    public boolean IsCongesMaladie()
    {
        return TypeProjet(AppConfig.CODE_REF_CONGES_MALADIE);
    }
    
    public boolean IsCongesFeries()
    {
        return TypeProjet(AppConfig.CODE_REF_CONGES_FERIES);
    }
    private boolean TypeProjet(int typeProjet)
    {
        boolean istypeProjet = false;
            if (noProjet == typeProjet) 
            {
                istypeProjet = true;
            }
        return istypeProjet;
    }
    
    
    
    
}
