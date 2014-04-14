package ca.uqam.inf2015.tp1.validation;

import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.Projet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chrisictiantelemaque
 */
public class MockFeuilleDeTemps extends FeuilleDeTemps {
    public List<String> fichier = new ArrayList<>() ;
    
    public MockFeuilleDeTemps() {
        super();
        setJours(new  ArrayList<List<Projet>>());
    }
    
    @Override
    public List<List<Projet>> getJours() {
        return super.getJours();
    }

     @Override
    public void setJours(List<List<Projet>> jours) {
        super.setJours(jours);
    }
    
    @Override
    public double calculerHeuresBureauParSemaine(){
         double calaul = 0.0;
         return calaul;
         
     }
     
    @Override 
    public double calculerHeuresTeleTravailParSemaine(){
        double calaul = 0.0;
         return calaul;
          
      }
    
}
