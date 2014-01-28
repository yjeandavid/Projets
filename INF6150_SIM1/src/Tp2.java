public class Tp2 {

    
    
  public static String saisirDegreDifficulte(){
    String level = "";// degre de difficulte
    boolean acces =true ;
   do{
    System.out.print("Choisissez un degre de difficulte (facile, moyen ou difficile ou extreme) : ");// saisir le degre de difficulte
    level = Clavier.lireString(); // valider le degre de difficulte

    if( level.compareTo("facile")==0 || level.compareTo("moyen")==0 || level.compareTo("difficile")==0 || level.compareTo("MOYEN")==0 || level.compareTo("FACILE")==0 || level.compareTo("DIFFICILE")==0 || level.compareTo("extreme") == 0){// si l utilisateur veut effectuer une operation
       acces = false   ;
   }else{
   System.out.println("*** choix invalide");// si le choix est invalide
    }
    }while(acces);
    
    return level;
    }
    
    
   public static String saisirReponseOuiNon(){
    String reponse = "";
    boolean acces1 =true ;
   do{
    System.out.println("");   
    System.out.print("Voulez-vous effectuer une operation (repondez par o ou n) ? ");
    reponse = Clavier.lireString();

    if( reponse.compareTo("o")==0 || reponse.compareTo("n")==0 || reponse.compareTo("O")==0 || reponse.compareTo("N")==0 || reponse.compareTo("oui")==0 || reponse.compareTo("non")==0|| reponse.compareTo("OUI")==0 || reponse.compareTo("NON")==0){
       acces1 = false   ;
   }else{
   System.out.println("*** choix invalide");
    }
    }while(acces1);
    
    return reponse;
    } 
  
    
    
    
    
    public static void main (String[] params) {
    String nom = "" ;    //nom de l utilisateur 
    String difficulte = "" ; // la difficulte de l opertaion   
    String choix="";
    int operande1 ,operande2, correction = 0, resultat = 0;// les 2 nombres necessaire pour faire les calculs et le resultat obtenu et la correction si l utilisateur echoue apres 3 tentatives
    boolean acces2 = true;
    boolean acces3 = true;
    int i =0;
    int j =0;//compteur
    float score = 0;
    char operation = ' ';
    String pourcentage="";
    System.out.println("Ce programme demande a l utilisateur de saisir son nom, s il veut faire une operation, choisir le degre de difficulte,extreme et continue de proposer des operations arithmetiques tant que l utilisateur choisi oui,OUI,O ou o.et si l utilisateur choisi non il lui donne le resultat obtenu en fonction des operations faites et du nombre de tentatives faites avant de trouver le bon resultas(3 tentatives max)");
    
    System.out.print("Veuillez donner votre nom : ");
    nom = Clavier.lireString();
    
    System.out.println("Bienvenue "+nom+" !");
    difficulte = saisirDegreDifficulte();
    
    do{ 
      i=0;
      acces2 = true;
      choix = saisirReponseOuiNon();
       
      if(choix.compareTo("OUI")==0 || choix.compareTo("O")==0 || choix.compareTo("o")==0 || choix.compareTo("oui")==0 ){
      j++;  
      if(difficulte.compareTo("moyen")==0 || difficulte.compareTo("MOYEN")==0)
      {
         JeuArithmetique.choisirDegreDifficulte ( JeuArithmetique.getMoyen() );
      }
      if(difficulte.compareTo("facile")==0 || difficulte.compareTo("FACILE")==0)
      {
        JeuArithmetique.choisirDegreDifficulte ( JeuArithmetique.getFacile() );
      }
      if(difficulte.compareTo("difficile")==0 || difficulte.compareTo("DIFFICILE")==0)
      {
        JeuArithmetique.choisirDegreDifficulte ( JeuArithmetique.getDifficile() );
      }
      if(difficulte.compareTo("extreme")==0 || difficulte.compareTo("EXTREME")==0)
      {
        JeuArithmetique.choisirDegreDifficulte ( JeuArithmetique.getExtreme() );
      }
      operande1 = JeuArithmetique.operandeAuHasard ();
      operation = JeuArithmetique.operationAuHasard ();
      operande2 = JeuArithmetique.operandeAuHasard ();
      System.out.println(operande1+" "+operation+" "+operande2+" = ?" );
      
      System.out.println("");
      do{
      i++;    
      System.out.print("Entrez votre reponse : ");  
      resultat = Clavier.lireInt();
      if ( operation == '+')
      correction = operande1  + operande2 ;
      if ( operation == '*')
      correction = operande1  * operande2 ;
      if ( operation == '-')
      correction = operande1  - operande2 ;
      if ( operation == '/')
      correction = operande1  / operande2 ;
      if ( operation == '%')
      correction = operande1  % operande2 ;
      if ( operation == '^')
          correction = (int) Math.pow(operande1,operande2)    ;
      
      if(resultat == correction){
      System.out.println("Bravo "+nom+" ! Bonne reponse !");
      acces2=false;
      }
      else{ 
      System.out.println("Desole "+nom+", ce n'est pas la bonne reponse.");
     }
      if(i==3){
        System.out.println(nom+", la reponse est : "+correction);
        acces2 = false;
       }
      
      }while(acces2 );// ajouter la condition de s il trouve la reponse juste avant trois tentative.
     }else {
        
     score= (score/3)/j;
           if ( score < 0.45 ) {
             pourcentage = "mediocre";                            //le programme donnera la mention appropriee en fonction du score obtenu
           }else if ( ( score >= 0.45) && ( score < 0.60) ) {
             pourcentage = "passable";
           }else if ( ( score >= 0.60) && ( score < 0.75) ){
             pourcentage = "bien";
           }else if ( ( score >= 0.75) && ( score < 0.90) ) {
             pourcentage = "tres bien";
           }else if ( score >= 0.90) {
             pourcentage = "excellent";
           }  
     System.out.println("score = "+((int)Math.ceil(score*100))+" avec la mention: "+pourcentage);
     acces3= false;
     }
     
    score = score + 4 - i; 
  }while(acces3); 

  



    } // main
    
} // Tp2
