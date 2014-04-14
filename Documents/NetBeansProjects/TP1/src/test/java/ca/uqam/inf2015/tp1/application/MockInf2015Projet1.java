package ca.uqam.inf2015.tp1.application;

import java.util.ArrayList;
import java.util.List;


public class MockInf2015Projet1 extends Inf2015Projet1 {
    public static List<String> fichier = new ArrayList<String>() ;
    
    public static void main(String[] args) {
        fichier.add(args[0]);
        fichier.add(args[1]);
    }
    
    
    
    public String getItem(int i){
       return fichier.get(i);
    }
    
    
    
}
