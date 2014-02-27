package ca.uqam.inf2015.tp1.employe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;

import ca.uqam.inf2015.tp1.application.AppConfig;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import ca.uqam.inf2015.tp1.feuilleDeTemps.FeuilleDeTemps;
import ca.uqam.inf2015.tp1.feuilleDeTemps.ProjectFactory;

public abstract class EmployeFactory 
{
	private static JSONObject rootElt;
	
	public static List<Employe> buildEmployesFromJsonFile(String filePath)
                 throws MissingDataInJSONFileException
	{		
		List<Employe> employes = null;
		
		try {
			init(filePath);
			employes = parseJsonFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employes;
	}
	
	private static void init(String filePath) throws FileNotFoundException, IOException
	{	
		rootElt = JSONObject.fromObject(IOUtils.toString(new FileInputStream(filePath),
                        StandardCharsets.UTF_8));
	}
	
	private static List<Employe> parseJsonFile() 
                throws IOException, MissingDataInJSONFileException
    {
        List<Employe> employes = new ArrayList<>();
        
		// Etant donne que pour cette phase il n'y a que 1 employe par fichier,
        // il sera ajoute directement a la liste. faire une boucle for du genre
        // for (int i = 0; i < rootElt.size(); i++)		
		employes.add(buildEmploye(rootElt.getInt(AppConfig.CLE_NO_EMPLOYE)));
		
        return employes;
    }
	
	private static Employe buildEmploye(int noEmploye)  throws MissingDataInJSONFileException
	{
		Employe employe = new Employe(noEmploye);
		FeuilleDeTemps timeSheet = new FeuilleDeTemps();
		
		timeSheet.setJours(ProjectFactory.buildProjectFromJsonFile(rootElt));
		employe.setfFeuilleDeTemps(timeSheet);
                employe.setHeuresDeBureauParSemaine();
                employe.setHeuresDeTeleTravailParSemaine();
		
		return employe;
	}
}
