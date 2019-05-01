package tp.factory.log;

public class Createur extends AbstratorCreateur{

    @Override
    public IdRequest factoryMethode(boolean a) {
        // TODO Auto-generated method stub
       if (a) {
           IdRequest p = new Console();
           return p;
       }else {
           IdRequest p = new Fichier();
           return p;
       }
    }

}
