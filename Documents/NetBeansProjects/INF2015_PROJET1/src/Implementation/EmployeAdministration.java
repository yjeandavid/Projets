package Implementation;

import Configurations.Settings;
import Interfaces.IEmploye;
import Interfaces.IProjet;
import inf2015_projet1.FeuilleDeTemps;
import net.sf.json.JSONObject;

/**
 *
 * @author Michael
 */
public class EmployeAdministration extends IEmploye {
    private int plafondHeureTeleTravail = 
            Settings.MAXIMUM_MINUTES_TELE_TRAVAIL_ADMIN_SEMAINE;
    
    public EmployeAdministration(JSONObject jsonObject)
    {
        noEmploye = jsonObject.getInt("numero_employe");
        message = "";
        minHeureDeBureauParJour = 
                Settings.MINIMUM_MINUTES_BUREAU_ADMIN_PAR_JOUR;
        minHeureDeBureauParSemaine =
                Settings.MINIMUM_MINUTES_BUREAU_ADMIN_SEMAINE;
        heureDeBureauParSemaine = 0;
        heureTeleTravailParSemaine = 0;
        plafondHeureBureauSemaine =
                Settings.MAXIMUM_MINUTES_BUREAU_EMPLOYE_SEMAINE;
        feuillesDeTemps = new FeuilleDeTemps[1];
        feuillesDeTemps[0] = new FeuilleDeTemps(jsonObject);
    }
    
    @Override
    public void traiterFeuillesDeTemps()
    {
        traiteFeuilleDeTemps(minHeureDeBureauParJour,
                minHeureDeBureauParSemaine, 
                plafondHeureBureauSemaine, 
                plafondHeureTeleTravail, 
                feuillesDeTemps);
    }
    
    private void traiterJour(IProjet[] jourArray, int minHeureTravBuro)
    {
        int minuteTravailBureauJour = 0;
        for (int i = 0; i < jourArray.length; ++i)
        {
            if (jourArray[i].getNoProjet() < Settings.CODE_REF_TELE_TRAVAIL)
               minuteTravailBureauJour += jourArray[i].getMinutes();
            else
               heureTeleTravailParSemaine += jourArray[i].getMinutes();
        }
        heureDeBureauParSemaine += minuteTravailBureauJour;
        
        if (minuteTravailBureauJour < minHeureTravBuro)
           message += Settings.MSG_HEURES_MINIMUM_JOUR_BUREAU + ',';
    }
    
    private void traiteFeuilleDeTemps(int minMinuteBureauJour,
            int minMinuteBureauSemaine, int maxMinuteBureauSemaine,
            int maxMinuteTeleTravail, FeuilleDeTemps[] feuillesDeTemps)
    {
        for (int i = 0; i < feuillesDeTemps.length; ++i)
        {
            traiterJour(feuillesDeTemps[i].getJour1(), 
                    minMinuteBureauJour);
            traiterJour(feuillesDeTemps[i].getJour2(), 
                    minMinuteBureauJour);
            traiterJour(feuillesDeTemps[i].getJour3(), 
                    minMinuteBureauJour);
            traiterJour(feuillesDeTemps[i].getJour4(), 
                    minMinuteBureauJour);
            traiterJour(feuillesDeTemps[i].getJour5(), 
                    minMinuteBureauJour);
            traiterJour(feuillesDeTemps[i].getWeekend1(), 0);
            traiterJour(feuillesDeTemps[i].getWeekend2(), 0);
        }
        
        if (heureDeBureauParSemaine < minMinuteBureauSemaine)
            message += Settings.MSG_HEURES_MINIMUM_SEMAINE_BUREAU + ',';
        else if (heureDeBureauParSemaine > maxMinuteBureauSemaine)
            message += Settings.MSG_HEURES_MAXIMAL_BUREAU + ',';

        if (heureTeleTravailParSemaine > maxMinuteTeleTravail)
            message += Settings.MSG_HEURES_MAXIMAL_TELE_TRAVAIL + ',';
    }
}
