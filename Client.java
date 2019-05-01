package tp.factory.log;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Createur createur = new Createur();
        IdRequest choice = createur.factoryMethode(false);
        choice.natureRequest("bonjour");
        choice.natureRequest("comment");
        choice.natureRequest("tu");
        choice.natureRequest("vas");
    }
}
