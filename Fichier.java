package tp.factory.log;

import java.io.File;
import java.io.FileWriter;

public class Fichier implements IdRequest {

    @Override
    public void natureRequest(String text) {
        // TODO Auto-generated method stub
        try {
            File fichier = new File("C:\\Users\\Kabore Donatien\\eclipse-workspace\\projetEtude\\src\\tp\\factory\\log\\file.txt");
            FileWriter fichiers = new FileWriter(fichier, true);
            fichiers.write (text);
            fichiers.write("\n");
            fichiers.close();           
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur");
        }
    }
}
