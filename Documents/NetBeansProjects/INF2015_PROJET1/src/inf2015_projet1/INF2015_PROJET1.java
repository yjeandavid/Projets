package inf2015_projet1;

/**
 *
 * @author Michael
 */
import Configurations.Settings;
import Implementation.EmployeAdministration;
import Implementation.EmployeNormal;
import Interfaces.IEmploye;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONSerializer;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;

public class INF2015_PROJET1 {
    /**
     * @param args deux fichiers json le premier represente le fichier d'entree
     *                                le second represente le fichier de sortie
     */
    public static void main(String[] args) throws IOException {       
	
	if (args.length < 2)
	{
            System.out.println("Vous devez donner 2 fichiers .json "
                    + "en entrée.");
            System.exit(1);
	} else
	{
            IEmploye listEmploye[] = lireFichier(args[0]);
            JSONArray listResult = new JSONArray();
            
            for (int i = 0; i < listEmploye.length; ++i)
            {
                listEmploye[i].traiterFeuillesDeTemps();
                String result[] = listEmploye[i].getMessage().split(",");
                for (int j = 0; j < result.length; ++j)
                    listResult.add(result[i]);
            }
            FileWriter fw = new FileWriter(args[1]);
            fw = (FileWriter) listResult.write(fw);
            fw.flush();
            fw.close();
	}
    }
    
    private static IEmploye[] lireFichier(String filePath) throws IOException
    {
        String jsontxt = FileUtils.readFileToString(new File(filePath),"UTF-8");
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsontxt);
        IEmploye lEmploye[] = new IEmploye[1];
        
        if (jsonObject.getInt("numero_employe") >= 
                Settings.CODE_REF_TYPE_EMPLOYE)
            lEmploye[0] = new EmployeNormal(jsonObject);
        else
            lEmploye[0] = new EmployeAdministration(jsonObject);
        
        return lEmploye;
    }
    
}
