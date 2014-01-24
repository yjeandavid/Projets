/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015_projet1;

import Configurations.Settings;
import Implementation.Bureau;
import Implementation.TeleTravail;
import Interfaces.IProjet;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Michael
 */
public class FeuilleDeTemps {
    private int noEmploye;
    private IProjet jour1[];
    private IProjet jour2[];
    private IProjet jour3[];
    private IProjet jour4[];
    private IProjet jour5[];
    private IProjet weekend1[];
    private IProjet weekend2[];
    
    public FeuilleDeTemps(JSONObject jsonObject)
    {
        noEmploye = jsonObject.getInt("numero_employe");
        JSONArray jour = jsonObject.getJSONArray("jour1");
        jour1 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("jour2");
        jour2 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("jour3");
        jour3 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("jour4");
        jour4 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("jour5");
        jour5 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("weekend1");
        weekend1 = traiterJourJSON(jour);
        jour = jsonObject.getJSONArray("weekend2");
        weekend2 = traiterJourJSON(jour);
    }
    
    private IProjet[] traiterJourJSON(JSONArray jsonArray)
    {
        IProjet resultat[] = new IProjet[jsonArray.size()];
        int i = 0;
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext())
        {
            JSONObject obj2 = (JSONObject) iterator.next();
            if (obj2.getInt("projet") < Settings.CODE_REF_TELE_TRAVAIL)
               resultat[i] = new Bureau(obj2);
            else
               resultat[i] = new TeleTravail(obj2);
            ++i;
        }
        return resultat;
    }
    
    
    public int getNoEmploye()
    {
        return noEmploye;
    }
    
    public IProjet[] getJour1()
    {
        return jour1;
    }
    
    public IProjet[] getJour2()
    {
        return jour2;
    }
    
    public IProjet[] getJour3()
    {
        return jour3;
    }
    
    public IProjet[] getJour4()
    {
        return jour4;
    }
    
    public IProjet[] getJour5()
    {
        return jour5;
    }
    
    public IProjet[] getWeekend1()
    {
        return weekend1;
    }
    
    public IProjet[] getWeekend2()
    {
        return weekend2;
    }
}
