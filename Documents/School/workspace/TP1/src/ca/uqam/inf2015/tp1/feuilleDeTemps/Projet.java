package ca.uqam.inf2015.tp1.feuilleDeTemps;

public class Projet {

	private int noProjet;
    private double minutes;
    private int typeProjet;
    
    public Projet(int noProjet, double minutes)
    {
    	setNoProjet(noProjet);
    	setMinutes(minutes);
    	setTypeProjet();
    }
    
    public int getNoProjet()
    {
        return noProjet;
    }
    
    public double getMinutes()
    {
        return minutes;
    }
    
    public int getTypeProjet()
    {
    	return typeProjet;
	}
    
    public void setNoProjet(int noProjet)
    {
        this.noProjet = noProjet;
    }
    
    public void setMinutes(double minutes)
    {
        this.minutes = minutes;
    }
    
    private void setTypeProjet()
    {
    	
    }
}
