# Patron_Methode_de_Fabrique

Nous allons dans cet mini projet implementer le patron methode de fabrique qui pour le resumer permet d'instancier un objet en fonction des
parametres ou arguments envoyés.

Nous allons pour cela suivre l'architecture ci-dessous : (:sweat_smile: les fleches ne suivent pas les regles, nous l'avouons mais 
permet tout de moin d'avoir une idée de l'organistion de nos classes :relieved:)

![alt tag](https://github.com/Kabore-Donatien-Gueswende/Patron_Methode_de_Fabrique/blob/master/img/Architecteur%20simplifier.PNG)

L'objectif finale etant de creer un fichier log ou ecrire dans le console, le contenu envoyer par le client

Nous allons donc commencer par creer les deux interfaces: 


    public interface IdRequest {
        public void natureRequest (String text);
    }



    public abstract class AbstratorCreateur {
      public abstract IdRequest factoryMethode(boolean a);
    }
    
nous mettons en place les deux objets (fichier.java et console.java) qui implments l'interface IdRequest
    
    public class Fichier implements IdRequest {

        public void natureRequest(String text) {
            try {
                  File fichier = new File("C:\\Chemin\\du\\fichier\\file.txt");
                  FileWriter fichiers = new FileWriter(fichier, true);
                  fichiers.write (text);
                  fichiers.write("\n");
                  fichiers.close();           
            }catch (Exception e) {
                System.out.println("Erreur");
            }
        }
     }
     
Notons que le fichier file.txt doit etre creer à l'emplacement indiqué.
     
     
        public class Console implements IdRequest {
            public void natureRequest(String text) {
            System.out.println(text);
            }
        }
      
Pas vraiment de commentaire sur la classe console.
   
Creons la classe Createur, la classe qui permet d'intansié le l'objet demander par le client : 
   
         public class Createur extends AbstratorCreateur{
              public IdRequest factoryMethode(boolean a) {
                  if (a) {
                      IdRequest p = new Console();
                      return p;
                  }else {
                      IdRequest p = new Fichier();
                      return p;
                  }
              }
          }
      
  Grace a une valeur booleene, nous pouvons intansier l'objet requis pour la requete.
  
  Nous pouvons passer au test avec la classe suivante :
  
          public class Client {
            public static void main(String[] args) {
                Createur createur = new Createur();
                IdRequest choice = createur.factoryMethode(false);
                choice.natureRequest("bonjour");
                choice.natureRequest("comment");
                choice.natureRequest("tu");
                choice.natureRequest("vas");
            }
        }
  
  
  Avec une valeur false passé en parametre nous obtenu ceci :
  
  ![alt tag](https://github.com/Kabore-Donatien-Gueswende/Patron_Methode_de_Fabrique/blob/master/img/resultat%20fichierLog.PNG)
  
  dans le cas contraire :
  
  ![alt tag](https://github.com/Kabore-Donatien-Gueswende/Patron_Methode_de_Fabrique/blob/master/img/resultat%20console.PNG)
  
  
  En conclusion nous retenons que le patron methode de fabrique est utile lorsque nous gerons plusieurs objets qui doivent s'excecuter
  en fonction des parametre de la classe appelante.
