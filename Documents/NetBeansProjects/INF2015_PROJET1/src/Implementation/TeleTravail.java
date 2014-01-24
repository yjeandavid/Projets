/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.IProjet;
import net.sf.json.JSONObject;

/**
 *
 * @author Michael
 */
public class TeleTravail extends IProjet {
    
    public TeleTravail(JSONObject jsonObject)
    {
        setNoProjet(jsonObject.getInt("projet"));
        setMinutes(jsonObject.getInt("minutes"));
    }
}
