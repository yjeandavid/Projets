/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.tp1.test;

import ca.uqam.inf2015.tp1.employe.Employe;
import ca.uqam.inf2015.tp1.employe.EmployeFactory;
import ca.uqam.inf2015.tp1.exceptions.MissingDataInJSONFileException;
import java.io.IOException;
import java.util.List;


public class Test 
{
   public static void main(String[] args) throws IOException, MissingDataInJSONFileException 
   {
       int nombreCas = 15;
          for(int cas = 1;  cas <= nombreCas; cas++)
          {
             System.out.println("Debut Test Cas"+cas);
             test("Cas"+cas+".json"); 
             System.out.println("Fin Test Cas"+cas+"\n");
          }
       
           
   } 
   
   public static void test(String filePath) throws MissingDataInJSONFileException
   {
       List<Employe> employes = EmployeFactory.buildEmployesFromJsonFile(filePath);
       String messageValidation = "";
       
       for(int i = 0; i < employes.size(); ++i)
       {
          Employe anEmployee = employes.get(i);
          messageValidation += anEmployee.validerFeuilleDeTemps();
       }
       System.out.println(messageValidation);
   }
   
}
